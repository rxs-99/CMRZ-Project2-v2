package com.revature.dao;

import java.util.List;

import com.revature.model.Prescription;

public interface PrescriptionDAO 
{
	boolean add(Prescription p);
	boolean update(Prescription p);
	boolean delete(Prescription p);
	List<Prescription> getAll();
}
