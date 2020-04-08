package com.jobseekerorganizer.jobapplicationms.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.jobseekerorganizer.jobapplicationms.domain.JobApplication;

@EnableScan
public interface JobApplicationRepository extends CrudRepository<JobApplication, String>{
	List<JobApplication> findByUserId(String userId);

}
