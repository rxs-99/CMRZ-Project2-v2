package com.revature.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.LoginEntry;
import com.revature.model.Person;
import com.revature.service.LoginService;

@RestController("loginController")
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	private LoginService loginService;
	
	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Person login(@RequestBody LoginEntry l) {
		System.out.println(l.getUsername());
		return this.loginService.login(l.getUsername(), l.getPassword());
	}
	
}
