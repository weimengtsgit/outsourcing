/**
 * 
 */
package com.company.service;

import com.company.entity.Goods;

/**
 * @author czz
 *
 */
public interface GoodsServiceI extends BaseServiceI<Goods> {
	
	/**
	 * 根据id查询商品
	 * @return Goods
	 */
	public Goods getById(String id);
}
