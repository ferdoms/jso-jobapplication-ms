package com.jobseekerorganizer.jobapplicationms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobseekerorganizer.jobapplicationms.repository.JobApplicationRepository;
import com.jobseekerorganizer.jobapplicationms.web.mapper.JobApplicationMapper;
import com.jobseekerorganizer.jobapplicationms.web.model.JobApplicationDto;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {
	@Autowired
	private JobApplicationRepository repository;
	@Autowired
	private JobApplicationMapper jobApplicationMapper;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobApplicationDto create(JobApplicationDto newJADto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String jaId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String jaId, JobApplicationDto jaDto) {
		// TODO Auto-generated method stub

	}

}
