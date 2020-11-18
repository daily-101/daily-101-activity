package com.daily101.activity.store.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.daily101.activity.domain.Activity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name="activity")
public class ActivityJpo extends BaseTimeEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double userId;
	private int time;
	private int calories;
	private double distance;
	
	
	@Builder
	public ActivityJpo(int id,LocalDateTime date,double userId,int time,int calories,double price,double distance) {
		super(date);
		this.id=id;
		this.userId=userId;
		this.time=time;
		this.calories=calories;
		this.distance=distance;
		
	}
	
	public Activity toDomain() {
		Activity activity = Activity.builder()
				.id(this.id)
				.userId(this.userId)
				.time(this.time)
				.calories(this.calories)
				.date(super.getDate())
				.distance(this.distance)
				.build();
		return activity;
	}
	
	public static List<Activity> toDomains(List<ActivityJpo> activityJpos) {
		return activityJpos.stream().map(ActivityJpo::toDomain).collect(Collectors.toList());
	}
	
}
