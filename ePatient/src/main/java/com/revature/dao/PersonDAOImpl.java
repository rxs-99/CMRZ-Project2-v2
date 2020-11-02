package com.revature.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Person;
import com.revature.utility.HibernateSessionFactory;

@Repository("PatientDAOImpl")
public class PersonDAOImpl implements PersonDAO {
	
	@Override
	public boolean isPatient(int personId) {
		Session sess = HibernateSessionFactory.getSession();
		Transaction tx = sess.beginTransaction();
		
		try {
			CriteriaBuilder cb = sess.getCriteriaBuilder();
			CriteriaQuery<Person> cq = cb.createQuery(Person.class);
			Root<Person> root = cq.from(Person.class);
			
			cq.select(root);
			cq.where(cb.equal(root.get("id"), personId));
			Query<Person> q = sess.createQuery(cq);
			
			Person p = q.getSingleResult();
			tx.commit();
			return p.getPosition().getName().equals("patient");
		} catch(HibernateException he) {
			tx.rollback();
			return false;
		} finally {
			sess.close();
		}
	}

	@Override
	public boolean isNurse(int personId) {
		Session sess = HibernateSessionFactory.getSession();
		Transaction tx = sess.beginTransaction();
		
		try {
			CriteriaBuilder cb = sess.getCriteriaBuilder();
			CriteriaQuery<Person> cq = cb.createQuery(Person.class);
			Root<Person> root = cq.from(Person.class);
			
			cq.select(root);
			cq.where(cb.equal(root.get("id"), personId));
			Query<Person> q = sess.createQuery(cq);
			
			Person p = q.getSingleResult();
			tx.commit();
			return p.getPosition().getName().equals("nurse");
		} catch(HibernateException he) {
			tx.rollback();
			return false;
		} finally {
			sess.close();
		}
	}

	@Override
	public boolean isDoctor(int personId) {
		Session sess = HibernateSessionFactory.getSession();
		Transaction tx = sess.beginTransaction();
		
		try {
			CriteriaBuilder cb = sess.getCriteriaBuilder();
			CriteriaQuery<Person> cq = cb.createQuery(Person.class);
			Root<Person> root = cq.from(Person.class);
			
			cq.select(root);
			cq.where(cb.equal(root.get("id"), personId));
			Query<Person> q = sess.createQuery(cq);
			
			Person p = q.getSingleResult();
			tx.commit();
			return p.getPosition().getName().equals("doctor");
		} catch(HibernateException he) {
			tx.rollback();
			return false;
		} finally {
			sess.close();
		}
	}
	
	@Override
	public boolean createPerson(Person p) {
		Session sess = HibernateSessionFactory.getSession();
		Transaction tx = sess.beginTransaction();
		
		try {
			sess.save(p);
			tx.commit();
			return true;
		} catch(HibernateException he) {
			tx.rollback();
			return false;
		} finally {
			sess.close();
		}
	}

	@Override
	public Person getPersonInfo(int personId) {
		Session sess = HibernateSessionFactory.getSession();
		Transaction tx = sess.beginTransaction();
		
		try {
			CriteriaBuilder cb = sess.getCriteriaBuilder();
			CriteriaQuery<Person> cq = cb.createQuery(Person.class);
			Root<Person> root = cq.from(Person.class);
			
			cq.select(root);
			cq.where(cb.equal(root.get("id"), personId));
			Query<Person> q = sess.createQuery(cq);
			
			Person p = q.getSingleResult();
			tx.commit();
			return p;
		} catch(HibernateException he) {
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
	}

	/**
	 * Note: updatedPerson MUST be detached.
	 * This will fail if updatedPerson is transient!
	 */
	@Override
	public boolean updatePersonInfo(Person updatedPerson) {
		Session sess = HibernateSessionFactory.getSession();
		Transaction tx = sess.beginTransaction();
		
		try {
			sess.update(updatedPerson);
			tx.commit();
			return true;
		} catch(HibernateException he) {
			tx.rollback();
			return false;
		} finally {
			sess.close();
		}
	}
}
