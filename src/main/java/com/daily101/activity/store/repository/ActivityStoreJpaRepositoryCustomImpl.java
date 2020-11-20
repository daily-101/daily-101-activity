package com.daily101.activity.store.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ActivityStoreJpaRepositoryCustomImpl implements ActivityStoreJpaRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<ActivityJpo> findByQuery(String query) {
		// TODO Auto-generated method stub
		return entityManager.createNativeQuery(query,ActivityJpo.class).getResultList();
		
	}

}
