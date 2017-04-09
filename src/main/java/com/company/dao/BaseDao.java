package com.company.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 集合了PagingAndSortingRepository和JpaSpecificationExecutor，同时增加了
 * EntityGraphName的功能，解决fetch mode是lazy时，会查询N+1次的问题。
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface BaseDao<T>
		extends PagingAndSortingRepository<T, String>, JpaSpecificationExecutor<T> {
	
	/**
	 * 使用EntityGraphName的功能
	 * @param spec
	 * @param pageable
	 * @param entityGraphType
	 * @param entityGraphName
	 * @return
	 */
	public Page<T> findAll(Specification<T> spec, 
			Pageable pageable, 
			EntityGraphType entityGraphType, 
			String entityGraphName);
	
	public List<T> query(String queryStr);
	public List<T> query(String queryStr, Map<String, Object> parameters, int start, int length);
}
