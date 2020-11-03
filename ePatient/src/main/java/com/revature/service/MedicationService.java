package com.revature.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.MedicationDAO;
import com.revature.dao.MedicationDAOImpl;
import com.revature.model.Medication;

@Service("medicationService")
public class MedicationService 
{
	MedicationDAO md;
	
	@Autowired
    public void setAppointmentService(MedicationDAOImpl medicationDAO) 
	{
        this.md = medicationDAO;
    }
	
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
	
	public boolean update(Medication m)
	{
		return md.update(m);
	}
	
	public void delete(Medication m)
	{
		md.delete(m);
	}

	public Medication getMedicationById(int id) 
	{
		for(Medication m : getAll())
			if(m.getId() == id)
				return m;
		
		return null;
	}
}
