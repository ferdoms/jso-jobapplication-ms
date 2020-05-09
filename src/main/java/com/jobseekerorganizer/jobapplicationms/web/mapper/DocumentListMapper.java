package com.jobseekerorganizer.jobapplicationms.web.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.jobseekerorganizer.jobapplicationms.domain.DocumentData;
import com.jobseekerorganizer.jobapplicationms.domain.JobApplication;
import com.jobseekerorganizer.jobapplicationms.web.model.DocumentDataDto;
import com.jobseekerorganizer.jobapplicationms.web.model.JobApplicationDto;


@Mapper
public interface DocumentListMapper {
	public List<DocumentDataDto> documentListToDocumentListDto(List<DocumentData> documentList);
	
	public List<DocumentData> documentListDtoToDocumentList(List<DocumentDataDto> documentListDto);
}
