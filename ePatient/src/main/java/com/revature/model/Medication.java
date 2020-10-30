package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "medication")
public class Medication
{
    @Id
    @Column(name = "medicationid")
    @GeneratedValue(generator = "medication_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(allocationSize = 1, name = "medication_id_seq", sequenceName = "medication_id_seq")
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String supplier;

    @Column(nullable = false)
    private int amountStored;
    
    public Medication()
    {
    	
    }
    
    public Medication(int id, String name, String supplier, int amt_stored)
    {
		this.id = id;
		this.name = name;
		this.supplier = supplier;
		this.amountStored = amt_stored;
    }
    
    public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public void setAmountStored(int amountStored) {
		this.amountStored = amountStored;
	}

	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSupplier() {
		return supplier;
	}

	public int getAmountStored() {
		return amountStored;
	}
    
    
}
