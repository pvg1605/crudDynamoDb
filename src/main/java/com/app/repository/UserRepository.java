package com.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.app.model.User;

/**
 *  Provides  basic CRUD funactionality on objects using DynamoDBMapper class
 * 
 * @author praveenv
 *
 */
@Repository
public class UserRepository {
	
	private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public UserRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }
	
    /*
     * Gets the requested user using load method.
     */
	public User read(String userId) {
		return dynamoDBMapper.load(User.class,userId);
		
	}

	/**
	 * Saves user in database
	 * 
	 * @param user
	 * @return
	 */
	public User create(User user) {
		
		dynamoDBMapper.save(user);
		return user;
	}

	/**
	 * Lists all users from table in database.
	 * @return
	 */
	public List<User> getAll() {
		return dynamoDBMapper.scan(User.class,new DynamoDBScanExpression());
		
	}

	/**
	 * Updates  user only if it already exists 
	 * @param user
	 * @return
	 */
	public User update(User user) {
		dynamoDBMapper.load(User.class,user.getUserId());
		dynamoDBMapper.save(user);
		return user;
	}

	/** 
	 * Deletes a specific user from database
	 * @param userId
	 * @return
	 */
	public User delete(String userId) {
		User user = dynamoDBMapper.load(User.class,userId);
		dynamoDBMapper.delete(user);
		return user;
		
	}

}
