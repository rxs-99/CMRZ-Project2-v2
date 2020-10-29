package com.revature.dao;

import com.revature.model.Person;
import com.revature.model.Prescription;

public interface PersonDAO {
	public boolean createRefillRequest(int patientId, int perscriptionId);
	public Person getPatientInfo(int patientId);
	public Prescription getPersciptionInfo(int prescriptionId);
	public boolean updatePatientInfo(Person patient);
}
