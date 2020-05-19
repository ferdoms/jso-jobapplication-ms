package com.jobseekerorganizer.jobapplicationms.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jobseekerorganizer.jobapplicationms.domain.AuthenticationTokenImpl;
import com.jobseekerorganizer.jobapplicationms.services.FileStorageService;
import com.jobseekerorganizer.jobapplicationms.services.JobApplicationService;
import com.jobseekerorganizer.jobapplicationms.web.model.DocumentDataDto;
import com.jobseekerorganizer.jobapplicationms.web.model.JobApplicationDto;
import com.jobseekerorganizer.jobapplicationms.web.model.UploadFileDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/jobapplication")
public class JobApplicationController {

	@Autowired
	private JobApplicationService service;

    @Autowired
    private FileStorageService fileStorageService;

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
	
	@PostMapping("/uploadFile")
    public UploadFileDto uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileDto(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }
	

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileDto> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            log.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
