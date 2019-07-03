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
 * @Description 修改商品信息
 * @author 景
 * @date 2019年4月26日 下午4:16:28
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
			// 获取服务器文件存储的真实路径
			String root = this.getServletContext().getRealPath("/") + "upload";
			// 创建一个smartUpload对象
			SmartUpload su = new SmartUpload();
			// 初始化配置
			su.initialize(this, req, resp);
			// 准备上传
			su.upload();
			Files files = su.getFiles();
			String fileName = "";
			// 使用jspsmart封装的request,注意必须放到su.upload()之后获取参数，否则获取不到值。
			com.jspsmart.upload.Request request = su.getRequest();
			for (int i = 0; i < files.getCount(); i++) {
				com.jspsmart.upload.File file = files.getFile(i);
				// 文件转存
				fileName = file.getFileName();
				if (fileName != null && !"".equals(fileName)) {
					file.saveAs(root + File.separator + fileName);
					proPic = "/upload/" + file.getFileName();
				}
			}

			if (fileName == null || "".equals(fileName)) {
				// 原地址
				proPic = request.getParameter("imgurl");
			}
			// 1.获取参数
			String proId = request.getParameter("proId");
			String proName = request.getParameter("proName");
			String proSellprice = request.getParameter("proSellprice");
			String proSupply = request.getParameter("proSupply");
			String proAddress = request.getParameter("proAddress");
			String inventory = request.getParameter("inventory");
			String proUpDown = request.getParameter("proUpDown");
			String proEndDate = request.getParameter("proEndDate");

			// 2.执行sql语句

			String sql = "UPDATE `product` SET `pro_name` = '" + proName + "',`pro_sellprice` ='" + proSellprice + "',`pro_supply` ='" + proSupply + "',`pro_address` = '"
					+ proAddress + "',`inventory`" + " = '" + inventory + "',`pro_end_date` = '" + proEndDate + "',`pro_up_down` = '" + proUpDown + "',"
					+ " `pro_pic` = '" + proPic + "' " + " WHERE `pro_id` = " + proId;
			System.out.println(sql);
			boolean f = DBCUtil.saveOrUpdate(sql);

			// 3.判断添加是否成功
			if (f) {
				// 成功跳转页面
				resp.sendRedirect(req.getContextPath() + "/commodity?msg=1");
			} else {
				// 失败跳转页面
				resp.sendRedirect(req.getContextPath()
						+ "/myPage/UpdateProduct.jsp?msg=0");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
