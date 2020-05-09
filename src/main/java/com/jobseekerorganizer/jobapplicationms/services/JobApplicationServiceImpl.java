package com.jobseekerorganizer.jobapplicationms.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.jobseekerorganizer.jobapplicationms.domain.JobApplication;
import com.jobseekerorganizer.jobapplicationms.domain.JobApplicationSnapshot;
import com.jobseekerorganizer.jobapplicationms.repository.JobApplicationRepository;
import com.jobseekerorganizer.jobapplicationms.web.mapper.DocumentListMapper;
import com.jobseekerorganizer.jobapplicationms.web.mapper.JobApplicationMapper;
import com.jobseekerorganizer.jobapplicationms.web.model.JobApplicationDto;
import com.amazonaws.services.dynamodbv2.model.transform.GetJsonUnmarshaller;
import com.jobseekerorganizer.jobapplicationms.domain.DocumentData;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {
	
	@Autowired
	private JobApplicationRepository repository;
	
	@Autowired
	private JobApplicationMapper jobApplicationMapper;
	
	@Autowired
	private DocumentListMapper documentListMapper;

	@Override
	public List<JobApplicationDto> getAllByUserId(String userId) {
		List<JobApplicationDto> jobApplicationDtoList = new ArrayList();

		repository.findByUserId(userId).forEach(jobApplication -> {
			JobApplicationDto jaDto = jobApplicationMapper.jobApplicationToJobApplicationDto(jobApplication);
			jobApplicationDtoList.add(jaDto);
		});
		return jobApplicationDtoList;
	}

	@Override
	public JobApplicationDto getById(String userId, String jaId) {
		repository.findById(jaId);
		return null;
	}

	@Override
	public JobApplicationDto create(JobApplicationDto newJADto) {
		JobApplication ja = jobApplicationMapper.jobApplicationDtoToJobApplication(newJADto);
		
		JobApplication saved = repository.save(ja);
		// verify if user account was saved correctly
		Assert.hasLength(saved.getId(), "Could not create new job application: " + ja.toString());
		newJADto.setId(saved.getId());
		return newJADto;
	}

	@Override
	public void delete(String jaId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String jaId, JobApplicationDto jaDto) {
		Optional<JobApplication> found = repository.findById(jaId);

		Assert.isTrue(found.isPresent(), "User account not found for the given ID");

		found.ifPresent(updatedJobApplication -> {
			List<DocumentData> mappedDocumentList = documentListMapper.documentListDtoToDocumentList(jaDto.getDocumentList());
					
			updatedJobApplication.setCompanyName(jaDto.getCompanyName());
			updatedJobApplication.setJobTitle(jaDto.getJobTitle());
			updatedJobApplication.setJobDescription(jaDto.getJobDescription());
			updatedJobApplication.setJobUrl(jaDto.getJobUrl());
			updatedJobApplication.setStatusDate(new Date());
			updatedJobApplication.setStatus(jaDto.getStatus());
			updatedJobApplication.setDocumentList(mappedDocumentList);
			
			repository.save(updatedJobApplication);
		});

	}

}
