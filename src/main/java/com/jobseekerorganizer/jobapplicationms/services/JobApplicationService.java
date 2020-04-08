package com.jobseekerorganizer.jobapplicationms.services;

import java.util.List;

import com.jobseekerorganizer.jobapplicationms.web.model.JobApplicationDto;

public interface JobApplicationService {
	List<JobApplicationDto> getAllByUserId(String userId);
	JobApplicationDto getById(String userId, String jaId);
	JobApplicationDto create(JobApplicationDto newJADto);
	void delete(String jaId);
	void update(String jaId, JobApplicationDto jaDto);
}
