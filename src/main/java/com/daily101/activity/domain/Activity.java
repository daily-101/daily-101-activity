package com.daily101.activity.domain;


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
	private int ISBN;
	private String title;
	private String author;
	private String publisher;
	private double price;
	private String imgUrl;
	private String introduce;
	
	
	@Builder
	public Activity(int ISBN,String title,String author,String publisher,double price,String imgUrl,String introduce) {
		this.ISBN = ISBN;
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.price=price;
		this.imgUrl=imgUrl;
		this.introduce=introduce;
	}
	
	
	public ActivityDto toDto() {//dto 로 변환하는 함수
		return ActivityDto.builder()
				.ISBN(this.ISBN)
				.title(this.title)
				.author(this.author)
				.publisher(this.publisher)
				.price(this.price)
				.imgUrl(this.imgUrl)
				.introduce(this.introduce)
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
