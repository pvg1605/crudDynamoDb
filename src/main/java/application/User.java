package application;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

@Data
@DynamoDBTable(tableName="dev-users")
public class User {
	
	@DynamoDBHashKey
	private String userId;
	
	@DynamoDBAttribute
	private String userName;
	
	@DynamoDBAttribute
	private String email;
	
	@DynamoDBAttribute
	private String phone;
}
