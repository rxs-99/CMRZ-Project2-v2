package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Appointment;
import com.revature.utility.HibernateSessionFactory;

public class AppointmentDAOImpl implements AppointmentDAO {

	/*
	 * add - adds the given appointment to the db. If entry
	 * already exists s throws exception.
	 */
    @Override
    public boolean add(Appointment appointment) {
    	
    	Session s = null;
    	Transaction tx = null;
    	boolean b = true;
    	
    	try {
    		s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
    		
			s.save(appointment);			
			tx.commit();			
    	} catch(HibernateException e) {
    		e.printStackTrace();
    		tx.rollback();
    		b = false;
    	} finally {
    		s.close();
    	}
    	
        return b;
    }

    /*
     * update - updates a given entry in a database. If entry does
     * not already exist, returns false.
     */
    @Override
    public boolean update(Appointment appointment) {
    	
    	Session s = null;
    	Transaction tx = null;
    	boolean b = true;
    	
    	try {
    		s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
    		
			if(s.merge(appointment)==null)
				b = false;
			
			tx.commit();
    	} catch(HibernateException e) {
    		e.printStackTrace();
    		tx.rollback();
    		b = false;
    	} finally {
    		s.close();
    	}
    	
        return b;
    }

    /*
     * getAppointmentByID - returns the appointment with the given ID
     * if one exists. If not, returns null.
     */
    @Override
    public Appointment getAppointmentByID(int id) {
        
    	Session s = null;
    	Transaction tx = null;
    	Appointment a = null;
    	
    	try {
    		s = HibernateSessionFactory.getSession();
    		tx = s.beginTransaction();
    		
    		a = s.get(Appointment.class, id);
    		
    		tx.commit();
    		
    	} catch(HibernateException e) {
    		e.printStackTrace();
    		tx.rollback();
    	} finally {
    		s.close();
    	}
    	
        return a;
        
    }

    @Override
    public List<Appointment> getAppointmentByStatus(String status) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Appointment> getAll() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
