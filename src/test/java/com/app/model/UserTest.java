package com.app.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 
 * @author praveenv
 *
 * Unit test for model class
 *
 */
@RunWith(SpringRunner.class)

public class UserTest {

	public String EXPECTED_USER_ID = "1";
    public String EXPECTED_USER_NAME = "pvg";
	public String EXPECTED_EMAIL = "pvg@com";
	public String EXPECTED_PHONE = "9876543210";
	
	private User user;
	
	@Before
    public void setUp() {
		user = new User("1","pvg","pvg@com","9876543210");
    }
	
	@Test
	public void testUserDetails() {
			
			 assertEquals(EXPECTED_USER_ID, user.getUserId());
			 assertEquals(EXPECTED_USER_NAME, user.getUserName());
			 assertEquals(EXPECTED_EMAIL, user.getEmail());
		     assertEquals(EXPECTED_PHONE, user.getPhone());

	    }
	}


