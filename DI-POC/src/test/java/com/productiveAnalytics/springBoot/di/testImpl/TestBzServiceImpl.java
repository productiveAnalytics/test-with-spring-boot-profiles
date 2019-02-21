package com.productiveAnalytics.springBoot.di.testImpl;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.productiveAnalytics.springBoot.di.BzService;
import com.productiveAnalytics.springBoot.di.DatastoreService;

@Service
@Profile("test")
public class TestBzServiceImpl implements BzService {
	
	@Autowired
	private DatastoreService testDatastoreSvc;

	@Override
	public boolean process(String searchParam) {
		System.err.println("<<TEST>> application logic...");
		String city = searchParam;
		Optional<Map<String, Object>> opReturn = testDatastoreSvc.retrieve(city);
		if (opReturn.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

}
