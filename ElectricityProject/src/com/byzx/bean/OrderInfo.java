package com.byzx.bean;

import java.io.Serializable;

/**
 * @Description ������
 * @author ��
 * @date 2019��4��23�� ����9:30:09
 * @version v1.0
 */
public class OrderInfo implements Serializable {

	private static final long serialVersionUID = 1831252910043242104L;
	// 1.����id
	private int orderId;
	// 2.������
	private String orderNum;
	// 3.�û�id
	private int userId;
	// 4.��ַid
	private int addrId;
	// 5.���
	private float totalMoney;
	// 6.֧����ʽ    0:δ֧��     1:��֧��     2:��֧��
	private String payWay;
	// 7.����״̬   
	private String orderState;
	// 8.���ﳵ״̬
	private String cartState;
	// 9.����ʱ��
	private String createTime;

	public OrderInfo() {

	}

	public OrderInfo(int orderId, String orderNum, int userId, int addrId,
			float totalMoney, String payWay, String orderState,
			String cartState, String createTime) {
		this.orderId = orderId;
		this.orderNum = orderNum;
		this.userId = userId;
		this.addrId = addrId;
		this.totalMoney = totalMoney;
		this.payWay = payWay;
		this.orderState = orderState;
		this.cartState = cartState;
		this.createTime = createTime;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getCartState() {
		return cartState;
	}

	public void setCartState(String cartState) {
		this.cartState = cartState;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
