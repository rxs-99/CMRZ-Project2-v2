package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.PersonDAO;
import com.revature.model.Person;
import com.revature.model.Prescription;

@Service("patientService")
public class PersonService {
	private PersonDAO pdao;
	
	@Autowired
	public PersonService(PersonDAO pdao) {
		this.pdao = pdao;
	}
	
	public boolean createRefillRequest(int patientId, int prescriptionId) {
		return pdao.createRefillRequest(patientId, prescriptionId);
	}
	
	public Person getPatientInfo(int patientId) {
		return pdao.getPatientInfo(patientId);
	}
	
	public Prescription getPrescriptionInfo(int prescriptionId) {
		return pdao.getPersciptionInfo(prescriptionId);
	}
	
	public boolean updatePatientInfo(Person newPatient) {
		return pdao.updatePatientInfo(newPatient);
	}
}
