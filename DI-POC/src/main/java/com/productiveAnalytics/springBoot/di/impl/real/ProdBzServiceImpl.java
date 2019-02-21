package com.productiveAnalytics.springBoot.di.impl.real;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.productiveAnalytics.springBoot.di.BzService;
import com.productiveAnalytics.springBoot.di.impl.SimpleBzServiceImpl;

@Service
@Profile("prod")
@Primary
public class ProdBzServiceImpl extends SimpleBzServiceImpl implements BzService {

	@Override
	public final void log(final String str) {
		System.out.println(str.replace("${PROFILE}", "PROD"));
	}
}
