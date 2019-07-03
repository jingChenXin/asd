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
 * @Description �޸���Ʒ��Ϣ
 * @author ��
 * @date 2019��4��26�� ����4:16:28
 * @version v1.0
 */
@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {

	private static final long serialVersionUID = -2009007866777566629L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
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
			String fileName = "";
			// ʹ��jspsmart��װ��request,ע�����ŵ�su.upload()֮���ȡ�����������ȡ����ֵ��
			com.jspsmart.upload.Request request = su.getRequest();
			for (int i = 0; i < files.getCount(); i++) {
				com.jspsmart.upload.File file = files.getFile(i);
				// �ļ�ת��
				fileName = file.getFileName();
				if (fileName != null && !"".equals(fileName)) {
					file.saveAs(root + File.separator + fileName);
					proPic = "/upload/" + file.getFileName();
				}
			}

			if (fileName == null || "".equals(fileName)) {
				// ԭ��ַ
				proPic = request.getParameter("imgurl");
			}
			// 1.��ȡ����
			String proId = request.getParameter("proId");
			String proName = request.getParameter("proName");
			String proSellprice = request.getParameter("proSellprice");
			String proSupply = request.getParameter("proSupply");
			String proAddress = request.getParameter("proAddress");
			String inventory = request.getParameter("inventory");
			String proUpDown = request.getParameter("proUpDown");
			String proEndDate = request.getParameter("proEndDate");

			// 2.ִ��sql���

			String sql = "UPDATE `product` SET `pro_name` = '" + proName + "',`pro_sellprice` ='" + proSellprice + "',`pro_supply` ='" + proSupply + "',`pro_address` = '"
					+ proAddress + "',`inventory`" + " = '" + inventory + "',`pro_end_date` = '" + proEndDate + "',`pro_up_down` = '" + proUpDown + "',"
					+ " `pro_pic` = '" + proPic + "' " + " WHERE `pro_id` = " + proId;
			System.out.println(sql);
			boolean f = DBCUtil.saveOrUpdate(sql);

			// 3.�ж�����Ƿ�ɹ�
			if (f) {
				// �ɹ���תҳ��
				resp.sendRedirect(req.getContextPath() + "/commodity?msg=1");
			} else {
				// ʧ����תҳ��
				resp.sendRedirect(req.getContextPath()
						+ "/myPage/UpdateProduct.jsp?msg=0");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
