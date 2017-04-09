package com.company.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.entity.Goods;
import com.company.entity.TestEntity;
import com.company.service.GoodsServiceI;
import com.company.service.TestServiceI;

@Controller
public class TestController {
	
	@Autowired
	private TestServiceI testServiceI;
	
	@Autowired
	private GoodsServiceI goodsServiceI;
	
	@RequestMapping("/index1111")
	@ResponseBody
	public Map<String, Object> index() {
		Map<String, Object> map = new HashMap<>();
		TestEntity testEntity = testServiceI.getbyName("xiaoming");
		map.put("name", "xiaoming");
		map.put("age", testEntity.getAge());
		return map;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public Map<String, Object> insert() {
		Map<String, Object> map = new HashMap<>();
		TestEntity t = new TestEntity();
		t.setAge("12");
		t.setName("xioawang");
		try {
			TestEntity testEntity = testServiceI.add(t);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		map.put("status", "done");
		return map;
	}
	
	@RequestMapping("/insertGood")
	@ResponseBody
	public Map<String, Object> insertGood() {
		Map<String, Object> map = new HashMap<>();
		Goods goods = new Goods();
		goods.setName("犰狳發聲玩具");
		goods.setPrice(179);
		try {
			Goods dasd = goodsServiceI.add(goods);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		map.put("status", "done");
		return map;
	}
	
	
	@RequestMapping("/")
	public String main() {
		return "/index";
	}
}
