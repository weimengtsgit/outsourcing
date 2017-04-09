/**
 * 
 */
package com.company.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author czz
 *
 */
@Entity
@Table(name = "table_order")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4926641141173215598L;

	@Id
	@Column(length = 32, nullable = false, unique = true)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	/** 订单号 */
	@Column(name = "order_num", unique = true, nullable = false)
	private String orderNum;

	/** 订单日期 */
	@Column(name = "order_date", nullable = false)
	private Date date;

	/** 订单状态 */
	@Column(name = "order_status", nullable = false)
	private char status;

	/** 订单金额 */
	@Column(name = "order_price")
	private double totalPrice;

	/** 客户姓名 */
	@Column(name = "order_name")
	private String name;

	/** 客户电话 */
	@Column(name = "order_tel")
	private String tel;

	/** 客户地址 */
	@Column(name = "order_adress")
	private String adress;

	/** 客户邮件 */
	@Column(name = "order_email")
	private String email;

	/** 客户留言 */
	@Column(name = "order_comment")
	private String comment;

	// @OneToMany(cascade=CascadeType.REFRESH,mappedBy="detail_order")
	// private OrderDetail detail;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            要设置的 id
	 */
	public void setId(String id) {
		this.id = id;
	}

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
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            要设置的 date
	 */
	public void setDate(Date date) {
		this.date = date;
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

	/**
	 * @return totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 *            要设置的 totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
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
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            要设置的 email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            要设置的 comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return detail
	 */
	// public OrderDetail getDetail() {
	// return detail;
	// }

	/**
	 * @param detail
	 *            要设置的 detail
	 */
	// public void setDetail(OrderDetail detail) {
	// this.detail = detail;
	// }

}
