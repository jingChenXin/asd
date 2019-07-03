package com.byzx.bean;

import java.io.Serializable;

/**
 * 
 * @Description ������ϸ��
 * @author ��
 * @date 2019��4��23�� ����9:30:50
 * @version v1.0
 */
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 6941627052823615348L;
	// 1.��ϸid
	private int itemId;
	// 2.����id
	private int orderId;
	// 3.��Ʒid
	private int proId;
	// 4.��Ʒ����
	private String proName;
	// 5.��Ʒ�۸�
	private float proPrice;
	// 6.��Ʒ����
	private int proCount;
	// 7.��ƷС��
	private float proTotal;
	// 8.��ƷͼƬ
	private String proPic;

	public OrderItem() {

	}

	public OrderItem(int itemId, int orderId, int proId, String proName,
			float proPrice, int proCount, float proTotal, String proPic) {
		this.itemId = itemId;
		this.orderId = orderId;
		this.proId = proId;
		this.proName = proName;
		this.proPrice = proPrice;
		this.proCount = proCount;
		this.proTotal = proTotal;

		this.proPic = proPic;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public float getProPrice() {
		return proPrice;
	}

	public void setProPrice(float proPrice) {
		this.proPrice = proPrice;
	}

	public int getProCount() {
		return proCount;
	}

	public void setProCount(int proCount) {
		this.proCount = proCount;
	}

	public float getProTotal() {
		return proTotal;
	}

	public void setProTotal(float proTotal) {
		this.proTotal = proTotal;
	}

	public String getProPic() {
		return proPic;
	}

	public void setProPic(String proPic) {
		this.proPic = proPic;
	}

}
