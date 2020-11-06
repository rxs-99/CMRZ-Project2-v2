package com.revature.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.utility.JWTUtil;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		System.out.println("inside preHandle interceptor");

		try{
			if (JWTUtil.checkJWTToken(request)) {
				Claims claims = JWTUtil.validateToken(request);
				if(claims.get("role") != null){
					return true;
				}
			}
		} catch(UnsupportedJwtException | MalformedJwtException | SignatureException | ExpiredJwtException | IllegalArgumentException e){
			try {
				response.getWriter()
						.write("One of the many thing that could have gone wrong went wrong. Unlucky. Try again!");
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
