package com.aws.dynamodb.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfig {

    public static final String ENDPOINT = "dynamodb.ap-south-1.amazonaws.com";
    public static final String REGION = "ap-south-1";
    public static final String KEY = "AKIARZXLNIWANII4M2WN";
    public static final String SECRET = "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";

    @Bean
    public DynamoDBMapper mapper() {
        return new DynamoDBMapper(amazonConfig());
    }

    private AmazonDynamoDB amazonConfig() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT, REGION))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(KEY, SECRET)))
                .build();
    }
}
