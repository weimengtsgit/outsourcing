/**
 * 
 */
package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.BaseDao;
import com.company.dao.OrderDaoI;
import com.company.entity.Order;
import com.company.service.OrderServiceI;

/**
 * @author czz
 *
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order>implements OrderServiceI {
	@Autowired
	private OrderDaoI orderDaoI;

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.company.service.impl.BaseServiceImpl#getDao()
	 */
	@Override
	public BaseDao<Order> getDao() {
		return orderDaoI;
	}

	@Override
	public List<Order> findByConfition(com.company.filter.OrderFilter filter) {
		String orderNum = filter.getOrderNum();
		String tel = filter.getTel();
		String status = filter.getStatus();
		// 拼接sql语句
		String queryStr = "from Order o ";
		StringBuffer sb = new StringBuffer();
		if (null != orderNum && orderNum.length() > 0) {
			sb.append("o.orderNum like '%" + orderNum + "%'");
		}
		if (null != tel && tel.length() > 0) {
			if (sb.length() > 0) {
				sb.append(" and ");
			}
			sb.append("o.tel like '%" + tel + "%'");
		}
		if (null != status && status.length() > 0) {
			char orderStatus = status.charAt(0);
			if (sb.length() > 0) {
				sb.append(" and ");
			}
			sb.append("o.status in ('" + orderStatus + "')");
		}
		if (sb.length() > 0) {
			queryStr = queryStr + "where (" + sb.toString() + ") ";
		}
		// 查询结果
		List<Order> orderList = orderDaoI.query(queryStr);
		return orderList;
	}

	@Override
	public Order findByOrderNum(String orderNum) {
		return orderDaoI.findByOrderNum(orderNum);
	}

}
