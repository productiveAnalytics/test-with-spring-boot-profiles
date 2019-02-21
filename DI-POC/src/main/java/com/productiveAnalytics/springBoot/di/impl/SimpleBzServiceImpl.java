package com.productiveAnalytics.springBoot.di.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.productiveAnalytics.springBoot.di.BzService;
import com.productiveAnalytics.springBoot.di.DatastoreService;

@Service
@Profile(value = {"dev", "qa"})
@Primary
public class SimpleBzServiceImpl implements BzService {

	@Autowired
	private DatastoreService datastoreSvc;
	
	protected void log(final String str) {
		System.out.println(str.replace("${PROFILE}", "Dev"));
	}
	
	@Override
	public boolean process(String searchParam) {
		this.log("[${PROFILE}] application logic...");
		String city = searchParam.toUpperCase();
		Optional<Map<String, Object>> opReturn = datastoreSvc.retrieve(city);
		if (opReturn.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

}
