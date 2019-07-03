package com.byzx.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.util.DBCUtil;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

/**
 * 
 * @Description �����Ʒ
 * @author ��
 * @date 2019��4��25�� ����9:51:09
 * @version v1.0
 */
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {

	private static final long serialVersionUID = -5210343467299106905L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String proPic = "";
			// ��ȡ�������ļ��洢����ʵ·��
			String root = this.getServletContext().getRealPath("/") + "upload";
			// ����һ��smartUpload����
			SmartUpload su = new SmartUpload();
			// ��ʼ������
			su.initialize(this, req, resp);
			
			// ׼���ϴ�
			su.upload();
			Files files = su.getFiles();
			
			// ʹ��jspsmart��װ��request,ע�����ŵ�su.upload()֮���ȡ�����������ȡ����ֵ��
			com.jspsmart.upload.Request request = su.getRequest();
			for (int i = 0; i < files.getCount(); i++) {
				com.jspsmart.upload.File file = files.getFile(i);
				// �ļ�ת��
				file.saveAs(root + File.separator + file.getFileName());
				proPic = "/upload/" + file.getFileName();
			}
			
			// 1.��ȡ����
			String proName = request.getParameter("proName");
			String typeId = request.getParameter("proType");
			String brandId = request.getParameter("proBrand");
			String proSellprice = request.getParameter("proSellprice");
			String proSupply = request.getParameter("proSupply");
			String proAddress = request.getParameter("proAddress");
			String inventory = request.getParameter("inventory");
			String proEndDate = request.getParameter("proEndDate");

			// 2.ִ��sql���

			String sql = "INSERT INTO `product` (`pro_name`,`type_id`,`brand_id`,`pro_sellprice`,`pro_supply`,`pro_address`,`inventory`,`pro_end_date`,`pro_up_down`,`pro_pic`) "
					+ " VALUES ('" + proName+ "','" + typeId + "','" + brandId + "','" + proSellprice + "','" + proSupply + "','" + proAddress + "','" + inventory + "','" + proEndDate + "','1','" + proPic + "')";
			System.out.println(sql);
			boolean f = DBCUtil.saveOrUpdate(sql);

			// 3.�ж�����Ƿ�ɹ�
			if (f) {
				// �ɹ���תҳ��
				resp.sendRedirect(req.getContextPath() + "/commodity?msg=1");
			} else {
				// ʧ����תҳ��
				resp.sendRedirect(req.getContextPath() + "/myPage/addProduct.jsp?msg=0");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
