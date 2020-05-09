package com.jobseekerorganizer.jobapplicationms.jwt.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.jobseekerorganizer.jobapplicationms.jwt.TokenAuthenticationService;

public class JWTAuthenticationFilter extends GenericFilterBean {
	
	
	private TokenAuthenticationService service;
	
	public JWTAuthenticationFilter(TokenAuthenticationService service) {
        this.service = service;
    }
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		Authentication authentication = service.getAuthentication((HttpServletRequest) request); 
		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request, response);
	}

}
