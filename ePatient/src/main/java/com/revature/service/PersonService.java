package com.revature.service;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.RegexValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.PersonDAO;
import com.revature.model.Person;

@Service("patientService")
public class PersonService {
	private PersonDAO pdao;
	
	@Autowired
	public PersonService(PersonDAO pdao) {
		this.pdao = pdao;
	}
	
	public boolean isPatient(int personId) {
		return pdao.isPatient(personId);
	}
	
	public boolean isNurse(int personId) {
		return pdao.isNurse(personId);
	}
	
	public boolean isDoctor(int personId) {
		return pdao.isDoctor(personId);
	}
	
	public boolean createPerson(Person p) {
		if(isPersonValid(p)) {
			return pdao.createPerson(p);
		} else {
			return false;
		}	
	}
	
	public Person getPersonInfo(int personId) {
		return pdao.getPersonInfo(personId);
	}
	
	public boolean updatePersonInfo(Person updatedPerson) {
		if(isPersonValid(updatedPerson)) {
			return pdao.updatePersonInfo(updatedPerson);
		} else {
			return false;
		}	
	}
	
	/**
	 * Validates a Person object, making sure the data within is formatted properly.
	 * Regex created by Don Johnston.
	 * https://regexlib.com/REDetails.aspx?regexp_id=607
	 * @param p The Person object to validate.
	 * @return True if the Person object is valid, false otherwise.
	 */
	private boolean isPersonValid(Person p) {
		EmailValidator ev = EmailValidator.getInstance();
		RegexValidator USPhoneValidator = new RegexValidator("^(?:\\([2-9]\\d{2}\\)\\ ?|[2-9]\\d{2}(?:\\-?|\\ ?))[2-9]\\d{2}[- ]?\\d{4}$");
		
		if(p.getName() != null && ev.isValid(p.getEmail()) && USPhoneValidator.isValid(p.getPhone())) {
			return true;
		} else {
			return false;
		}
	}
}
