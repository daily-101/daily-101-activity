package com.daily101.activity.domain.service.logic;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily101.activity.domain.Activity;
import com.daily101.activity.domain.service.ActivityService;
import com.daily101.activity.store.ActivityStore;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityStore store;
	
	@Override
	public List<Activity> ActivityList() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return store.findAll();
	}

	@Override
	public void ActivityInsert(Activity activity) throws NoSuchElementException {
		// TODO Auto-generated method stub
		store.insert(activity);
	}

}
