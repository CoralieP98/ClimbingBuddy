package com.CoralieP98.Climb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@RefreshScope
//@ComponentScans({@ComponentScan("com.CoralieP98.user.Controller")})
@EnableJpaRepositories("com.CoralieP98.patient.Repository")
@EntityScan("com.CoralieP98.patient.Model")
public class ClimbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClimbApplication.class, args);
	}

}
