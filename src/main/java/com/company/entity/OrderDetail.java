/**
 * 
 */
package com.company.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author czz
 *
 */
@Entity
@Table(name="table_order_detail")
public class OrderDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7091405151006686220L;
	
	@Id
	@Column(length = 32, nullable = false, unique = true)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid") 
	private String id;
	
	@ManyToOne
	@JoinColumn(name="detail_goods", referencedColumnName = "id")
	private Goods goods;
	
	@ManyToOne
	@JoinColumn(name="detail_order", referencedColumnName = "id")
	private Order order;
	
	@Column(name="detail_num")
	private int number;

	/**
	 * @return goods
	 */
	public Goods getGoods() {
		return goods;
	}

	/**
	 * @param goods 要设置的 goods
	 */
	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	/**
	 * @return number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number 要设置的 number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id 要设置的 id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order 要设置的 order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
