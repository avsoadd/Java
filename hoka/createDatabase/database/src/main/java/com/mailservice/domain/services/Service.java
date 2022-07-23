package com.mailservice.domain.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.mailservice.repositories.UserInfoRepository;

public class Service {
	@Autowired
	public UserInfoRepository userInfoRepository;
	
	public String getUserName() {
		 Map<String, Object> userInfo = userInfoRepository.getUser();
		 return userInfo.get("id").toString();
	}
}
