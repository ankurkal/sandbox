package org.amdocs.elearning.user.middle;

import org.amdocs.elearning.user.middle.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserService getUserService(){
        return new UserService();
    }
}
