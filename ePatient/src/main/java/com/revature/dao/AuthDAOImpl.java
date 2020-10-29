package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.LoginEntry;
import com.revature.utility.Encryptor;
import com.revature.utility.HibernateSessionFactory;

public class AuthDAOImpl implements AuthDAO {

	/*
	 * login - returns the id of the person given a username and
	 * an unencrypted password
	 */
	@Override
	public int login(String username, String password) {
		
		Session s = null;
		Transaction tx = null;
		int id = -1;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			LoginEntry user = s.get(LoginEntry.class, username);
			
			if(user!=null && user.getPassword().equals(Encryptor.encrypt(password)))
				id = user.getPerson().getId();
			tx.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
		return id;
	}

}
