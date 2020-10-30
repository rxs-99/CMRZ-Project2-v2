package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.AuthDAO;
import com.revature.dao.AuthDAOImpl;

@Service("loginService")
public class LoginService {

	private AuthDAO authDAO;
		
	@Autowired
	public void setAuthDAO(AuthDAO authDAO) {
		this.authDAO = authDAO;
	}

	/*
	 * see com.revature.dao.AuthDAOImpl
	 */
	public int login(String username, String password) {
		authDAO = new AuthDAOImpl();
		return authDAO.login(username, password);
	}
	
}
