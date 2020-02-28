package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.app.model.User;

@Service
public class UserService {
	
	private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public UserService(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }
	
	public User read(String userId) {
		User user = dynamoDBMapper.load(User.class, userId);
		if (user != null) { 
		return user;
		} else {
			throw new ResourceNotFoundException("id="+userId, null);
		}
	}

	public User create(User user) {
		
		dynamoDBMapper.save(user);
		return user;
	}

	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		users=dynamoDBMapper.scan(User.class,new DynamoDBScanExpression());
		return users;
	}

	public ResponseEntity<String> update(String userId, User user) {
		dynamoDBMapper.save(user);
		return ResponseEntity.ok("Successfull");
	}

	public void delete(String userId) {
		User user = dynamoDBMapper.load(User.class, userId);
		dynamoDBMapper.delete(user);
		
	}

}