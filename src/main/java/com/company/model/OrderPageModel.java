/**
 * 
 */
package com.company.model;

import java.util.ArrayList;
import java.util.List;

import com.company.entity.Order;
import com.company.utils.DateUtil;
import com.company.utils.OrderStatus;

/**
 * @author czz
 *
 */
public class OrderPageModel {
	// 订单号
	private String orderNum;

	// 订单日期
	private String date;

	// 订单状态
	private String status;

	// 订单价格
	private double price;

	// 客户电话
	private String tel;

	// 订单地址
	private String adress;
	
	// 商品列表
	private List<GoodsListPageModel> goodsList;

	/**
	 * @return orderNum
	 */
	public String getOrderNum() {
		return orderNum;
	}

	/**
	 * @param orderNum
	 *            要设置的 orderNum
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            要设置的 date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            要设置的 status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            要设置的 price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            要设置的 tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * @param adress
	 *            要设置的 adress
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	public static List<OrderPageModel> convertOrderToPageModel(List<Order> orderList) {
		List<OrderPageModel> list = new ArrayList<>();
		if (null != orderList && orderList.size() > 0) {
			for (Order order : orderList) {
				OrderPageModel model = new OrderPageModel();
				model.setOrderNum(order.getOrderNum());
				model.setDate(DateUtil.formatDateToString(order.getDate()));
				model.setPrice(order.getTotalPrice());
				model.setStatus(OrderStatus.getOrderStatus(order.getStatus()).getName());
				model.setTel(order.getTel());
				model.setAdress(order.getAdress());
				list.add(model);
			}
		}
		return list;
	}
}
