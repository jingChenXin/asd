package com.byzx.bean;

import java.io.Serializable;

/**
 * 
 * @Description Ʒ�Ʊ�
 * @author ��
 * @date 2019��4��23�� ����9:30:00
 * @version v1.0
 */
public class Brand implements Serializable {

	private static final long serialVersionUID = 5824451659946057964L;
	// 1.Ʒ��id
	private int brandId;
	// 2.Ʒ������
	private String brandName;
	// 3.Ʒ�ƽ���
	private String brandInfo;
	// 4.Ʒ������ĸ
	private String brandLetter;

	public Brand() {

	}

	public Brand(int brandId, String brandName, String brandInfo,
			String brandLetter) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.brandInfo = brandInfo;
		this.brandLetter = brandLetter;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandInfo() {
		return brandInfo;
	}

	public void setBrandInfo(String brandInfo) {
		this.brandInfo = brandInfo;
	}

	public String getBrandLetter() {
		return brandLetter;
	}

	public void setBrandLetter(String brandLetter) {
		this.brandLetter = brandLetter;
	}
}
