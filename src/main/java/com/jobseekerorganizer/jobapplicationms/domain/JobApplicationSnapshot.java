package com.jobseekerorganizer.jobapplicationms.domain;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBDocument
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplicationSnapshot {
	@DynamoDBAttribute
	private String actualStatus;
	@DynamoDBAttribute
	private Date logDate;
	@DynamoDBAttribute
	private String previousStatus;
}
