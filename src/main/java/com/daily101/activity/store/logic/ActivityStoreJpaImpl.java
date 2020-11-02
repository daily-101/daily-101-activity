package com.daily101.activity.store.logic;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daily101.activity.domain.Activity;
import com.daily101.activity.store.ActivityStore;
import com.daily101.activity.store.repository.ActivityJpo;
import com.daily101.activity.store.repository.ActivityStoreJpaRepository;

@Repository
public class ActivityStoreJpaImpl implements ActivityStore {

	@Autowired 
	ActivityStoreJpaRepository repository;
	
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
				.ISBN(activity.getISBN())
				.title(activity.getTitle())
				.author(activity.getAuthor())
				.publisher(activity.getPublisher())
				.price(activity.getPrice())
				.imgUrl(activity.getImgUrl())
				.introduce(activity.getIntroduce())
				.build());
	}

}
