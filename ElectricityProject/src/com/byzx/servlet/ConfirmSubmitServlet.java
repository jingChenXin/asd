package com.byzx.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.bean.Address;
import com.byzx.bean.OrderInfo;
import com.byzx.bean.OrderItem;
import com.byzx.bean.UserInfo;
import com.byzx.util.DBCUtil;
import com.byzx.util.GrenOrderNum;

/**
 * 
 * @Description ȷ���ύ
 * @author ��
 * @date 2019��5��5�� ����10:11:05
 * @version v1.0
 */
@WebServlet("/confirmSubmit")
public class ConfirmSubmitServlet extends HttpServlet {

	private static final long serialVersionUID = 2334429125487217222L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Object obj = req.getSession().getAttribute("username");
		UserInfo user = (UserInfo) obj;
		String proId = req.getParameter("proId");
		String proName = req.getParameter("proName");
		String proCount = req.getParameter("proCount");
		String proSellprice = req.getParameter("proSellprice");
		String addrId = req.getParameter("addrId");
		String proPic = req.getParameter("proPic");
		System.out.println();
		int orderId = 0;
		String sql = "";
		ResultSet rsa = null;
		ResultSet rsb = null;
		ResultSet rsc = null;
		try {
			// ����ܼ�
			float totalPrice = Float.parseFloat(proCount)
					* Float.parseFloat(proSellprice);
			BigDecimal b = new BigDecimal(totalPrice);
			float totalPrices = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
			// �����µĹ��ﳵ ����һ���µ� ����Ψһ����
			sql = "INSERT INTO order_info (`order_num`,`user_id`,`addr_id`,`total_money`,`order_state`,`cart_state`)"
					+ " VALUES ('"+ GrenOrderNum.grenOrderNum()+ "',"+ user.getUserId()+ ","+ addrId+ ","+ totalPrices+ ",'0','1')";
			DBCUtil.saveOrUpdate(sql);
			// ��ȡ���µĶ���id
			sql = "SELECT MAX(`order_id`) AS orderId FROM `order_info` WHERE `cart_state` = '1' AND `user_id` = " + user.getUserId();
			rsa = DBCUtil.findAll(sql);
			if (rsa.next()) {
				orderId = rsa.getInt("orderId");
			}
			// ���湺�ﳵ������Ӧ����Ʒ��ϸ
			float singleMoney = Integer.parseInt(proCount) * Float.parseFloat(proSellprice);
			sql = "INSERT INTO `order_item` (`order_id`,`pro_id`,`pro_name`,`pro_price`,`pro_count`,`pro_pic`,`pro_total`)"
					+ " VALUES ("+ orderId+ ","+ proId+ ",'"+ proName+ "',"+ proSellprice+ ","+ proCount+ ",'"+ proPic+ "'," + singleMoney + ")";
			DBCUtil.saveOrUpdate(sql);

			// �޸���Ʒ��Ϣ���
			sql = "UPDATE `product` SET `inventory` = (`inventory` - " + proCount + " ) WHERE `pro_id` = " + proId;
			DBCUtil.saveOrUpdate(sql);

			req.setAttribute("orderId", orderId);
			req.setAttribute("totalPrice", totalPrice);
			req.getRequestDispatcher("/accomplish?orderId=" + orderId + "&proId=" + proId + "&addrId=" + addrId ).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsc);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsb);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsa);
		}
	}

}
