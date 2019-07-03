package com.byzx.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

/**
 * 
 * @Description 文件上传
 * @author 景
 * @date 2019年4月25日 下午4:28:42
 * @version v1.0
 */
@WebServlet("/smartUpload")
public class SmartUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 7857834506871971228L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 存储所有文件名
		List<String> fileNames = new ArrayList<String>();
		// 获取服务器文件存储的真实路径

		String root = this.getServletContext().getRealPath("/") + "upload";
		try {
			// 创建一个smartUpload对象
			SmartUpload su = new SmartUpload();
			// 初始化配置
			su.initialize(this, req, resp);
			/*
			 * //设置允许上传的文件格式 
			 * su.setAllowedFilesList("jpg,png,gif,bmp");
			 * //设置不允许上传的文件列表 
			 * su.setDeniedFilesList(".exe,.bat,.dll");
			 * //设置单个上传文件的最大大小(20M，默认为2M) 
			 * su.setMaxFileSize(1024*1024*20);
			 * //设置总共文件允许的大小2G 
			 * su.setTotalMaxFileSize(1024*1024*1024*2);
			 */
			// 准备上传
			su.upload();
			// 获取上传文件的列表
			Files files = su.getFiles();
			for (int i = 0; i < files.getCount(); i++) {
				// 获取指定文件
				com.jspsmart.upload.File file = files.getFile(i);
				// 将文件名加入集合
				fileNames.add(file.getFieldName());
				System.out.println("要上传的文件" + file.getFieldName());
				// 将客户端的文件复制到服务器的空文件中
				if (file.getSize() > 0 && !"".equals(file.getFieldName())) {
					//file.saveAs(root + File.separator + file.getFieldName());
					file.saveAs(root + File.separator + file.getFileName());
					System.out.println(root + File.separator + file.getFileName());
				}
			}

			System.out.println("文件上传成功！" + fileNames);
			/*
			 * // 获取request对象(SmartUpload) Request red = su.getRequest();
			 * req.setAttribute("files", fileNames);
			 * req.getRequestDispatcher("showFile.jsp").forward(req, resp);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
