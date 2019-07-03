package com.byzx.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.bean.Address;
import com.byzx.bean.UserInfo;
import com.byzx.util.DBCUtil;

/**
 * 
 * @Description ��������
 * @author ��
 * @date 2019��5��4�� ����1:48:55
 * @version v1.0
 */
@WebServlet("/buyImmediately")
public class BuyImmediatelyServlet extends HttpServlet {

	private static final long serialVersionUID = 136224731186074189L;

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
		String proSellprice = req.getParameter("proSellprice");
		String proCount = req.getParameter("proCount");
		String proPic = req.getParameter("proPic");
		String sql = "";
		float inventory = 0.0f;
		ResultSet rs = null;
		ResultSet rst = null;
		// �鿴��ѡ��Ʒ���
		try {
			// ��ѯ����Ʒ���
			sql = "SELECT * FROM `product` WHERE `pro_id` = " + proId;
			rs = DBCUtil.findAll(sql);
			while (rs.next()) {
				inventory = rs.getFloat("inventory");
			}
			// ����ܼ�
			float totalPrice = Float.parseFloat(proCount) * Float.parseFloat(proSellprice);
			// ������Ʒ��Ϣ
			req.setAttribute("proId", proId);
			req.setAttribute("proName", proName);
			req.setAttribute("proSellprice", proSellprice);
			req.setAttribute("proCount", proCount);
			req.setAttribute("proPic", proPic);
			// ��ȡ���û���ַ
			sql = "SELECT * FROM `address` WHERE `user_id` = " + user.getUserId();
			rst = DBCUtil.findAll(sql);
			Address address = null;
			List<Address> addrList = new ArrayList();
			while (rst.next()) {
				address = new Address(rst.getInt("addr_id"),
						rst.getInt("user_id"), rst.getString("addr_info"),
						null, rst.getString("reap_person"),
						rst.getString("phone"));
				addrList.add(address);
			}
			// ��תҳ��
			req.setAttribute("inventory", inventory);
			req.setAttribute("totalPrice", totalPrice);
			req.setAttribute("addrList", addrList);
			req.getRequestDispatcher("/buyImmediately.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rs);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rst);
		}
	}

}
