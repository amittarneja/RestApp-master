package com.rest.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *     Main application must extend SpringBootServletInitializer for applications
 *     are deployed as war artifacts in Tomcat containers.
 * </p>
 * <p>
 *     If you are fortunate enough to use Spring Boot as a drop-in container in your DevOps, then
 *     you can remove the {@link SpringBootServletInitializer}.
 * </p>
 */

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@Configuration
public class RestApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RestApp.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RestApp.class);
	}
}