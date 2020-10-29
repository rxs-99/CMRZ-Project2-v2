package com.revature.dao;

import java.util.List;

import com.revature.model.Appointment;

public interface AppointmentDAO {
    public boolean add(Appointment appointment);
    public boolean update(Appointment appointment);
    public Appointment getAppointmentByID(int id);
    public List<Appointment> getAppointmentByStatus(String status);
    public List<Appointment> getAll();
}
