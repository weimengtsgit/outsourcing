/**
 * 
 */
package com.company.dao;

import com.company.entity.Goods;

/**
 * @author czz
 *
 */
public interface GoodsDaoI extends BaseDao<Goods> {

	public Goods findById(String id);

}
