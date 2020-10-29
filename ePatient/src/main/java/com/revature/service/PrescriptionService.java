package com.revature.service;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.dao.PrescriptionDAO;
import com.revature.dao.PrescriptionDAOImpl;
import com.revature.model.Medication;
import com.revature.model.Person;
import com.revature.model.Prescription;

public class PrescriptionService
{
	// reference to Prescription DAO
	PrescriptionDAO pd = new PrescriptionDAOImpl();
	
	/**Returns All Prescriptions from the database*/
	public List<Prescription> getAll()
	{
		return pd.getAll();
	}
	
	/**Returns All Prescriptions prescribed by a certain doctor
	 * @param doc The doctor instance
	 * @return Returns a list of all prescriptions made by a certain doctor
	 */
	public List<Prescription> getPrescriptionsByDoctor(Person doc)
	{
		return getAll().stream().filter(a -> a.getDoctor().getId() == doc.getId()).collect(Collectors.toList());
	}
	
	/**Returns All Prescriptions prescribed to a certain patient
	 * @param patient The patient instance
	 * @return Returns a list containing all prescriptions made to a certain patient
	*/
	public List<Prescription> getPrescriptionsByPatient(Person patient)
	{
		return getAll().stream().filter(a -> a.getPatient().getId() == patient.getId()).collect(Collectors.toList());
	}
	
	/**Returns All Prescriptions that use a certain medication from the database
	 * @param medication instance of the medication
	 * @return Returns a list of all prescriptions that use the passed medication
	*/
	public List<Prescription> getPrescriptionsByMedication(Medication medication)
	{
		return getAll().stream().filter(a -> a.getMedication().getId() == medication.getId()).collect(Collectors.toList());
	}
	
	public void add(Prescription m)
	{
		pd.add(m);
	}
	
	public void update(Prescription m)
	{
		pd.update(m);
	}
	
	public void delete(Prescription m)
	{
		pd.delete(m);
	}
}
