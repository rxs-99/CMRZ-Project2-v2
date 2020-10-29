package com.revature.service;

import java.util.List;

import com.revature.dao.PrescriptionDAO;
import com.revature.dao.PrescriptionDAOImpl;
import com.revature.model.Prescription;

public class PrescriptionService
{
	PrescriptionDAO pd = new PrescriptionDAOImpl();
	
	public List<Prescription> getAll()
	{
		return pd.getAll();
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
