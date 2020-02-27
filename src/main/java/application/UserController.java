package application;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public User createUser(@RequestBody User user) {
		return userService.create(user);
	}
	
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAll();
	}
	
	@RequestMapping("/users/{userId}")
	public User readUser(@PathVariable String userId) {
		 
		return userService.read(userId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}")
	public User updateUser(@Valid @RequestBody User user, @PathVariable String userId) {
		return userService.update(userId, user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
	public void deleteUser(@PathVariable String userId) {
		userService.delete(userId);
	}
}
