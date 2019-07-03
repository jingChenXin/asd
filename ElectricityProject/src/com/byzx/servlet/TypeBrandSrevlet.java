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

import com.byzx.bean.Brand;
import com.byzx.bean.ProType;
import com.byzx.util.DBCUtil;

/**
 * 
 * @Description ��Ʒ���ͣ�Ʒ����Ϣ
 * @author ��
 * @date 2019��4��24�� ����11:51:13
 * @version v1.0
 */
@WebServlet("/typeBrand")
public class TypeBrandSrevlet extends HttpServlet {
	private static final long serialVersionUID = -1595342466951505988L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String sql = "";
		ResultSet rsp = null;
		ResultSet rsb = null;
		try {
			// 1.��jdbcȥ���ݿ��в�ѯ������Ϣ
			sql = "SELECT * FROM `pro_type`";
			rsp = DBCUtil.findAll(sql);
			List typeList = new ArrayList();
			while (rsp.next()) {
				// 2.�����ص����ݷ�װProType����
				ProType pt = new ProType(rsp.getInt("type_id"),rsp.getString("type_name"), 0, null);
				typeList.add(pt);
			}
			

			
		
			// 1.��jdbcȥ���ݿ��в�ѯƷ����Ϣ
			sql = "SELECT * FROM `brand`";
			rsb = DBCUtil.findAll(sql);
			List brandList = new ArrayList();
			while (rsb.next()) {
				// 2.�����ص����ݷ�װBrand����
				Brand br = new Brand(rsb.getInt("brand_id"),rsb.getString("brand_name"), null, null);
				brandList.add(br);
			}
			
			
		
			
			// 3.����ҳ��
			req.getSession().setAttribute("typeList", typeList);
			req.getSession().setAttribute("brandList", brandList);
			req.getRequestDispatcher("/commodity")
			.forward(req, resp);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsp);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsb);
		}

	}

}
