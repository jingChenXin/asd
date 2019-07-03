package com.byzx.bean;

import java.io.Serializable;

/**
 * 
 * @Description �ջ��ַ
 * @author ��
 * @date 2019��4��23�� ����9:29:36
 * @version v1.0
 */

public class Address implements Serializable {

	private static final long serialVersionUID = 7005931102816761691L;
	// 1.��ַid
	private int addrId;
	// 2.�û�id
	private int userId;
	// 3.��ַ
	private String addrInfo;
	// 4.�ʱ�
	private String postCode;
	// 5.�ջ���
	private String reapPerson;
	// 6.�ջ��˵绰
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
