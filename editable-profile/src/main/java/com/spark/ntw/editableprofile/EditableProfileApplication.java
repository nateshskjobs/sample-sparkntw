package com.spark.ntw.editableprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages= {"com.spark.ntw.editableprofile.repository"})
@EntityScan
public class EditableProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(EditableProfileApplication.class, args);
	}
}
