/**
 * 
 */
package com.company.dao;

import org.springframework.data.jpa.repository.Query;

import com.company.entity.Order;

/**
 * @author czz
 *
 */
public interface OrderDaoI extends BaseDao<Order> {

	@Query("from Order o where o.orderNum = ?1")
	Order findByOrderNum(String orderNum);

}
