/**
 * 
 */
package com.company.service;

import java.util.List;

import com.company.entity.Order;

/**
 * @author czz
 *
 */
public interface OrderServiceI extends BaseServiceI<Order>{
	
	public List<Order> findByConfition(com.company.filter.OrderFilter filter);

	public Order findByOrderNum(String orderNum);
}
