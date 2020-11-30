package com.daily101.activity.store.logic;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daily101.activity.domain.Activity;
import com.daily101.activity.store.ActivityStore;
import com.daily101.activity.store.repository.ActivityJpo;
import com.daily101.activity.store.repository.ActivityStoreJpaRepository;
import com.daily101.activity.store.repository.ActivityStoreJpaRepositoryCustom;

@Repository
public class ActivityStoreJpaImpl implements ActivityStore {

	@Autowired 
	ActivityStoreJpaRepository repository;
	
	@Autowired
	ActivityStoreJpaRepositoryCustom repocustom;
	
	@Override
	public List<Activity> findAll() throws NoSuchElementException {
		// TODO Auto-generated method stub
		List<ActivityJpo> activity = repository.findAll();
		return ActivityJpo.toDomains(activity);
	}

	@Override
	public void insert(Activity activity) throws NoSuchElementException {
		// TODO Auto-generated method stub
		repository.save(ActivityJpo.builder()
				.userId(activity.getUserId())
				.time(activity.getTime())
				.calories(activity.getCalories())
				.distance(activity.getDistance())
				.build());
	}

	@Override
	public List<Activity> findDateAll(String today, double userid) throws NoSuchElementException {
		String query = "SELECT * FROM activity WHERE DATE(date) = '"+today+"'"+"and user_id="+userid;
		List<ActivityJpo> activity = repocustom.findByQuery(query);
		return ActivityJpo.toDomains(activity);
	}


}
