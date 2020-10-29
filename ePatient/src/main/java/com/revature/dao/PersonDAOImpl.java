package com.revature.dao;

import org.springframework.stereotype.Repository;

import com.revature.model.Person;
import com.revature.model.Prescription;

@Repository("PatientDAOImpl")
public class PersonDAOImpl implements PersonDAO {

	@Override
	public boolean createRefillRequest(int patientId, int perscriptionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Person getPatientInfo(int patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prescription getPersciptionInfo(int prescriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePatientInfo(Person patient) {
		// TODO Auto-generated method stub
		return false;
	}

}
