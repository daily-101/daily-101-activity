package com.daily101.activity.domain.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.daily101.activity.domain.Activity;

public interface ActivityService {

	public abstract List<Activity> ActivityList() throws NoSuchElementException;

	public abstract void ActivityInsert(Activity activity) throws NoSuchElementException;

}
