package com.revature.dao;

import com.revature.model.Person;

public interface PersonDAO {
	
	/**
	 * Checks if a person is a patient.
	 * @param personId The id of the person to check.
	 * @return True if the person is a patient, false if not. This method also returns false in case of Hibernate/DB errors.
	 */
	public boolean isPatient(int personId);
	
	/**
	 * Checks if a person is a nurse.
	 * @param personId The id of the person to check.
	 * @return True if the person is a nurse, false if not. This method also returns false in case of Hibernate/DB errors.
	 */
	public boolean isNurse(int personId);
	
	/**
	 * Checks if a person is a doctor.
	 * @param personId The id of the person to check.
	 * @return True if the person is a doctor, false if not. This method also returns false in case of Hibernate/DB errors.
	 */
	public boolean isDoctor(int personId);
	
	/**
	 * Adds a person to the database.
	 * @param p The person to add to the database.
	 * @return True if the person was successfully added, false otherwise.
	 */
	public boolean createPerson(Person p);
	
	/**
	 * Searches for and returns a person, if one exists.
	 * @param personId The id of the person to search for.
	 * @return The person with the personId, or null if none was found/the DB encountered an error.
	 */
	public Person getPersonInfo(int personId);
	
	/**
	 * Updates a person with new information in the database.
	 * @param p The new details of the person.
	 * @return True if the person was successfully updated, false otherwise.
	 */
	public boolean updatePersonInfo(Person p);
}
