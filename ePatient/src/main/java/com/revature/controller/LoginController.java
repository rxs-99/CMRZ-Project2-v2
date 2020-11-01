package com.revature.controller; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Person;
import com.revature.service.LoginService;

@RestController("loginController")
@RequestMapping("/login")
public class LoginController {

	private LoginService loginService;
	
	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Person login(HttpServletRequest request, HttpServletResponse response) {
		return this.loginService.login(request.getParameter("username"), request.getParameter("password"));
	}
	
}
