package com.company.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class BaseDaoImpl<T> extends SimpleJpaRepository<T, String>implements BaseDao<T> {

	private EntityManager em;

	public BaseDaoImpl(final Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.em = em;
	}

	public BaseDaoImpl(final JpaEntityInformation<T, ?> entityInformation, EntityManager em) {
		super(entityInformation, em);
		this.em = em;
	}

	public Page<T> findAll(Specification<T> spec, Pageable pageable, EntityGraphType entityGraphType,
			String entityGraphName) {
		TypedQuery<T> query = getQuery(spec, pageable);
		if (entityGraphName != null && entityGraphName.length() > 0) {
			query.setHint(entityGraphType.getKey(), em.getEntityGraph(entityGraphName));
		}
		return readPage(query, pageable, spec);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> query(String queryStr) {
		return em.createQuery(queryStr).getResultList();
	}



	private Query createQuery(String sqlStr, Map<String, Object>params) {
		Query query = em.createQuery(sqlStr);
		if( params != null && !params.isEmpty()) {
			//Map<String, Object> params = queryHelper.getParamters();
			for( String key : params.keySet() ) {
				if( sqlStr.contains(":"+key) ) {
					query = query.setParameter(key, params.get(key));
				}
			}
		}
		return query;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> query(String queryStr, Map<String, Object> parameters, int start, int length) {
		return createQuery(queryStr, parameters).setFirstResult(start).setMaxResults(length).getResultList();
	}
}
