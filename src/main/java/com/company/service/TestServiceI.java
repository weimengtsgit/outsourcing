/**
 * 
 */
package com.company.service;

import com.company.entity.TestEntity;

/**
 * @author czz
 *
 */
public interface TestServiceI extends BaseServiceI<TestEntity> {
	
	/**
	 * 根据姓名
	 * 
	 */
	public TestEntity getbyName(String name);
}
