/**
 * 
 */
package com.company.dao;

import org.springframework.data.jpa.repository.Query;

import com.company.entity.OrderSerial;

/**
 * @author czz
 *
 */
public interface OrderSerialDaoI extends BaseDao<OrderSerial> {
	
	@Query("SELECT serial FROM OrderSerial serial WHERE serial.date = ?1")
	public OrderSerial getSerialByDate(String date);
}
