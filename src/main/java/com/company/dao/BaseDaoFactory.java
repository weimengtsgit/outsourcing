package com.company.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryMetadata;

public class BaseDaoFactory extends JpaRepositoryFactory {

	@SuppressWarnings("unused")
	private final EntityManager em;
	
	public BaseDaoFactory(EntityManager entityManager) {
		super(entityManager);
		this.em = entityManager;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryMetadata metadata, EntityManager entityManager) {

		JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(metadata.getDomainType());
		return new BaseDaoImpl(entityInformation, entityManager); // custom implementation
	}
  
    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
 
    	return BaseDaoImpl.class;
    }
}
