package com.revature.dao;

import com.revature.model.Person;

public interface PersonDAO {
	public boolean isPatient(int personId);
	public boolean isNurse(int personId);
	public boolean isDoctor(int personId);
	
	public boolean createPerson(Person p);
	public Person getPatientInfo(int patientId);
	public boolean updatePatientInfo(Person patient);
}
