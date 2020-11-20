package com.daily101.activity.store.repository;

import java.util.List;

public interface ActivityStoreJpaRepositoryCustom {

	List<ActivityJpo> findByQuery(String query);

}
