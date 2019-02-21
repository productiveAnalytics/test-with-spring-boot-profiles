package com.productiveAnalytics.springBoot.di.testImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.productiveAnalytics.springBoot.di.DatastoreService;

@Repository
@Profile("test")
public class TestDatastoreServiceImpl implements DatastoreService {

	@Override
	public Optional<Map<String, Object>> retrieve(String city) {
		System.err.println("<<TEST>> persistence logic...");
		
		if ("MUMBAI".equals(city))
		{
			Map<String, Object> kv = new HashMap<String, Object>();
			kv.put("Country", "India");
			kv.put("Population", 12000000);
			kv.put("lang", "Marathi");
			
			return Optional.of(kv);
		}
		else {
			return Optional.empty();
		}
	}

}
