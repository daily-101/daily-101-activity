package com.daily101.activity.domain;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.daily101.activity.application.web.dto.ActivityDto;
import com.google.gson.Gson;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //default constructor 생성
@Data
public class Activity {
	private int id;
	private double userId;
	private int time;
	private int calories;
	private double distance;
	private LocalDateTime date;
	
	
	@Builder
	public Activity(int id,double userId,int time,int calories,double distance,LocalDateTime date) {
		this.id = id;
		this.userId=userId;
		this.time=time;
		this.calories=calories;
		this.distance=distance;
		this.date=date;
	
	}
	
	
	public ActivityDto toDto() {//dto 로 변환하는 함수
		return ActivityDto.builder()
				.id(this.id)
				.userId(this.userId)
				.time(this.time)
				.calories(this.calories)
				.distance(this.distance)
				.date(this.date)
				.build();
	}
	
	public static List<ActivityDto> toDtoList(List<Activity> activity){
		return activity.stream().map(Activity::toDto).collect(Collectors.toList());
	}
	
	@Override
	public String toString() {
		Gson json = new Gson();
		return json.toJson(this);
	}
	
}
