package com.jobseekerorganizer.jobapplicationms.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jobseekerorganizer.jobapplicationms.domain.AuthenticationTokenImpl;
import com.jobseekerorganizer.jobapplicationms.services.JobApplicationService;
import com.jobseekerorganizer.jobapplicationms.web.model.DocumentDataDto;
import com.jobseekerorganizer.jobapplicationms.web.model.JobApplicationDto;

@RestController
@RequestMapping("/jobapplication")
public class JobApplicationController {

	@Autowired
	private JobApplicationService service;

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<JobApplicationDto>> getAll(AuthenticationTokenImpl auth) {
		return new ResponseEntity<>(service.getAllByUserId(auth.getPrincipal().toString()), HttpStatus.OK);
	}

	@GetMapping(path = "/{jaId}", produces = "application/json")
	public ResponseEntity<JobApplicationDto> getById(String jaId) {
		return new ResponseEntity<>(service.getById("Insert userId", jaId), HttpStatus.OK);
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity create(AuthenticationTokenImpl auth, @Valid @RequestBody @Validated JobApplicationDto newJADto) {
		newJADto.setUserId(auth.getPrincipal().toString());
		JobApplicationDto savedDTO = service.create(newJADto);
		return new ResponseEntity<>(savedDTO, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{jaId}", consumes = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable String jaId, @Valid @RequestBody @Validated JobApplicationDto jaDto) {
		System.out.println(jaId);
		service.update(jaId, jaDto);
	}

	@DeleteMapping("/{jaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String jaId) {
		service.delete(jaId);
	}

}
