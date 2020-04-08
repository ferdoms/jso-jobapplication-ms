package com.jobseekerorganizer.jobapplicationms.web.model;

import java.time.OffsetDateTime;
import java.util.Date;

import javax.validation.constraints.*;

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
	
	@NotBlank
	private String userId;

	@NotBlank
	@Min(2)
	private String companyName;
	
	@NotBlank
	@Min(2)
	private String jobTitle;
	
	@NotBlank
	@Min(2)
	private String jobDescription;
	
	@NotBlank
	private String status;
	
	@NotBlank
	private Date statusDate;
	
	@NotNull
	private String jobUrl;
}
