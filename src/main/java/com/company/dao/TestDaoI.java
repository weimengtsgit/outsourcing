/**
 * 
 */
package com.company.dao;


import com.company.entity.TestEntity;

/**
 * @author czz
 *
 */
public interface TestDaoI extends BaseDao<TestEntity>{
	
	public TestEntity findByName(String name);

}
