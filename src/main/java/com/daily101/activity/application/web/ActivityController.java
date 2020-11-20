package com.daily101.activity.application.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daily101.activity.application.web.dto.ActivityDto;
import com.daily101.activity.domain.Activity;
import com.daily101.activity.domain.service.ActivityService;

@RestController
@RequestMapping("/api/activity/")
public class ActivityController {
	
	@Autowired
	private ActivityService service;
	
	@GetMapping
	public List<ActivityDto> ActivityList(){
		return Activity.toDtoList(service.ActivityList());
	}
	
	@PostMapping
	public void ActivityInsert(@RequestBody ActivityDto activity) {
		service.ActivityInsert(activity.toEntity());
	}
	
	@GetMapping("{date}/{userid}")
	public List<ActivityDto> ActivityDateList(@PathVariable Date date,@PathVariable double userid){
		
		SimpleDateFormat format1;
		format1 = new SimpleDateFormat("yyyy-MM-dd");
		String today =  (format1.format(date));
		
		System.out.println("날짜 조회 성공 "+today);
		
		return Activity.toDtoList(service.ActivityDateList(today,userid));
	}
	
	
}
