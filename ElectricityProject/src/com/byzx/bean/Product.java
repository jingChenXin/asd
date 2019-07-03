package com.byzx.bean;

import java.io.Serializable;

/**
 * 
 * @Description ��Ʒ��
 * @author ��
 * @date 2019��4��23�� ����9:30:58
 * @version v1.0
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1417208618807276828L;
	// 1.��ƷID
	private int proId;
	// 2.����ID
	private int typeId;
	// 3.Ʒ��ID
	private int brandId;
	// 4.��������
	private String typeName;
	// 5.Ʒ������
	private String brandName;
	// 6.��Ʒ����
	private String proName;
	// 7.��Ʒ����
	private float proInprice;
	// 8.��Ʒ�ۼ�
	private float proSellprice;
	// 9.������
	private String proSupply;
	// 10.����
	private String proAddress;
	// 11.ͼƬ
	private String proPic;
	// 12.��Ʒ���
	private float inventory;
	// 13.��Ʒ���¼�״̬
	private String proUpDown;
	// 14.��Ʒ����
	private String proInfo;
	// 15.��������
	private String proStartDate;
	// 16.��Ч��
	private String proEndDate;

	public Product() {

	}

	public Product(int proId, int typeId, int brandId, String typeName,
			String brandName, String proName, float proInprice,
			float proSellprice, String proSupply, String proAddress,
			String proPic, float inventory, String proUpDown, String proInfo,
			String proStartDate, String proEndDate) {
		this.proId = proId;
		this.typeId = typeId;
		this.brandId = brandId;
		this.typeName = typeName;
		this.brandName = brandName;
		this.proName = proName;
		this.proInprice = proInprice;
		this.proSellprice = proSellprice;
		this.proSupply = proSupply;
		this.proAddress = proAddress;
		this.proPic = proPic;
		this.inventory = inventory;
		this.proUpDown = proUpDown;
		this.proInfo = proInfo;
		this.proStartDate = proStartDate;
		this.proEndDate = proEndDate;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public float getInventory() {
		return inventory;
	}

	public void setInventory(float inventory) {
		this.inventory = inventory;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public float getProInprice() {
		return proInprice;
	}

	public void setProInprice(float proInprice) {
		this.proInprice = proInprice;
	}

	public float getProSellprice() {
		return proSellprice;
	}

	public void setProSellprice(float proSellprice) {
		this.proSellprice = proSellprice;
	}

	public String getProSupply() {
		return proSupply;
	}

	public void setProSupply(String proSupply) {
		this.proSupply = proSupply;
	}

	public String getProAddress() {
		return proAddress;
	}

	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}

	public String getProPic() {
		return proPic;
	}

	public void setProPic(String proPic) {
		this.proPic = proPic;
	}

	public float getNventory() {
		return inventory;
	}

	public void setNventory(float nventory) {
		this.inventory = nventory;
	}

	public String getProUpDown() {
		return proUpDown;
	}

	public void setProUpDown(String proUpDown) {
		this.proUpDown = proUpDown;
	}

	public String getProInfo() {
		return proInfo;
	}

	public void setProInfo(String proInfo) {
		this.proInfo = proInfo;
	}

	public String getProStartDate() {
		return proStartDate;
	}

	public void setProStartDate(String proStartDate) {
		this.proStartDate = proStartDate;
	}

	public String getProEndDate() {
		return proEndDate;
	}

	public void setProEndDate(String proEndDate) {
		this.proEndDate = proEndDate;
	}

}
