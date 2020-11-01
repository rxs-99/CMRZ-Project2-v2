package com.revature.dao;

import com.revature.model.Person;

public interface AuthDAO {

	/*
	 * login - returns the id of the person given a username and
	 * an unencrypted password
	 */
	public Person login(String username, String password);
	
}
