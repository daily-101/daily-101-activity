package com.daily101.activity.application.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	
}
