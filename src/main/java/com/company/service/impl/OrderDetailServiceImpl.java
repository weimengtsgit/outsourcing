/**
 * 
 */
package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.BaseDao;
import com.company.dao.OrderDetailDaoI;
import com.company.entity.Order;
import com.company.entity.OrderDetail;
import com.company.service.OrderDetailServiceI;

/**
 * @author czz
 *
 */
@Service
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail>implements OrderDetailServiceI {
	@Autowired
	private OrderDetailDaoI orderDetailDaoI;

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.company.service.impl.BaseServiceImpl#getDao()
	 */
	@Override
	public BaseDao<OrderDetail> getDao() {
		return orderDetailDaoI;
	}

	@Override
	public List<OrderDetail> findByOrder(Order order) {
		return orderDetailDaoI.findByOrder(order);
	}

}
