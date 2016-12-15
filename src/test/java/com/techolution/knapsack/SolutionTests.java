package com.techolution.knapsack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author saikiran
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolutionTests {

	@Autowired
	private org.springframework.web.context.WebApplicationContext webApplicationContext;
	ObjectMapper objectMapper;

	@Autowired
	Solution solution;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SolutionTests.class);

	private MockMvc mockMvc;

	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();

	}
	
	/**
	 * should return 2493893
	 * @throws IOException 
	 * 
	 */
	@Test
	public void testKnapsackExpectedToReturn2493893() throws IOException{
		int result = Solution.knapsack();
		assertNotNull(result);
		assertEquals(2493893, result);
 	}
	
	 
	/**
	 * readContentFromFileShouldReturnEmpty
	 * @throws IOException 
	 * 
	 */
	@Test
	public void readContentFromFileShouldReturnEmpty() throws IOException{
  		assertEquals("success",  Solution.readContentFromFile());
 	}
	
	
	/**
	 * after test
	 */
	@After
	public final void after() {
		
	}
}