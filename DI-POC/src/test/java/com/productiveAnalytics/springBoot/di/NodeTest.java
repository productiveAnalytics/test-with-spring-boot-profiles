package com.productiveAnalytics.springBoot.di;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.productiveAnalytics.springBoot.di.testImpl.TestBzServiceImpl;
import com.productiveAnalytics.springBoot.di.testImpl.TestDatastoreServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest (classes={Node.class, TestBzServiceImpl.class, TestDatastoreServiceImpl.class})
//@ContextConfiguration (classes={Node.class, TestBzServiceImpl.class, TestDatastoreServiceImpl.class})
@ActiveProfiles("test")	// Must activate profile to DI test classes
public class NodeTest {
	
	@Autowired
	private Node testNode;
	
	@Autowired
    private Environment environment;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testProcess() {
		Assert.assertNotNull("Class under test \"Node\" should not be null", testNode);
		
		String testRequest, testResponse;
		
		testRequest  = "MUMBAI";
		testResponse = this.testNode.process(testRequest);
		Assert.assertEquals("Expecting success", Boolean.TRUE.toString(), testResponse);
	
		testRequest  = "Orion";
		testResponse = this.testNode.process(testRequest);
		Assert.assertFalse("Expecting 'false'", Boolean.valueOf(testResponse));
	}
	
	@Test
	public final void testActiveProfiles() {
		String[] activeProfiles = environment.getActiveProfiles();
		Assert.assertTrue("Expecting at least one active profile", (activeProfiles!=null && activeProfiles.length > 0));
		
		for (int idx = 0; idx < activeProfiles.length; ++idx) {
			System.err.println(String.format("Active Profile [%d] = %s", idx, activeProfiles[idx]));
		}
	}

}
