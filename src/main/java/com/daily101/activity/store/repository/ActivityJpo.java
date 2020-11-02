package com.daily101.activity.store.repository;

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
public class ActivityJpo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ISBN;
	private String title;
	private String author;
	private String publisher;
	private double price;
	private String imgUrl;
	private String introduce;
	
	@Builder
	public ActivityJpo(int ISBN,String title,String author,String publisher,double price,String imgUrl,String introduce) {
		this.ISBN = ISBN;
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.price=price;
		this.imgUrl=imgUrl;
		this.introduce=introduce;
		
	}
	
	public Activity toDomain() {
		Activity activity = Activity.builder()
				.ISBN(this.ISBN)
				.title(this.title)
				.author(this.author)
				.publisher(this.publisher)
				.price(this.price)
				.imgUrl(this.imgUrl)
				.introduce(this.introduce)
				.build();
		return activity;
	}
	
	public static List<Activity> toDomains(List<ActivityJpo> activityJpos) {
		return activityJpos.stream().map(ActivityJpo::toDomain).collect(Collectors.toList());
	}
	
}
