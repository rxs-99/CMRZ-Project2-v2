package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Appointment;
import com.revature.utility.HibernateSessionFactory;

@Repository(value = "appointmentRepository")
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
			
			/*
			if(s.merge(appointment)==null)
				b = false;
			*/
			// commented out the merge statement because we don't want to create a new record on update if there is no record
			s.update(appointment);

			tx.commit();
    	} catch(Exception e) {
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
		Session s = null;
		Transaction tx = null;
		List<Appointment> appointments = new ArrayList<Appointment>();

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();

			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Appointment> cq = cb.createQuery(Appointment.class);
			Root<Appointment> root = cq.from(Appointment.class);
			cq.select(root).where(cb.equal(root.get("status"), status));
			Query<Appointment> q = s.createQuery(cq);

			appointments = q.getResultList();
			tx.commit();
		} catch (HibernateException e){
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}

        return appointments;
    }

    @Override
    public List<Appointment> getAll() {
        Session s = null;
		Transaction tx = null;
		List<Appointment> appointments = new ArrayList<Appointment>();

		try{
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();

			appointments = s.createQuery("FROM Appointment", Appointment.class).getResultList();

			tx.commit();
		} catch (HibernateException e){
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}

		return appointments;
    }
    
}
