package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "prescription")
public class Prescription {
    @Id
    @Column(name = "prescriptionid")
    @GeneratedValue(generator = "prescription_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(allocationSize = 1, name = "prescription_id_seq", sequenceName = "prescription_id_seq")
    private int id;

    @ManyToOne
    @JoinColumn(name = "medicationid", nullable = false)
    private Medication medication;

    @ManyToOne
    @JoinColumn(name = "prescribedto", nullable = false)
    private Person patient;

    @ManyToOne
    @JoinColumn(name = "prescribedby", nullable = false)
    private Person doctor;

    @Column(nullable = false)
    private double dosage;

    public Prescription(){
        
    }

    public Prescription(int id, Medication medication, Person patient, Person doctor, double dosage) {
        this.id = id;
        this.medication = medication;
        this.patient = patient;
        this.doctor = doctor;
        this.dosage = dosage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Person getPatient() {
        return patient;
    }

    public void setPatient(Person patient) {
        this.patient = patient;
    }

    public Person getDoctor() {
        return doctor;
    }

    public void setDoctor(Person doctor) {
        this.doctor = doctor;
    }

    public double getDosage() {
        return dosage;
    }

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "Prescription [doctor=" + doctor + ", dosage=" + dosage + ", id=" + id + ", medication=" + medication
                + ", patient=" + patient + "]";
    }

}