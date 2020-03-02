package com.app.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.model.User;
import com.app.repository.UserRepository;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author praveenv
 *
 *Unit tests for UserService
 *Create a mock UserRepository  and then inject mock to userService.
 */
@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
    private UserRepository userRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	
	@Test
	public void read() {
		User user = new User("1","pvg",null,null);
		
		when(userRepository.read(user.getUserId())).thenReturn(user);
		
		User user1 = userService.read("1");
		
		assertEquals(user.getUserName(),user1.getUserName());
		assertEquals(user.getEmail(),user1.getEmail());
		assertEquals(user.getPhone(),user1.getPhone());
		}
	@Test
	public void getAll() {
		List<User> users = new ArrayList<User>();
		User user = new User("1","pvg",null,null);
		User user1 = new User("2","prajju","mail@com",null);
		users.add(user);
		users.add(user1);
		
		when(userRepository.getAll()).thenReturn(users);
		List<User> userList = userService.getAll();
		assertEquals(2,userList.size());
		verify(userRepository, times(1)).getAll();
	}
	@Test
	public void create() {
		User user = new User("1","pvg",null,null);
		
		when(userRepository.create(user)).thenReturn(user);
		
		User user1 = userService.create(user);
		
		assertEquals(user.getUserName(),user1.getUserName());
		assertEquals(user.getEmail(),user1.getEmail());
		assertEquals(user.getPhone(),user1.getPhone());
		
		verify(userRepository,times(1)).create(user);
	}
	
	@Test
	public void update() {
		User user = new User("1","pvg",null,null);
		
		when(userRepository.update(user)).thenReturn(user);
		User user1 = userService.update(user.getUserId(),user);
		
		assertEquals(user.getUserName(),user1.getUserName());
		assertEquals(user.getEmail(),user1.getEmail());
		assertEquals(user.getPhone(),user1.getPhone());	
		
		verify(userRepository,times(1)).update(user);
	}
	@Test
	public void delete() {
		User user = new User("1","pvg",null,null);
		
		when(userRepository.delete(user.getUserId())).thenReturn(user);
		User user1 = userService.delete(user.getUserId());
		
		assertEquals(user.getUserName(),user1.getUserName());
		assertEquals(user.getEmail(),user1.getEmail());
		assertEquals(user.getPhone(),user1.getPhone());	
		
		verify(userRepository,times(1)).delete(user.getUserId());
	}
}