package com.gov.nha.bis.goldenApi.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@EntityScan( basePackages = {"com.gov.nha.*"})
@ComponentScan(basePackages = {"com.gov.nha.*"})
@EnableJpaRepositories("com.gov.nha.")
@SpringBootApplication(scanBasePackages="com.gov.nha.*", exclude = { SecurityAutoConfiguration.class })
public class SchedulerRApplication {

	private static final Logger LOGGER = LogManager.getLogger(SchedulerRApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SchedulerRApplication.class, args);
		LOGGER.info("schedulerR Application Service Started");
	}	
}
