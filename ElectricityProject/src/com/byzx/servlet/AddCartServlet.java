package com.byzx.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.persistence.criteria.Order;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.byzx.bean.UserInfo;
import com.byzx.util.DBCUtil;
import com.byzx.util.GrenOrderNum;

/**
 * 
 * @Description 加入购物车
 * @author 景
 * @date 2019年4月28日 下午10:28:30
 * @version v1.0
 */
@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {

	private static final long serialVersionUID = -6307595471039121831L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 加入购物车
		String sql = "";
		ResultSet crs = null;
		ResultSet rst = null;
		ResultSet rs = null;
		try {
			// 1.获取用户信息和商品信息
			Object obj = req.getSession().getAttribute("username");
			UserInfo user = (UserInfo) obj;
			String proId = req.getParameter("proId");
			String proName = req.getParameter("proName");
			String proSellprice = req.getParameter("proSellprice");
			String proCount = req.getParameter("proCount");
			String proPic = req.getParameter("proPic");
			int orderId = 0;
			// 根据用户id查询当前用户购物车信息
			boolean isHave = false;
			sql = "SELECT `order_id` AS orderId FROM `order_info` WHERE user_id = "+ user.getUserId() + " and `cart_state` = '0'";
			crs = DBCUtil.findAll(sql);
			if (crs.next()) {
				isHave = true;
				orderId = crs.getInt("orderId");
			}

			int itemId = 0;
			if (isHave){// 已经有购物车
				// 查询此商品是否已经在购物车中
				sql = "SELECT `item_id` FROM `order_item` WHERE `pro_id`= "+ proId + " AND" + " `order_id` = " + orderId;
				rst = DBCUtil.findAll(sql);
				if (rst.next()) {
					itemId = rst.getInt("item_id");
			} 
			}else {
				// 没有购物车，生成购物订单
				sql = "INSERT INTO `order_info`(`order_num`,`user_id`,`cart_state`)"
						+ " VALUES('"+ GrenOrderNum.grenOrderNum()+ "',"+ user.getUserId() + ",'0')";
				DBCUtil.saveOrUpdate(sql);
				// 获取最新的订单id
				sql = "SELECT MAX(`order_id`) AS orderId FROM `order_info` WHERE user_id = " + user.getUserId();
				rs = DBCUtil.findAll(sql);
				if (rs.next()) {
					orderId = rs.getInt("orderId");
				}
			}

			// 保存购物车订单对应商品明细
			if (itemId > 0){
				// 购物车包含此商品
				sql = "UPDATE `order_item` SET `pro_count` = `pro_count`+" + proCount + " WHERE item_id=" + itemId;
				DBCUtil.saveOrUpdate(sql);

			} else {
				sql = "INSERT INTO `order_item` (`order_id`,`pro_id`,`pro_name`,`pro_price`,`pro_count`,`pro_pic` )"
						+ " VALUES ("+ orderId+ ","+ proId+ ",'"+ proName+ "'," + proSellprice + ",'" + proCount + "','" + proPic + "') ";
				DBCUtil.saveOrUpdate(sql);
			}
			

			// 跳转页面
			req.setAttribute("orderId", orderId);
			resp.sendRedirect(req.getContextPath() + "/cartShow?orderId="+orderId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rs);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rst);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, crs);
		}
	}

}
