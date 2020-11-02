package com.daily101.activity.application.web.dto;

import java.io.Serializable;

import com.daily101.activity.domain.Activity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ActivityDto implements Serializable{

	private int ISBN;
	private String title;
	private String author;
	private String publisher;
	private double price;
	private String imgUrl;
	private String introduce;
	
	@Builder
	public ActivityDto(int ISBN,String title,String author,String publisher,double price,String imgUrl,String introduce) {
		this.ISBN = ISBN;
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.price=price;
		this.imgUrl=imgUrl;
		this.introduce=introduce;
		
	}
	
	public Activity toEntity() {
		return Activity.builder()
				.ISBN(this.ISBN)
				.title(this.title)
				.author(this.author)
				.publisher(this.publisher)
				.price(this.price)
				.imgUrl(this.imgUrl)
				.introduce(this.introduce)
				.build();
	}
}
