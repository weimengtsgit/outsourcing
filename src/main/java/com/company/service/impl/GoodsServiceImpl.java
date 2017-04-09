/**
 * 
 */
package com.company.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.BaseDao;
import com.company.dao.GoodsDaoI;
import com.company.entity.Goods;
import com.company.service.GoodsServiceI;

/**
 * @author czz
 *
 */
@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods>implements GoodsServiceI {
	
	@Autowired
	private GoodsDaoI goodsDaoI;
	
	@Override
	public BaseDao<Goods> getDao() {
		return goodsDaoI;
	}

	@Override
	public Goods getById(String id) {
		return goodsDaoI.findById(id);
	}
	
}
