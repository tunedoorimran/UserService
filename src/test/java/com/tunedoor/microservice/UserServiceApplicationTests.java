package com.tunedoor.microservice;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tunedoor.microservice.api.UserController;
import com.tunedoor.microservice.exception.UserNotFoundException;
import com.tunedoor.microservice.model.User;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceApplicationTests {
	
	@BeforeClass
	public static void setConfiguration(){
		System.setProperty("spring.config.name", "user-server-test");
	}

	@Autowired
	UserController userController;
	
	@Test
	public void validUserExist() {
		User user = userController.findUser(2);
		Assert.assertNotNull(user);
	}

	@Test
	public void invalidUserNotExist() {
		try {
			userController.findUser(11);
			Assert.fail("Expected an UserNotFoundException");
		} catch (UserNotFoundException e) {
		}
	}
}
