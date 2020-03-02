package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @author praveenv
 *
 * Controller class will for handling all HTTP requests.
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Create User
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/")
	@ApiOperation(value = "To add a new user",notes = "Provide an id for the user in request body",response = User.class)
	public User createUser(@RequestBody User user) {
		return userService.create(user);
	}
	
	/**
	 * Returns all users
	 * 
	 * @return
	 */
	@GetMapping("/")
	@ApiOperation(value = "Find all users",response = User.class)
	public List<User> getAllUsers() {
		return userService.getAll();
	}
	
	/**
	 * Get a specific user for given a userId
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/{userId}")
	@ApiOperation(value = "Find user by Id ",notes="Provide an id to look up specific user",response=User.class)
	public User readUser(@ApiParam(value = "ID value for the user you need to retrieve",required = true)@PathVariable String userId) {
		 
		return userService.read(userId);
	}
	
	/**
	 * Update a specific user for given a userId
	 * 
	 * @param user
	 * @param userId
	 * @return
	 */
	@PutMapping("/{userId}")
	@ApiOperation(value = "Update an already existing user",notes = "Provide an id to update specific user",response=User.class)
	public User updateUser(@ApiParam(value = "ID value for the user you need to update",required = true)@Valid @RequestBody User user, @PathVariable String userId) {
		return userService.update(userId, user);
	}
	
	/**
	 * Delete a specific user for given a userId
	 * 
	 * @param userId
	 * @return
	 */
	@DeleteMapping("/{userId}")
	@ApiOperation(value="Delete user",notes = "Provide an id to delete specific user",response = User.class)
	public User deleteUser(@ApiParam(value = "ID value for the user you need to delete",required = true)@PathVariable String userId) {
		return userService.delete(userId);
	}
}
