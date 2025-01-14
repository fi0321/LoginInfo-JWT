package com.LoginInfo.LoginInfo;

import com.LoginInfo.LoginInfo.role.Role;
import com.LoginInfo.LoginInfo.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class LoginInfoApplication {

  public static void main(String[] args) {
    SpringApplication.run(LoginInfoApplication.class, args);


  }

  @Bean
  public CommandLineRunner runner(RoleRepository roleRepository)
  {
    return args -> {
      if(roleRepository.findByName("USER").isEmpty())
      {
        roleRepository.save(
                Role.builder().name("USER").build()
        );
      }
    };
  }
}
