package com.revature.service;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.dao.MedicationDAO;
import com.revature.dao.MedicationDAOImpl;
import com.revature.model.Medication;

public class MedicationService 
{
	MedicationDAO md = new MedicationDAOImpl();
	
	public List<Medication> getAll()
	{
		return md.getAll();
	}
	
	/**Returns All Medications that are currently stored
	 * @return Returns a list of all medications that have an amount stored > 0.
	 */
	public List<Medication> getAllAvailableMedications()
	{
		return getAll().stream().filter(a -> a.getAmountStored() > 0).collect(Collectors.toList());
	}
	
	public void add(Medication m)
	{
		md.add(m);
	}
	
	public void update(Medication m)
	{
		md.update(m);
	}
	
	public void delete(Medication m)
	{
		md.delete(m);
	}
}
