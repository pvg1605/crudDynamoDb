package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.repository.UserRepository;

/**
 * The basic Crud Operations
 * 
 * @author praveenv
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Create Entity
	 * 
	 * @param user
	 * @return
	 */
	public User create(User user) {
		return userRepository.create(user);
	}
	
	/**
	 * Get all entities
	 * 
	 * @return
	 */
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		users=userRepository.getAll();
		if (users != null) {
		return users;
		} else {
			throw new ResourceNotFoundException("No users Found", null);
		}
	}
	
	/**
	 * Get Entity by Id
	 * 
	 * @param userId
	 * @return
	 */
	public User read(String userId) {
		User user = userRepository.read(userId);
		if (user != null) { 
		return user;
		} else {
			throw new ResourceNotFoundException("id="+userId, null);
		}
	}
	
	/**
	 * Update Entity
	 * 
	 * @param userId
	 * @param user
	 * @return
	 */
	public User update(String userId, User user) {
		return userRepository.update(user);
	}
	
	/**
	 * Delete Entity
	 * 
	 * @param userId
	 * @return
	 */
	public User delete(String userId) {
		return userRepository.delete(userId);
	}

}
