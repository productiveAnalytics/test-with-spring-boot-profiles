package com.productiveAnalytics.springBoot.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Node {
	@Autowired
	private BzService bzSvc;
	
	public String process (String str) {
		System.out.println("**** Node is using impl class "+ bzSvc.getClass() +" ***");
		boolean successStatus = bzSvc.process(str);
		System.out.println("Exectution status : "+ successStatus);
		return Boolean.toString(successStatus);
	}
}
