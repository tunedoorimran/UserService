package com.tunedoor.microservice.api;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunedoor.microservice.exception.UserNotFoundException;
import com.tunedoor.microservice.model.User;
import com.tunedoor.microservice.repository.UserRepository;

/**
 * 
 * @author Mohamed Saeed
 *
 */
@RestController
public class UserController {
	
	private Logger logger = Logger.getLogger(UserController.class.getName());
	private static final String NOT_FOUND_MESSAGE = "User with Id: %s not found";
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * To find if user exist or no
	 * @param userId
	 * @return All user details
	 */
	@RequestMapping("/user/find/{id}")
	public User findUser(@PathVariable("id") long userId){
		logger.info(String.format("Check if user with ID: %s exist",userId));
		User user = getUserRepository().findOne(userId);
		if(user == null){
			logger.info(String.format("User with ID: %s not exist",userId));
			throw new UserNotFoundException(String.format(NOT_FOUND_MESSAGE, userId));
		}
		logger.info(String.format("User with ID: %s exist",userId));
		return user;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}
}
