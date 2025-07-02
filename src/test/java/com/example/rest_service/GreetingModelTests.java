package com.example.rest_service;

import com.example.rest_service.models.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GreetingModelTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testGreetingFields(){
		Greeting greeting = new Greeting();
		greeting.setId(32);
		greeting.setMessage("Test message");

		assertEquals(32, greeting.getId())
	}


}
