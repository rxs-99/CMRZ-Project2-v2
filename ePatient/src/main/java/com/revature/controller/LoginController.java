package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

import com.revature.model.LoginEntry;
import com.revature.model.Person;
import com.revature.model.User;
import com.revature.service.LoginService;
import com.revature.utility.JWTUtil;

@RestController("loginController")
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

	private LoginService loginService;

	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public User login(HttpSession session, @RequestBody LoginEntry l) {
		System.out.println(l.getUsername());

		Person p = this.loginService.login(l.getUsername(), l.getPassword());


		User user = new User();

		if(p != null){
			user.setPerson(p);
			user.setToken(JWTUtil.getJWTToken(l.getUsername(), p));
		}		

		return user;
	}

}
