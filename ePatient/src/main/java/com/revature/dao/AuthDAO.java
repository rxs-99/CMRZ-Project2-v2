package com.revature.dao;

public interface AuthDAO {

	/*
	 * login - returns the id of the person given a username and
	 * an unencrypted password
	 */
	public int login(String username, String password);
	
}
