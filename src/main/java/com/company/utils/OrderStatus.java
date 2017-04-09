/**
 * 
 */
package com.company.utils;

/**
 * @author czz
 *
 */
public enum OrderStatus {

	ORDER("下单成功", '0'), BUY("采购中", '1'), SEND("已发货", '2'), COMPLETE("订单完成", '3');

	private String name;
	private char status;

	private OrderStatus(String name, char status) {
		this.name = name;
		this.status = status;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return status
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            要设置的 status
	 */
	public void setStatus(char status) {
		this.status = status;
	}

	public static OrderStatus getOrderStatus(String name) {
		for (OrderStatus status : OrderStatus.values()) {
			if (status.getName().equals(name)) {
				return status;
			}
		}
		return null;
	}

	public static OrderStatus getOrderStatus(char status) {
		for (OrderStatus orderStatus : OrderStatus.values()) {
			if (orderStatus.getStatus() == status) {
				return orderStatus;
			}
		}
		return null;
	}
}
