package com.jobseekerorganizer.jobapplicationms;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jobseekerorganizer.jobapplicationms.config.DynamoDBConfig;

import com.jobseekerorganizer.jobapplicationms.repository.JobApplicationRepository;

@EnableDynamoDBRepositories(mappingContextRef = "dynamoDBMappingContext", basePackageClasses = JobApplicationRepository.class)
@Configuration
@Import({DynamoDBConfig.class})
@ComponentScan
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableJpaRepositories(excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableScan.class) })

public class JobApplicationMsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(JobApplicationMsApplication.class, args);
//		System.out.println("something");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JobApplicationMsApplication.class);
	}

	private static Class<JobApplicationMsApplication> applicationClass = JobApplicationMsApplication.class;

}
