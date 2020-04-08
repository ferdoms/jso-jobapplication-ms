package com.jobseekerorganizer.jobapplicationms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@ComponentScan
@SpringBootApplication
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

@RestController
class GreetingController {

    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return "Hello, nego " + name + "!";
    }
} 
