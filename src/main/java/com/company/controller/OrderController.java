/**
 * 
 */
package com.company.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.entity.Goods;
import com.company.entity.Order;
import com.company.entity.OrderDetail;
import com.company.entity.TestEntity;
import com.company.model.OrderDetailPageModel;
import com.company.service.GoodsServiceI;
import com.company.service.OrderDetailServiceI;
import com.company.service.OrderSerialServiceI;
import com.company.service.OrderServiceI;
import com.company.utils.DateUtil;
import com.company.utils.OrderStatus;

/**
 * @author czz
 *
 */
@Controller
public class OrderController {
	@Autowired
	private GoodsServiceI goodsServiceI;

	@Autowired
	private OrderDetailServiceI orderDetailServiceI;

	@Autowired
	private OrderServiceI orderServiceI;

	@Autowired
	private OrderSerialServiceI orderSerialServiceI;

//	@RequestMapping("/order")
//	@ResponseBody
//	public Map<String, Object> order(String goodId, String number, String name, String adress, String tel,
//			String email, String comment) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("result", "false");
//		if (null == goodId || goodId.length() == 0 || null == number || number.length() == 0 || null == name
//				|| name.length() == 0 || null == adress || adress.length() == 0 || null == tel || tel.length() == 0
//				|| null == email || email.length() == 0) {
//			return map;
//		}
//		Order order = new Order();
//		OrderDetail orderDetail = new OrderDetail();
//		try {
//			Goods goods = goodsServiceI.getById(goodId);
//			int num = Integer.parseInt(number);
//			if (null != goods && num > 0) {
//				orderDetail.setNumber(num);
//				order.setTotalPrice((goods.getPrice()) * num);
//				order.setDate(new Date());
//				// 订单号格式yyyymmdd+六位流水号
//				String serialNum = orderSerialServiceI.getCurrentSerialNum();
//				order.setOrderNum(serialNum);
//				order.setStatus(OrderStatus.ORDER.getStatus());
//				order.setComment(comment);
//				order.setAdress(adress);
//				order.setEmail(email);
//				order.setTel(tel);
//				order.setName(name);
//				Goods addedGoods = goodsServiceI.add(goods);
//				Order addedOrder = orderServiceI.add(order);
//				orderDetail.setOrder(addedOrder);
//				orderDetail.setGoods(addedGoods);
//				orderDetailServiceI.add(orderDetail);
//				map.put("result", "true");
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//			return map;
//		}
//		return map;
//	}
	
	@RequestMapping("/order")
	@ResponseBody
	public Map<String, Object> order(String goodId, String number, String name, String adress, String tel,
			String email, String comment, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		HttpSession session = request.getSession();
		map.put("result", "false");
		if (null == goodId || goodId.length() == 0 || null == number || number.length() == 0 || null == name
				|| name.length() == 0 || null == adress || adress.length() == 0 || null == tel || tel.length() == 0
				|| null == email || email.length() == 0) {
			return map;
		}
		Order order = new Order();
		OrderDetail orderDetail = new OrderDetail();
		try {
			Goods goods = goodsServiceI.getById(goodId);
			int num = Integer.parseInt(number);
			if (null != goods && num > 0) {
				orderDetail.setNumber(num);
				order.setTotalPrice((goods.getPrice()) * num);
				order.setDate(new Date());
				// 订单号格式yyyymmdd+六位流水号
				String serialNum = orderSerialServiceI.getCurrentSerialNum();
				order.setOrderNum(serialNum);
				order.setStatus(OrderStatus.ORDER.getStatus());
				order.setComment(comment);
				order.setAdress(adress);
				order.setEmail(email);
				order.setTel(tel);
				order.setName(name);
				Goods addedGoods = goodsServiceI.add(goods);
				Order addedOrder = orderServiceI.add(order);
				orderDetail.setOrder(addedOrder);
				orderDetail.setGoods(addedGoods);
				orderDetailServiceI.add(orderDetail);
				map.put("result", "true");
				session.setAttribute("orderNum", serialNum);
			}
		} catch (Exception e) {
			System.out.println(e);
			return map;
		}
		return map;
	}
	
//	@RequestMapping("/order")
//	public String order(String goodId, String number, String name, String adress, String tel,
//			String email, String comment, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		if (null == goodId || goodId.length() == 0 || null == number || number.length() == 0 || null == name
//				|| name.length() == 0 || null == adress || adress.length() == 0 || null == tel || tel.length() == 0
//				|| null == email || email.length() == 0) {
//			session.setAttribute("message", "訂單提交失敗，請稍後再試。");
//		}
//		Order order = new Order();
//		OrderDetail orderDetail = new OrderDetail();
//		try {
//			Goods goods = goodsServiceI.getById(goodId);
//			int num = Integer.parseInt(number);
//			if (null != goods && num > 0) {
//				orderDetail.setNumber(num);
//				order.setTotalPrice((goods.getPrice()) * num);
//				order.setDate(new Date());
//				// 订单号格式yyyymmdd+六位流水号
//				String serialNum = orderSerialServiceI.getCurrentSerialNum();
//				order.setOrderNum(serialNum);
//				order.setStatus(OrderStatus.ORDER.getStatus());
//				order.setComment(comment);
//				order.setAdress(adress);
//				order.setEmail(email);
//				order.setTel(tel);
//				order.setName(name);
//				Goods addedGoods = goodsServiceI.add(goods);
//				Order addedOrder = orderServiceI.add(order);
//				orderDetail.setOrder(addedOrder);
//				orderDetail.setGoods(addedGoods);
//				orderDetailServiceI.add(orderDetail);
//				session.setAttribute("result", "success");
//				session.setAttribute("orderNum", serialNum);
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//			session.setAttribute("result", "false");
//			session.setAttribute("message", "訂單提交失敗，請稍後再試。");
//		}
//		return "redirect:/success";
//	}
	
	@RequestMapping("/success")
	public String success() {
		return "success";
	}
	
	@RequestMapping("/orderNum")
	@ResponseBody
	public Map<String, Object> orderNum(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		HttpSession session = request.getSession();
		String orderNum = (String) session.getAttribute("orderNum");
		map.put("orderNum", session.getAttribute("orderNum"));
		Order order = orderServiceI.findByOrderNum(orderNum);
		List<OrderDetail> detailList = orderDetailServiceI.findByOrder(order);
		map.put("data", OrderDetailPageModel.convertToDetail(detailList));
		return map;
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	public static void main(String[] args) {
		Date date = new Date();

		System.out.println(DateUtil.formatDateToString(date));
	}
}
