package com.byzx.bean;

import java.io.Serializable;

/**
 * 
 * @Description 用户表
 * @author 景
 * @date 2019年4月23日 上午9:31:11
 * @version v1.0
 */
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1713471410649996001L;
	// 1.用户id
	private int userId;
	// 2.用户姓
	private String userSurname;
	// 3.用户名称
	private String userName;
	// 4.性别 0 男 1 女
	private String userSex;
	// 5.密码
	private String passWord;
	// 6.确认密码
	private String passwordPawd;
	// 7.用户等级
	private int level;
	// 8.联系电话
	private String phone;
	// 9.邮箱
	private String postCode;

	public UserInfo() {

	}

	public UserInfo(int userId, String userSurname, String userName,
			String userSex, String passWord, String passwordPawd, int level,
			String phone, String postCode) {
		this.userId = userId;
		this.userSurname = userSurname;
		this.userName = userName;
		this.userSex = userSex;
		this.passWord = passWord;
		this.passwordPawd = passwordPawd;
		this.level = level;
		this.phone = phone;
		this.postCode = postCode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getPasswordPawd() {
		return passwordPawd;
	}

	public void setPasswordPawd(String passwordPawd) {
		this.passwordPawd = passwordPawd;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}
