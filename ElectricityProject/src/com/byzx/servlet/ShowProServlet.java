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
 * @Description ǰ����Ʒ��ϸ��Ϣ
 * @author ��
 * @date 2019��4��28�� ����4:04:03
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
		//��ȡ��ƷID
		String proId = req.getParameter("proId");
		String sql = "";
		try {
			//��jdbcȥ���ݿ��в�ѯ��Ʒ��Ϣ
			sql = "SELECT * FROM `product` WHERE `pro_id` = " + proId;
			rs =  DBCUtil.findAll(sql);
			Product pt = null ;
			if(rs.next()){
				//�����ص����ݷ�װProduct����
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
			//�Ƽ�ͬ����Ʒ
			sql = "SELECT * FROM `product` WHERE `pro_id` <> "+proId+" AND product.`brand_id` = "+brandId+" LIMIT 3";
			rsb = DBCUtil.findAll(sql);
			List proList = new ArrayList();
			while (rsb.next()) {

				// 2.�����ص����ݷ�װProType����
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

			// ����ҳ��
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
