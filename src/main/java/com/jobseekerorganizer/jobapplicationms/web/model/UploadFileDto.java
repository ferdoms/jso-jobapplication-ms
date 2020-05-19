package com.jobseekerorganizer.jobapplicationms.web.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadFileDto {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
    
}
