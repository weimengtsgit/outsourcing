/**
 * 
 */
package com.company.service;

import java.util.List;

import com.company.entity.Order;
import com.company.entity.OrderDetail;

/**
 * @author czz
 *
 */
public interface OrderDetailServiceI extends BaseServiceI<OrderDetail>{
	
	public List<OrderDetail> findByOrder(Order order);
}
