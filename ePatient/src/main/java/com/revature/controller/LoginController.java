package com.revature.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.PersonDAO;
import com.revature.dao.PersonDAOImpl;
import com.revature.service.LoginService;

@RestController("loginController")
@RequestMapping("/login")
public class LoginController {

	private LoginService loginService;
	
	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping(value = "*")
	public String login() {
		int p = loginService.login("colbyat","password");
		
		if(p==-1)
			return "index";
		
		PersonDAO pdao = new PersonDAOImpl();
		
		if(pdao.isDoctor(p))
			return "doctor";
		else if(pdao.isNurse(p))
			return "nurse";
		else
			return "patient";

	}
	
}
