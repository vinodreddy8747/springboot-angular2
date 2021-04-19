package com.abc.xyz.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableBatchProcessing
public class BaseConfiguration {

	@Primary
	@Bean("dataSource")
	public DataSource dataSource(@Value("${spring.datasource.driver-class-name}") String driverName,
			@Value("${spring.datasource.url}") String url, @Value("${spring.datasource.username}") String userName,
			@Value("${spring.datasource.password}") String password) {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverName);
		config.setAutoCommit(false);
		config.setIdleTimeout(600000);
		config.setConnectionTimeout(30000);
		config.setMaximumPoolSize(200);
		config.setJdbcUrl(url);
		config.setUsername(userName);
		config.setPassword(password);
		return new HikariDataSource(config);
	}

}
