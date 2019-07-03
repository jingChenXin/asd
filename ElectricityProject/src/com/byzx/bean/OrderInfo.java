package com.byzx.bean;

import java.io.Serializable;

/**
 * @Description 订单表
 * @author 景
 * @date 2019年4月23日 上午9:30:09
 * @version v1.0
 */
public class OrderInfo implements Serializable {

	private static final long serialVersionUID = 1831252910043242104L;
	// 1.订单id
	private int orderId;
	// 2.订单号
	private String orderNum;
	// 3.用户id
	private int userId;
	// 4.地址id
	private int addrId;
	// 5.金额
	private float totalMoney;
	// 6.支付方式    0:未支付     1:待支付     2:已支付
	private String payWay;
	// 7.订单状态   
	private String orderState;
	// 8.购物车状态
	private String cartState;
	// 9.创建时间
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
