package com.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

/**
 * 
 * @author praveenv
 *
 * This is to Configure DynamoDB Database using properties mentioned in application.properties 
 */
@Configuration
public class DynamoConfig {

	@Value("${amazon.dynamodb.endpoint}")
	private String amazonDynamoDBEndpoint;
	
	@Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;
 
    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;
    
    @Value("${amazon.aws.region}")
    private String amazonAWSRegion;
    
    /**
     *  To map your client-side classes to Amazon DynamoDB tables. 
     * 
     * 
     * @return DynamoDBMapper class that enables you to access your tables; 
     * perform various create, read, update, and delete (CRUD) operations;
     *  and execute queries.
     */
    @Bean
    public DynamoDBMapper mapper() {
    	return new DynamoDBMapper(amazonDynamoDBconfig());
    }

    /**
     * Creates a client
     * 
     * @return client that talks to DynamoDB
     */
    public AmazonDynamoDB amazonDynamoDBconfig() {
	return AmazonDynamoDBClientBuilder.standard()
			.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(amazonDynamoDBEndpoint,amazonAWSRegion))
			.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(amazonAWSAccessKey,amazonAWSSecretKey)))
			.build();
}
}
