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
 * @Description 添加商品
 * @author 景
 * @date 2019年4月25日 上午9:51:09
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
			// 获取服务器文件存储的真实路径
			String root = this.getServletContext().getRealPath("/") + "upload";
			// 创建一个smartUpload对象
			SmartUpload su = new SmartUpload();
			// 初始化配置
			su.initialize(this, req, resp);
			
			// 准备上传
			su.upload();
			Files files = su.getFiles();
			
			// 使用jspsmart封装的request,注意必须放到su.upload()之后获取参数，否则获取不到值。
			com.jspsmart.upload.Request request = su.getRequest();
			for (int i = 0; i < files.getCount(); i++) {
				com.jspsmart.upload.File file = files.getFile(i);
				// 文件转存
				file.saveAs(root + File.separator + file.getFileName());
				proPic = "/upload/" + file.getFileName();
			}
			
			// 1.获取参数
			String proName = request.getParameter("proName");
			String typeId = request.getParameter("proType");
			String brandId = request.getParameter("proBrand");
			String proSellprice = request.getParameter("proSellprice");
			String proSupply = request.getParameter("proSupply");
			String proAddress = request.getParameter("proAddress");
			String inventory = request.getParameter("inventory");
			String proEndDate = request.getParameter("proEndDate");

			// 2.执行sql语句

			String sql = "INSERT INTO `product` (`pro_name`,`type_id`,`brand_id`,`pro_sellprice`,`pro_supply`,`pro_address`,`inventory`,`pro_end_date`,`pro_up_down`,`pro_pic`) "
					+ " VALUES ('" + proName+ "','" + typeId + "','" + brandId + "','" + proSellprice + "','" + proSupply + "','" + proAddress + "','" + inventory + "','" + proEndDate + "','1','" + proPic + "')";
			System.out.println(sql);
			boolean f = DBCUtil.saveOrUpdate(sql);

			// 3.判断添加是否成功
			if (f) {
				// 成功跳转页面
				resp.sendRedirect(req.getContextPath() + "/commodity?msg=1");
			} else {
				// 失败跳转页面
				resp.sendRedirect(req.getContextPath() + "/myPage/addProduct.jsp?msg=0");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
