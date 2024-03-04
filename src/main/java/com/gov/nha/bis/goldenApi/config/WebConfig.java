package com.gov.nha.bis.goldenApi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class WebConfig {

	//haryana
	@Bean(name = "db1")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "jdbcTemplateHaryana")
	public JdbcTemplate jdbcTemplate1(@Qualifier("db1") DataSource ds) {
		return new JdbcTemplate(ds);
	}	
}