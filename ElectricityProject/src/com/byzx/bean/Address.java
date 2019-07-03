package com.byzx.bean;

import java.io.Serializable;

/**
 * 
 * @Description 收获地址
 * @author 景
 * @date 2019年4月23日 上午9:29:36
 * @version v1.0
 */

public class Address implements Serializable {

	private static final long serialVersionUID = 7005931102816761691L;
	// 1.地址id
	private int addrId;
	// 2.用户id
	private int userId;
	// 3.地址
	private String addrInfo;
	// 4.邮编
	private String postCode;
	// 5.收货人
	private String reapPerson;
	// 6.收获人电话
	private String phone;

	public Address() {

	}

	public Address(int addrId, int userId, String addrInfo, String postCode,
			String reapPerson, String phone) {
		this.addrId = addrId;
		this.userId = userId;
		this.addrInfo = addrInfo;
		this.postCode = postCode;
		this.reapPerson = reapPerson;
		this.phone = phone;
	}

	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddrInfo() {
		return addrInfo;
	}

	public void setAddrInfo(String addrInfo) {
		this.addrInfo = addrInfo;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getReapPerson() {
		return reapPerson;
	}

	public void setReapPerson(String reapPerson) {
		this.reapPerson = reapPerson;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
