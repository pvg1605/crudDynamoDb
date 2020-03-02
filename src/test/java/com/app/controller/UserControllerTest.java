package com.app.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.app.controller.UserController;
import com.app.model.User;
import com.app.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author praveenv
 *
 *Write tests for UserController by injecting a Mock UserService bean and invoke API endpoints using MockMvc.
 *As SpringBoot is creating the UserController instance we are creating mock UserService bean using Spring’s @MockBean.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    
    @Autowired
    private ObjectMapper objectMapper;
    
	@Test
	public void getAllUsers() throws Exception {
		User user = new User();
        user.setUserId("1");
        user.setUserName("Praveen");
        user.setEmail("praveen.v@practo.com");
        user.setPhone("9876543210");

        List<User> users = Arrays.asList(user);
        given(userService.getAll()).willReturn(users);

        // when + then
        this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'userId': '1','userName': 'Praveen','email': 'praveen.v@practo.com','phone': '9876543210' }]"));
	}
	
	@Test
	public void getUser() throws Exception {
		User user = new User();
        user.setUserId("1");
        user.setUserName("Praveen");
        user.setEmail("praveen.v@practo.com");
        user.setPhone("9876543210");

        given(userService.read("1")).willReturn(user);

        // when + then
        this.mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'userId': '1','userName': 'Praveen','email': 'praveen.v@practo.com','phone': '9876543210' }"));
	}
	@Test
	public void addUser() throws Exception {
		User user = new User();
        user.setUserId("1");
        user.setUserName("Praveen");
        user.setEmail("praveen.v@practo.com");
        user.setPhone("9876543210");        
        given(userService.create(user)).willReturn(user);
        
        this.mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(objectMapper.writeValueAsString(user)))
        	.andExpect(status().isOk());
	}
	@Test
	public void updateUser() throws Exception {
		User user = new User();
        user.setUserId("1");
        user.setUserName("Praveen");
        user.setEmail("praveen.v@practo.com");
        user.setPhone("9876543210");
        
        given(userService.update("1",user)).willReturn(user);
        
        this.mockMvc.perform(put("/users/1").contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(objectMapper.writeValueAsString(user)))
        	.andExpect(status().isOk());
	}
	@Test
	public void deleteUser() throws Exception {
		User user = new User();
        user.setUserId("1");
        user.setUserName("Praveen");
        user.setEmail("praveen.v@practo.com");
        user.setPhone("9876543210");
        
        given(userService.delete("1")).willReturn(user);
        
        this.mockMvc.perform(delete("/users/1"))
        	.andExpect(status().isOk());
	}
}
