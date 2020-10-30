package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.service.LoginService;

@Controller("loginController")
@RequestMapping("/login")
public class LoginController {

	private LoginService loginService;
	
	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping(value = "/*", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public int login() {
		return loginService.login("colbyat","password");		
	}
	
}
