package com.jobseekerorganizer.jobapplicationms.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jobseekerorganizer.jobapplicationms.services.JobApplicationService;
import com.jobseekerorganizer.jobapplicationms.web.model.JobApplicationDto;

@RestController
public class JobApplicationController {
	
	@Autowired
	private JobApplicationService service;

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<JobApplicationDto>> getAll() {
//      TODO implement		
		return new ResponseEntity<>(service.getAllByUserId("f7f11d77-9641-4a6f-a7c0-25ada8494124"), HttpStatus.OK);
	}

	@GetMapping(path = "/{jaId}", produces = "application/json")
	public ResponseEntity<JobApplicationDto> getById(String jaId) {
		// TODO implement probably get userid from headers
		return new ResponseEntity<>(service.getById("Insert userId", jaId), HttpStatus.OK);
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity create(JobApplicationDto newJADto) {
		JobApplicationDto savedDTO = service.create(newJADto);
		
		HttpHeaders headers = new HttpHeaders();
		// TODO add hostname to url
		headers.add("Location", "/account" + savedDTO.toString());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{jaId}", consumes = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update( String jaId, JobApplicationDto jaDto){
		service.update(jaId, jaDto);
	}
	
	@DeleteMapping("/{jaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(String jaId) {
		service.delete(jaId);
	}

}
