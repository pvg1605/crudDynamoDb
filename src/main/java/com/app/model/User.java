package com.app.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author praveenv
 *
 * Single class which will be responsible for modeling User entities:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName="dev-users")
@ApiModel(description = "Details about the users")
public class User {
	
	/**
	 * Primary Key of `dev-users` table
	 */
	@ApiModelProperty(notes = "The unique id of the user")
	@DynamoDBHashKey
	private String userId;
	
	@ApiModelProperty(notes = "User's name")
	@DynamoDBAttribute
	private String userName;
	
	@ApiModelProperty(notes = "User's email Id")
	@DynamoDBAttribute
	private String email;
	
	@ApiModelProperty(notes = "User's phone number")
	@DynamoDBAttribute
	private String phone;
}
