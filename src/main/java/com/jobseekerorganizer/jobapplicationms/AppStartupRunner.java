package com.jobseekerorganizer.jobapplicationms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.jobseekerorganizer.jobapplicationms.domain.JobApplication;

@Component
public class AppStartupRunner implements ApplicationRunner {
	@Autowired
	private AmazonDynamoDB amazonDynamoDB;
	@Autowired
	private DynamoDBMapper dynamoDBMapper;


	@Override
	public void run(ApplicationArguments args) throws Exception {
		CreateTableRequest ctr = dynamoDBMapper.generateCreateTableRequest(JobApplication.class)
				.withProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		TableUtils.createTableIfNotExists(amazonDynamoDB, ctr);
		TableUtils.waitUntilActive(amazonDynamoDB, ctr.getTableName());

	}

}