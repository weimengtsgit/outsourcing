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
@Table(name="table_order_serial")
public class OrderSerial implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3773602630677955716L;

	@Id
	@Column(length = 32, nullable = false, unique = true)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid") 
	private String id;
	
	@Column(name="serial_date")
	private String date;
	
	@Column(name="serial_num")
	private int number;

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
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date 要设置的 date
	 */
	public void setDate(String date) {
		this.date = date;
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
}
