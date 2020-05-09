package com.jobseekerorganizer.jobapplicationms.web.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentDataDto {
	@Null
	private String id;
	@NotBlank
	private String name;
}
