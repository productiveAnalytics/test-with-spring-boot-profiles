package com.productiveAnalytics.springBoot.di.impl.real;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.productiveAnalytics.springBoot.di.DatastoreService;
import com.productiveAnalytics.springBoot.di.impl.InMemoryDatastoreServiceImpl;

@Repository
@Profile("prod")
@Primary
public class DBServiceImpl extends InMemoryDatastoreServiceImpl implements DatastoreService {
	
	@Override
	public final void log(final String str) {
		System.out.println(str.replace("${PROFILE}", "PROD"));
	}
}
