package com.jobseekerorganizer.jobapplicationms.jwt;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.Sha512DigestUtils;

import com.jobseekerorganizer.jobapplicationms.domain.AuthenticationTokenImpl;
import com.jobseekerorganizer.jobapplicationms.domain.SessionUser;
import com.jobseekerorganizer.jobapplicationms.services.RedisService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class TokenAuthenticationService {
	
	@Autowired
	private RedisService service;
	
	private long EXPIRATIONTIME = 1000 * 60 * 60; // 1hr
	private String secret;
	private String tokenPrefix = "Bearer";
	private String headerString = "Authorization";

	public TokenAuthenticationService(String key) {
		this.secret = Sha512DigestUtils.shaHex(key);
	}

	public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(headerString);
		if (token == null) {
			return null;
		}

		// remove "Bearer" text
		token = token.replace(tokenPrefix, "").trim();
		// validating token
		if (token != null && !token.isEmpty()) {
			Claims claims = null;
			try {
				claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			} catch (Exception e) {
				return null;
			}

			// valid token and check if token is actually expired or alive by quering redis
			if (claims != null && claims.containsKey("userId")) {
				String userId = claims.get("userId").toString();
				String hash = claims.get("hash").toString();
				SessionUser user = (SessionUser) service.getValue(String.format("%s:%s", userId, hash),
						SessionUser.class);
				if (user != null) {
					AuthenticationTokenImpl auth = new AuthenticationTokenImpl(user.getUserId(),
							Collections.emptyList());
					auth.setDetails(user);
					auth.authenticate();
					return auth;
				} else {
					return new UsernamePasswordAuthenticationToken(null, null);
				}
			}
		}

		return null;

	}

}
