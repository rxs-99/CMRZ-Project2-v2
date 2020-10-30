package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.model.Medication;
import com.revature.utility.HibernateSessionFactory;

@Repository(value = "medicationRepository")
public class MedicationDAOImpl implements MedicationDAO
{

	@Override
	public boolean add(Medication m) 
	{
		Session s = null; 

		Transaction t = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			t = s.beginTransaction();
			
			s.save(m);
			t.commit();		
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		
		return false;
	}

	@Override
	public boolean update(Medication m) 
	{
		Session s = null; 

		Transaction t = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			t = s.beginTransaction();
			
			s.update(m);
			t.commit();		
			return true;
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		
		return false;
	}

	@Override
	public boolean delete(Medication m) 
	{
		Session s = null; 

		Transaction t = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			t = s.beginTransaction();
			
			s.delete(m);
			t.commit();		
			return true;
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		
		return false;
	}

	@Override
	public List<Medication> getAll() 
	{
		Session s = null; 
				
		List<Medication> medications = new ArrayList<Medication>();
		
		Transaction t = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			t = s.beginTransaction();
			
			medications = s.createQuery("FROM Medication", Medication.class).getResultList();
			
			t.commit();
			
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}

		return medications;
	}

}
