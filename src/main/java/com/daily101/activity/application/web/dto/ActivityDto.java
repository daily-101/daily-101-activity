package com.daily101.activity.application.web.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.daily101.activity.domain.Activity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ActivityDto implements Serializable{

	private int id;
	private double userId;
	private int time;
	private int calories;
	private double distance;
	private LocalDateTime date;
	
	
	@Builder
	public ActivityDto(int id,double userId,int time,int calories,double distance,LocalDateTime date) {
		this.id = id;
		this.userId=userId;
		this.time=time;
		this.calories=calories;
		this.distance=distance;
		this.date=date;
	
	}
	
	public Activity toEntity() {
		return Activity.builder()
				.id(this.id)
				.userId(this.userId)
				.time(this.time)
				.calories(this.calories)
				.distance(this.distance)
				.date(this.date)
				.build();
	}
}
