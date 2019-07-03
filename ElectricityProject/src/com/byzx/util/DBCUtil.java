package com.byzx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description 封装JDBC操作
 * @author ~景
 * @version v1.0
 * @date 2019年4月18日
 */

public class DBCUtil {
	public static Connection con = null;
	public static Statement stm = null;
	public static ResultSet rs = null;

	// 获取数据库连接对象
	public static Connection getConnection() {
		try {
			// 注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库连接对象
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_business?characterEncoding=UTF-8","root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

	/**
	 * 
	 * @Description 修改删除添加方法
	 * @author ~景
	 * @version v1.0
	 * @date 2019年4月19日
	 */
	public static boolean saveOrUpdate(String sql) throws SQLException {
		// 数据保存
		try {
			// 1.获取连接
			con = getConnection();
			// 2.获取Statement
			stm = con.createStatement();
			// 3.执行sql
			int res = stm.executeUpdate(sql);
			if (res > 0) {
				System.out.println("操作成功");
				return true;
			} else {
				System.out.println("操作失败");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @Description 查询结果集
	 * @author ~景
	 * @version v1.0
	 * @throws SQLException
	 * @date 2019年4月18日
	 */
	public static ResultSet findAll(String sql) throws SQLException {
		// 数据保存
		try {
			// 1.获取连接
			con = getConnection();
			// 2.获取Statement
			stm = con.createStatement();
			// 3.执行sql
			rs = stm.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;

	}

	/**
	 * 
	 * @Description 关闭资源
	 * @author ~景
	 * @version v1.0
	 * @date 2019年4月19日
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
