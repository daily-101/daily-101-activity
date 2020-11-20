package com.daily101.activity.store;

import java.util.List;
import java.util.NoSuchElementException;

import com.daily101.activity.domain.Activity;

public interface ActivityStore {

	public abstract List<Activity> findAll() throws NoSuchElementException;

	public abstract void insert(Activity activity) throws NoSuchElementException;

	public abstract List<Activity> findDateAll(String today, double userid) throws NoSuchElementException;

}
