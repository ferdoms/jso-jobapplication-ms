package com.jobseekerorganizer.jobapplicationms.bootstrap;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jobseekerorganizer.jobapplicationms.domain.JobApplication;
import com.jobseekerorganizer.jobapplicationms.repository.JobApplicationRepository;

@Component
public class JobApplicationLoader implements CommandLineRunner {
	
	@Autowired
	private JobApplicationRepository repository;
	
	@Override
	public void run(String... args) throws Exception{
		loadJAObjects();
	}
	
	private void loadJAObjects() {
		if(repository.count() == 0) {
			repository.save(JobApplication.builder()
					.userId("f7f11d77-9641-4a6f-a7c0-25ada8494124")
					.companyName("Dabtype")
					.jobTitle("Account Representative IV")
					.jobDescription("In congue. Etiam justo. Etiam pretium iaculis justo.\\n\\nIn hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.\\n\\nNulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.\\n\\nCras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.\\n\\nQuisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.\\n\\nPhasellus in felis. Donec semper sapien a libero. Nam dui.\\n\\nProin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.")
					.status("Interview")
					.statusDate(new Date())
					.jobUrl("https://seattletimes.com/lobortis/ligula/sit.jpg?ultrices=aliquam&libero=convallis&non=nunc&mattis=proin&pulvinar=at&nulla=turpis&pede=a&ullamcorper=pede&augue=posuere&a=nonummy&suscipit=integer&nulla=non&elit=velit&ac=donec\",\n")
					.build());
			repository.save(JobApplication.builder()
					.userId("f7f11d77-9641-4a6f-a7c0-25ada8494124")
					.companyName("Google")
					.jobTitle("Developer")
					.jobDescription("In congue. Etiam justo. Etiam pretium iaculis justo.\\n\\nIn hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.\\n\\nNulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.\\n\\nCras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.\\n\\nQuisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.\\n\\nPhasellus in felis. Donec semper sapien a libero. Nam dui.\\n\\nProin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.")
					.status("Active")
					.statusDate(new Date())
					.jobUrl("https://seattletimes.com/lobortis/ligula/sit.jpg?ultrices=aliquam&libero=convallis&non=nunc&mattis=proin&pulvinar=at&nulla=turpis&pede=a&ullamcorper=pede&augue=posuere&a=nonummy&suscipit=integer&nulla=non&elit=velit&ac=donec\",\n")
					.build());
			repository.save(JobApplication.builder()
					.userId("f7f11d77-9641-4a6f-a7c0-25ada8494124")
					.companyName("AWS")
					.jobTitle("Frontend")
					.jobDescription("In congue. Etiam justo. Etiam pretium iaculis justo.\\n\\nIn hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.\\n\\nNulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.\\n\\nCras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.\\n\\nQuisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.\\n\\nPhasellus in felis. Donec semper sapien a libero. Nam dui.\\n\\nProin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.")
					.status("Active")
					.statusDate(new Date())
					.jobUrl("https://seattletimes.com/lobortis/ligula/sit.jpg?ultrices=aliquam&libero=convallis&non=nunc&mattis=proin&pulvinar=at&nulla=turpis&pede=a&ullamcorper=pede&augue=posuere&a=nonummy&suscipit=integer&nulla=non&elit=velit&ac=donec\",\n")
					.build());
			repository.save(JobApplication.builder()
					.userId("14984533-933d-410f-bcb8-e479882678ed")
					.companyName("Digiteh")
					.jobTitle("Infrastructure support")
					.jobDescription("In congue. Etiam justo. Etiam pretium iaculis justo.\\n\\nIn hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.\\n\\nNulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.\\n\\nCras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.\\n\\nQuisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.\\n\\nPhasellus in felis. Donec semper sapien a libero. Nam dui.\\n\\nProin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.")
					.status("Active")
					.statusDate(new Date())
					.jobUrl("https://seattletimes.com/lobortis/ligula/sit.jpg?ultrices=aliquam&libero=convallis&non=nunc&mattis=proin&pulvinar=at&nulla=turpis&pede=a&ullamcorper=pede&augue=posuere&a=nonummy&suscipit=integer&nulla=non&elit=velit&ac=donec\",\n")
					.build());
			repository.save(JobApplication.builder()
					.userId("14984533-933d-410f-bcb8-e479882678ed")
					.companyName("Guidewire")
					.jobTitle("Graduate")
					.jobDescription("In congue. Etiam justo. Etiam pretium iaculis justo.\\n\\nIn hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.\\n\\nNulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.\\n\\nCras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.\\n\\nQuisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.\\n\\nPhasellus in felis. Donec semper sapien a libero. Nam dui.\\n\\nProin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.")
					.status("Interview")
					.statusDate(new Date())
					.jobUrl("https://seattletimes.com/lobortis/ligula/sit.jpg?ultrices=aliquam&libero=convallis&non=nunc&mattis=proin&pulvinar=at&nulla=turpis&pede=a&ullamcorper=pede&augue=posuere&a=nonummy&suscipit=integer&nulla=non&elit=velit&ac=donec\",\n")
					.build());
					
	
		}
	}	
}
