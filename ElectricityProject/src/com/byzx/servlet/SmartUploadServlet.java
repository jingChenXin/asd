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
 * @Description �ļ��ϴ�
 * @author ��
 * @date 2019��4��25�� ����4:28:42
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
		// �洢�����ļ���
		List<String> fileNames = new ArrayList<String>();
		// ��ȡ�������ļ��洢����ʵ·��

		String root = this.getServletContext().getRealPath("/") + "upload";
		try {
			// ����һ��smartUpload����
			SmartUpload su = new SmartUpload();
			// ��ʼ������
			su.initialize(this, req, resp);
			/*
			 * //���������ϴ����ļ���ʽ 
			 * su.setAllowedFilesList("jpg,png,gif,bmp");
			 * //���ò������ϴ����ļ��б� 
			 * su.setDeniedFilesList(".exe,.bat,.dll");
			 * //���õ����ϴ��ļ�������С(20M��Ĭ��Ϊ2M) 
			 * su.setMaxFileSize(1024*1024*20);
			 * //�����ܹ��ļ�����Ĵ�С2G 
			 * su.setTotalMaxFileSize(1024*1024*1024*2);
			 */
			// ׼���ϴ�
			su.upload();
			// ��ȡ�ϴ��ļ����б�
			Files files = su.getFiles();
			for (int i = 0; i < files.getCount(); i++) {
				// ��ȡָ���ļ�
				com.jspsmart.upload.File file = files.getFile(i);
				// ���ļ������뼯��
				fileNames.add(file.getFieldName());
				System.out.println("Ҫ�ϴ����ļ�" + file.getFieldName());
				// ���ͻ��˵��ļ����Ƶ��������Ŀ��ļ���
				if (file.getSize() > 0 && !"".equals(file.getFieldName())) {
					//file.saveAs(root + File.separator + file.getFieldName());
					file.saveAs(root + File.separator + file.getFileName());
					System.out.println(root + File.separator + file.getFileName());
				}
			}

			System.out.println("�ļ��ϴ��ɹ���" + fileNames);
			/*
			 * // ��ȡrequest����(SmartUpload) Request red = su.getRequest();
			 * req.setAttribute("files", fileNames);
			 * req.getRequestDispatcher("showFile.jsp").forward(req, resp);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
