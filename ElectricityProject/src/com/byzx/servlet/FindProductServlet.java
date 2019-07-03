package com.byzx.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.bean.Product;
import com.byzx.util.DBCUtil;
/**
 * 
 * @Description �����ز�
 * @author ��
 * @date 2019��4��26�� ����9:19:39
 * @version v1.0
 */
@WebServlet("/findProduct")
public class FindProductServlet extends HttpServlet{

	private static final long serialVersionUID = -8642452629131762781L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ��ƷID
		String proId = req.getParameter("proId");
		//��jdbcȥ���ݿ��в�ѯ��Ʒ��Ϣ
		try {
			String sql = "SELECT pt.`type_name` , b.`brand_name` , p.* FROM `product` p LEFT JOIN `pro_type` pt ON p.`type_id` = pt.`type_id` LEFT JOIN `brand` b ON b.`brand_id` = p.`brand_id` WHERE 1 = 1 AND `pro_id` = " + proId;
			ResultSet rs =  DBCUtil.findAll(sql);
			Product pt = null;
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
			//����ҳ��
			req.setAttribute("pt", pt);
			req.getRequestDispatcher("/myPage/UpdateProduct.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
