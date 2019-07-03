package com.byzx.bean;

import java.io.Serializable;

/**
 * 
 * @Description 订单明细表
 * @author 景
 * @date 2019年4月23日 上午9:30:50
 * @version v1.0
 */
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 6941627052823615348L;
	// 1.明细id
	private int itemId;
	// 2.订单id
	private int orderId;
	// 3.商品id
	private int proId;
	// 4.商品名称
	private String proName;
	// 5.商品价格
	private float proPrice;
	// 6.商品数量
	private int proCount;
	// 7.商品小计
	private float proTotal;
	// 8.商品图片
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
