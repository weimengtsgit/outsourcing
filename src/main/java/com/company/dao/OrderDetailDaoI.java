/**
 * 
 */
package com.company.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.company.entity.Order;
import com.company.entity.OrderDetail;

/**
 * @author czz
 *
 */
public interface OrderDetailDaoI extends BaseDao<OrderDetail> {
	
	@Query("from OrderDetail o where o.order = ?1")
	List<OrderDetail> findByOrder(Order order);

}
