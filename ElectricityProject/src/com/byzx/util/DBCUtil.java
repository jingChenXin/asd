package com.byzx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description ��װJDBC����
 * @author ~��
 * @version v1.0
 * @date 2019��4��18��
 */

public class DBCUtil {
	public static Connection con = null;
	public static Statement stm = null;
	public static ResultSet rs = null;

	// ��ȡ���ݿ����Ӷ���
	public static Connection getConnection() {
		try {
			// ע������
			Class.forName("com.mysql.jdbc.Driver");
			// ��ȡ���ݿ����Ӷ���
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_business?characterEncoding=UTF-8","root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

	/**
	 * 
	 * @Description �޸�ɾ����ӷ���
	 * @author ~��
	 * @version v1.0
	 * @date 2019��4��19��
	 */
	public static boolean saveOrUpdate(String sql) throws SQLException {
		// ���ݱ���
		try {
			// 1.��ȡ����
			con = getConnection();
			// 2.��ȡStatement
			stm = con.createStatement();
			// 3.ִ��sql
			int res = stm.executeUpdate(sql);
			if (res > 0) {
				System.out.println("�����ɹ�");
				return true;
			} else {
				System.out.println("����ʧ��");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @Description ��ѯ�����
	 * @author ~��
	 * @version v1.0
	 * @throws SQLException
	 * @date 2019��4��18��
	 */
	public static ResultSet findAll(String sql) throws SQLException {
		// ���ݱ���
		try {
			// 1.��ȡ����
			con = getConnection();
			// 2.��ȡStatement
			stm = con.createStatement();
			// 3.ִ��sql
			rs = stm.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;

	}

	/**
	 * 
	 * @Description �ر���Դ
	 * @author ~��
	 * @version v1.0
	 * @date 2019��4��19��
	 */
	public static void close(Connection con, Statement stm, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/*public static void main(String[] args) throws SQLException {
		for (int i = 31; i <= 48; i++) {
			getConnection();
			String sql = "INSERT INTO `student`(`stu_name`,`stu_age`,`stu_sex`,`birthday`) VALUES ('name"
					+ i + "'," + (10 + i) + ",'0'," + null + ")";
			String sql = "DELETE FROM `student`  WHERE `stu_id` = " + i + "";
			saveOrUpdate(sql);
			close(DBCUtil.con, DBCUtil.stm, DBCUtil.rs);
		}
	}*/

}
