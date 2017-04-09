/**
 * 
 */
package com.company.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.entity.Order;
import com.company.entity.OrderDetail;
import com.company.model.OrderDetailPageModel;
import com.company.model.OrderPageModel;
import com.company.service.OrderDetailServiceI;
import com.company.service.OrderServiceI;
import com.company.utils.OrderStatus;

/**
 * @author czz
 *
 */
@Controller
public class AdminController {

	@Autowired
	private OrderServiceI orderServiceI;
	
	@Autowired
	private OrderDetailServiceI orderDetailServiceI;

	@RequestMapping("/admin")
	public String index() {
		return "admin";
	}

	@RequestMapping("/search")
	@ResponseBody
	public Map<String, Object> searchOrder(com.company.filter.OrderFilter filter) {
		Map<String, Object> map = new HashMap<>();
		List<Order> list = orderServiceI.findByConfition(filter);
		map.put("data", OrderPageModel.convertOrderToPageModel(list));
		map.put("result", "success");
		return map;
	}

	@RequestMapping("/detail")
	@ResponseBody
	public Map<String, Object> orderDetail(String orderNum) {
		Map<String, Object> map = new HashMap<>();
		Order order = orderServiceI.findByOrderNum(orderNum);
		List<OrderDetail> detailList = orderDetailServiceI.findByOrder(order);
		map.put("data", OrderDetailPageModel.convertToDetail(detailList));
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping("/confirmBuy")
	@ResponseBody
	public Map<String, Object> confirmBuy(String orderNum) {
		Map<String, Object> map = new HashMap<>();
		Order order = orderServiceI.findByOrderNum(orderNum);
		order.setStatus(OrderStatus.BUY.getStatus());
		orderServiceI.update(order);
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping("/confirmSend")
	@ResponseBody
	public Map<String, Object> confirmSend(String orderNum) {
		Map<String, Object> map = new HashMap<>();
		Order order = orderServiceI.findByOrderNum(orderNum);
		order.setStatus(OrderStatus.SEND.getStatus());
		orderServiceI.update(order);
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping("/confirmFinish")
	@ResponseBody
	public Map<String, Object> confirmFinish(String orderNum) {
		Map<String, Object> map = new HashMap<>();
		Order order = orderServiceI.findByOrderNum(orderNum);
		order.setStatus(OrderStatus.COMPLETE.getStatus());
		orderServiceI.update(order);
		map.put("result", "success");
		return map;
	}
}
