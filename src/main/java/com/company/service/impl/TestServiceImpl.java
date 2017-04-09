/**
 * 
 */
package com.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.BaseDao;
import com.company.dao.TestDaoI;
import com.company.entity.TestEntity;
import com.company.service.TestServiceI;

/**
 * @author czz
 *
 */
@Service
public class TestServiceImpl extends BaseServiceImpl<TestEntity> implements TestServiceI {
	
	@Autowired
	private TestDaoI testDaoI;
	
	@Override
	public TestEntity getbyName(String name) {
		return testDaoI.findByName(name);
	}

	@Override
	public BaseDao<TestEntity> getDao() {
		return testDaoI;
	}

}
