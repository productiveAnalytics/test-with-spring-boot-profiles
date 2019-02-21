package com.productiveAnalytics.springBoot.di.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.productiveAnalytics.springBoot.di.DatastoreService;

@Repository
@Profile(value = {"dev", "qa"})
@Primary
public class InMemoryDatastoreServiceImpl implements DatastoreService {
	
	private static final Map<String, Map<String, Object>> CACHE;
	
	static {
		CACHE = new TreeMap<>();
		
		Map<String, Object> kv;
		
		{
			kv = new HashMap<String, Object>();
			kv.put("Country", "India");
			kv.put("Population", 12000000);
			kv.put("lang", "Marathi");
			
			CACHE.put("MUMBAI", kv);
		}
		
		{
			kv = new HashMap<String, Object>();
			kv.put("Country", "USA");
			kv.put("Population", 10000000);
			kv.put("lang", "English (US)");
			
			CACHE.put("NEW YORK", kv);
		}
		
		{
			kv = new HashMap<String, Object>();
			kv.put("Country", "Singapore");
			kv.put("Population", 500000);
			kv.put("lang", "Chinese/Malesian/Tamil");
			
			CACHE.put("SINGAPORE", kv);
		}
		
	}
	
	protected void log(final String str) {
		System.out.println(str.replace("${PROFILE}", "Dev"));
	}
	
	@Override
	public Optional<Map<String, Object>> retrieve(String city) {
		this.log("[${PROFILE}] datastrore access logic...");
		Map<String, Object> foundProperties = CACHE.get(city);
		
		if (foundProperties != null) {
			this.log("   [${PROFILE}] City = "+ city);
			foundProperties.entrySet().forEach(e -> 
												this.log(String.format("      [${PROFILE}] %s = %s ", e.getKey() ,e.getValue()))
											  );
		}
		
		return Optional.ofNullable(foundProperties);
	}

}
