package com.cloud.FleetsApps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class FleetsAppsApplication {
	
	
	//This is use for Auditor
	@Bean
	public AuditorAware<String> auditorAware()
	{
		return new SpringSecurityAuditorAware();
	}
	
	//This is use for Auditor

	public static void main(String[] args) {
		SpringApplication.run(FleetsAppsApplication.class, args);
	}

}
