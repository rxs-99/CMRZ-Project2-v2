package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.model.Medication;
import com.revature.model.Prescription;
import com.revature.utility.HibernateSessionFactory;

@Repository("prescriptionRepository")
public class PrescriptionDAOImpl implements PrescriptionDAO 
{

	@Override
	public boolean add(Prescription p) 
	{
		Session s = null; 

		Transaction t = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			t = s.beginTransaction();
			
			s.save(p);
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
	public boolean update(Prescription p) 
	{
		Session s = null; 

		Transaction t = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			t = s.beginTransaction();
			
			s.update(p);
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
	public boolean delete(Prescription p) 
	{
		Session s = null; 

		Transaction t = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			t = s.beginTransaction();
			
			s.delete(p);
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
	public List<Prescription> getAll() 
	{
		Session s = null; 
				
		List<Prescription> prescriptions = new ArrayList<Prescription>();
		
		Transaction t = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			t = s.beginTransaction();
			
			prescriptions = s.createQuery("FROM Prescription", Prescription.class).getResultList();
			
			t.commit();
			
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}

		return prescriptions;
	}


}
