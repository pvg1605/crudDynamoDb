package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Service
public class UserService {
	
	private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public UserService(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }
	
	public User read(String userId) {
		return dynamoDBMapper.load(User.class, userId);
	}

}
