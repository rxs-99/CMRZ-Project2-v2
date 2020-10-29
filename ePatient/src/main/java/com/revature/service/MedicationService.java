package com.revature.service;

import java.util.List;

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
