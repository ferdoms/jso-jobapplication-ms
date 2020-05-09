package com.jobseekerorganizer.jobapplicationms.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Data;

@Data
public class SessionUser {
	
	private String userId;
	private String password;
	private Date createdAt;
	
	public boolean hasExpired() {
		if(createdAt == null) {
			return true;
		}
		LocalDateTime localDateTime = createdAt.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localDateTime = localDateTime.plusHours(1);
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()).before(new Date());
	}
}
