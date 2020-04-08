package com.jobseekerorganizer.jobapplicationms.web.mapper;

import org.mapstruct.Mapper;

import com.jobseekerorganizer.jobapplicationms.domain.JobApplication;
import com.jobseekerorganizer.jobapplicationms.web.model.JobApplicationDto;

@Mapper
public interface JobApplicationMapper {
	public JobApplicationDto jobApplicationToJobApplicationDto(JobApplication ja);
	
	public JobApplication jobApplicationDtoToJobApplication(JobApplicationDto jaDto);
}
