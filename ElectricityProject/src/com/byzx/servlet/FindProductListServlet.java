package com.byzx.servlet;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.bean.Brand;
import com.byzx.bean.ProType;
import com.byzx.bean.Product;
import com.byzx.util.DBCUtil;

/**
 * 
 * @Description 前台商品列表查询
 * @author 景
 * @date 2019年4月24日 下午9:31:11
 * @version v1.0
 */
@WebServlet("/frontProlist")
public class FindProductListServlet extends HttpServlet {

	private static final long serialVersionUID = 4326560672461789657L;
	private static final ResultSet rsp = null;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		ResultSet rs = null;
		ResultSet rsp = null;
		ResultSet rsb = null;
		try {
			String sql = "";
			// 1.用jdbc去数据库中查询分类信息
			sql = "SELECT * FROM `pro_type`";
			rsp = DBCUtil.findAll(sql);
			List typeList = new ArrayList();
			while (rsp.next()) {
				// 2.将返回的数据封装ProType对象
				ProType pt = new ProType(rsp.getInt("type_id"),
						rsp.getString("type_name"), 0, null);
				typeList.add(pt);
			}
			// 1.用jdbc去数据库中查询品牌信息
			sql = "SELECT * FROM `brand`";
			rsb = DBCUtil.findAll(sql);
			List brandList = new ArrayList();
			while (rsb.next()) {
				// 2.将返回的数据封装Brand对象
				Brand br = new Brand(rsb.getInt("brand_id"),
						rsb.getString("brand_name"), null, null);
				brandList.add(br);
			}

			// 3.返回页面
			req.getSession().setAttribute("typeLists", typeList);
			req.getSession().setAttribute("brandLists", brandList);

			// 获取商品信息
			String proType = req.getParameter("proType");
			String proBrand = req.getParameter("proBrand");
			String proName = req.getParameter("proName");

			// 动态拼接sql语句
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT pt.`type_name` , b.`brand_name` , p.* FROM `product` p LEFT JOIN `pro_type` pt ON p.`type_id` = pt.`type_id` LEFT JOIN `brand` b ON b.`brand_id` = p.`brand_id` WHERE 1=1");
			if (proType != null && !"".equals(proType)) {
				sb.append(" and p.type_id ").append(proType);
			}
			if (proBrand != null && !"".equals(proBrand)) {
				sb.append(" and p.brand_id ").append(proBrand);
			}
			if (proName != null && !"".equals(proName)) {
				sb.append(" and p.pro_name LIKE CONCAT('%','").append(proName)
						.append("','%')");
			}
			sb.append(" order by p.create_time desc");
			System.out.println(sb.toString());
			// 执行sql进行查询
			rs = DBCUtil.findAll(sb.toString());
			// 封装商品对象
			List proList = new ArrayList();
			while (rs.next()) {

				// 2.将返回的数据封装ProType对象
				Product pt = new Product(rs.getInt("pro_id"),
						rs.getInt("type_id"), rs.getInt("brand_id"),
						rs.getString("type_name"), rs.getString("brand_name"),
						rs.getString("pro_name"), 0.0f,
						rs.getFloat("pro_sellprice"),
						rs.getString("pro_supply"),
						rs.getString("pro_address"), rs.getString("pro_pic"),
						rs.getFloat("inventory"), rs.getString("pro_up_down"),
						null, rs.getString("pro_start_date"),
						rs.getString("pro_end_date"));
				proList.add(pt);
			}

			// 返回页面
			req.setAttribute("proList", proList);
			req.getRequestDispatcher("/products.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rs);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsp);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsb);
		}
	}

}
