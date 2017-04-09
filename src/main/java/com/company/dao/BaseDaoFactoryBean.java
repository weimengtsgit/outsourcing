package com.company.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class BaseDaoFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable>
		extends JpaRepositoryFactoryBean<T, S, ID> {

	public BaseDaoFactoryBean(Class<? extends T> repositoryInterface) {
		super(repositoryInterface);
	}

	/**
	 * Returns a {@link RepositoryFactorySupport}.
	 *
	 * @param entityManager
	 * @return
	 */
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {

		return new BaseDaoFactory(entityManager);
	}
}
