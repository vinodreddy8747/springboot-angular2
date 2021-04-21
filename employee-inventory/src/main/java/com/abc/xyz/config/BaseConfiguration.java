package com.abc.xyz.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableBatchProcessing
@EnableSwagger2
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
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
		
}
