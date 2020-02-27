package application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

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

	public User create(User user) {
		
		dynamoDBMapper.save(user);
		return user;
	}

	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		users=dynamoDBMapper.scan(User.class,new DynamoDBScanExpression());
		return users;
	}

	public User update(String userId, User user) {
		dynamoDBMapper.load(User.class, userId);
		dynamoDBMapper.save(user);
		return user;
	}

	public void delete(String userId) {
		User user = dynamoDBMapper.load(User.class, userId);
		dynamoDBMapper.delete(user);
		
	}

}
