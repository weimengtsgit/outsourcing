/**
 * 
 */
package com.company.entity;

import java.io.Serializable;

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
@Table(name="table_goods")
public class Goods implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2056250338985099873L;
	
	@Id
	@Column(length = 32, nullable = false, unique = true)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid") 
	private String id;
	
	@Column(name="goods_name", nullable = false)
	private String name;
	
	@Column(name="goods_price", nullable = false)
	private double price;
	

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
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price 要设置的 price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}
