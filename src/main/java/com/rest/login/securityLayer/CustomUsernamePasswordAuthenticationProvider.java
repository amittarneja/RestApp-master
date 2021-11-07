package com.rest.login.securityLayer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
/**
 * Created by Amit on 2021/11/7
 * To perform header based Basic authentication.
 * Commence method is overridden to return status 401 and authentication schema as basic authentication 
 */
@Component
public class CustomUsernamePasswordAuthenticationProvider extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authenticationEx) throws IOException, ServletException {
		response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		writer.println("HTTP Status 401 unauthorized - " + authenticationEx.getMessage());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("amit");
		super.afterPropertiesSet();
	}

}