package com.jobseekerorganizer.jobapplicationms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.jobseekerorganizer.jobapplicationms.jwt.TokenAuthenticationService;
import com.jobseekerorganizer.jobapplicationms.config.DynamoDBConfig;

@Configuration
@Import({ DynamoDBConfig.class })
@ComponentScan
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, RedisAutoConfiguration.class })
public class JobApplicationMsApplication extends SpringBootServletInitializer {
	@Value("${ENC_KEY}")
	private String encKey;

	@Bean
	public TokenAuthenticationService tokenAuthService() {
		return new TokenAuthenticationService(encKey);
	}

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
