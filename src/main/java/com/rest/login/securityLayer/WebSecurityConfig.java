package com.rest.login.securityLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Amit on 2021/11/7
 * When the HTTP header request for authentication is received then the user is authenticated
 * and if an unauthenticated request is received, the it is handled by the customUsernamePasswordAuthenticationProvider
 * and HTTP status code 401 is sent back.
 */

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUsernamePasswordAuthenticationProvider customUsernamePasswordAuthenticationProvider;

	@Value("${spring.security.user.name}")
	private String springSecurityUserName;

	@Value("${spring.security.user.password}")
	private String springSecurityUserPassword;

	@Value("${spring.security.user.roles}")
	private String springSecurityUserRoles;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic()
				.authenticationEntryPoint(customUsernamePasswordAuthenticationProvider);
		;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		String encrytedPassword = this.passwordEncoder().encode(springSecurityUserPassword);
		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> memoryAuthentication = auth
				.inMemoryAuthentication();
		UserDetails userDetails = User.withUsername(springSecurityUserName).password(encrytedPassword)
				.roles("springSecurityUserRoles").build();
		memoryAuthentication.withUser(userDetails);
	}

}