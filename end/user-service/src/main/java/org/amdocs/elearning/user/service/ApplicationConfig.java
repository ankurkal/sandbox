package org.amdocs.elearning.user.service;

import org.amdocs.elearning.user.service.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public UserService getUserService() {
		return new UserService();
	}
}
