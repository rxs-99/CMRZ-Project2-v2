package com.revature.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.utility.AllowedDomain;
import com.revature.utility.JWTUtil;

import edu.emory.mathcs.backport.java.util.Arrays;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
/*		
		System.out.println("===================================================================");
		int count = 0;
		Enumeration headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
		  String headerName = (String)headerNames.nextElement();
		  System.out.print("" + headerName + ": ");
		  System.out.println("" + request.getHeader(headerName));
		  count++;
		}
		
		System.out.println(count + " <----- ");
*/
		
		if(Arrays.asList(AllowedDomain.ALLOWED_DOMAINS).contains(request.getHeader("origin"))) {
			response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
			response.setHeader("Access-Control-Allow-Headers", request.getHeader("access-control-request-headers"));
		}
		
		try{
			if (JWTUtil.checkJWTToken(request)) {
				Claims claims = JWTUtil.validateToken(request);
				if(claims.get("role") != null){
					return true;
				}
			}
		} catch(UnsupportedJwtException | MalformedJwtException | SignatureException | ExpiredJwtException | IllegalArgumentException e){
			
			try {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
				return false;
			} catch (IOException e1) {
				e1.printStackTrace();
				return false;
			}
		}
		
		try {
			response.getWriter().write("No token! What you doin?");
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
}
