package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.model.LoginEntry;
import com.revature.model.Person;
import com.revature.utility.Encryptor;
import com.revature.utility.HibernateSessionFactory;

@Repository("authDAO")
public class AuthDAOImpl implements AuthDAO {

	/*
	 * see com.revature.dao.AuthDAO
	 */
	@Override
	public Person login(String username, String password) {
		
		Session s = null;
		Transaction tx = null;
		Person p = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			LoginEntry user = s.get(LoginEntry.class, username);
			
			if(user!=null && user.getPassword().equals(Encryptor.encrypt(password)))
				p = user.getPerson();
			tx.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
		return p;
	}

}
