package com.jobseekerorganizer.jobapplicationms.web.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.*;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.jobseekerorganizer.jobapplicationms.domain.DocumentData;
import com.jobseekerorganizer.jobapplicationms.domain.JobApplicationSnapshot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplicationDto {
	
	@Null
	private String id;
	
	@Null
	private String userId;

	@NotBlank
	@Size(min = 2)
	private String companyName;
	
	@NotBlank
	@Size(min = 2)
	private String jobTitle;
	
	@NotBlank
	@Size(min = 2)
	private String jobDescription;
	
	@NotBlank
	private String status;
	
	@NotNull
	private Date statusDate;
	
	@NotNull
	private String jobUrl;
	
// TODO make this properties available	
//	@NotNull
//	private Date reminderDate;
//	
//	@NotNull
//	private boolean remainderOn;
//	
	
	private List<DocumentDataDto> documentList = new ArrayList<DocumentDataDto>();
	
	private List<JobApplicationSnapshotDto> jobApplicationLog = new ArrayList<JobApplicationSnapshotDto>();
}
