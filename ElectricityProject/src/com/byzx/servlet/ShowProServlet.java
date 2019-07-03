package com.byzx.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.bean.Product;
import com.byzx.util.DBCUtil;
/**
 * 
 * @Description 前端商品详细信息
 * @author 景
 * @date 2019年4月28日 下午4:04:03
 * @version v1.0
 */
@WebServlet("/showPro")
public class ShowProServlet extends HttpServlet{

	private static final long serialVersionUID = 1749594480670567119L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ResultSet rs = null ;
		ResultSet rsb = null;
		//获取商品ID
		String proId = req.getParameter("proId");
		String sql = "";
		try {
			//用jdbc去数据库中查询商品信息
			sql = "SELECT * FROM `product` WHERE `pro_id` = " + proId;
			rs =  DBCUtil.findAll(sql);
			Product pt = null ;
			if(rs.next()){
				//将返回的数据封装Product对象
				pt = new Product(rs.getInt("pro_id"),
						rs.getInt("type_id"), rs.getInt("brand_id"),
						null, null,
						rs.getString("pro_name"), 0.0f,
						rs.getFloat("pro_sellprice"),
						rs.getString("pro_supply"),
						rs.getString("pro_address"), rs.getString("pro_pic"),
						rs.getFloat("inventory"), rs.getString("pro_up_down"),
						null, rs.getString("pro_start_date"),
						rs.getString("pro_end_date"));
			} 
			req.setAttribute("pt", pt);
			int brandId = pt.getBrandId();
			//推荐同类商品
			sql = "SELECT * FROM `product` WHERE `pro_id` <> "+proId+" AND product.`brand_id` = "+brandId+" LIMIT 3";
			rsb = DBCUtil.findAll(sql);
			List proList = new ArrayList();
			while (rsb.next()) {

				// 2.将返回的数据封装ProType对象
				Product pro = new Product(rsb.getInt("pro_id"),
						rsb.getInt("type_id"), rsb.getInt("brand_id"),
						null, null,
						rsb.getString("pro_name"), 0.0f,
						rsb.getFloat("pro_sellprice"),
						rsb.getString("pro_supply"),
						rsb.getString("pro_address"), rsb.getString("pro_pic"),
						rsb.getFloat("inventory"), rsb.getString("pro_up_down"),
						null, rsb.getString("pro_start_date"),
						rsb.getString("pro_end_date"));
				proList.add(pro);
			}

			// 返回页面
			req.setAttribute("proList", proList);
			req.getSession().setAttribute("proId", proId);
			req.getRequestDispatcher("/single.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsb);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rs);
		}
		
	
	}

	
}
