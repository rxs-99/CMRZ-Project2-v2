package com.revature.service;

import java.sql.Date;
import java.util.Arrays;

import com.revature.dao.AppointmentDAO;
import com.revature.dao.AppointmentDAOImpl;
import com.revature.model.Appointment;
import com.revature.model.Person;
import com.revature.model.Position;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AppointmentServiceTest {
    @InjectMocks
    private static AppointmentService appointmentService;

    @Mock
    private AppointmentDAO appointmentDAO;

    @BeforeClass
    public static void beforeClass() {
        appointmentService = new AppointmentService();
    }

    @Before
    public void BeforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAdd(){
        Appointment a = new Appointment(1, new Person(), new Person(), new Date(2135465), "lol", "help");
        Mockito.when(this.appointmentDAO.add(a)).thenReturn(true);

        Assert.assertTrue(appointmentService.add(a));
    }

    @Test
    public void testGetAppointmentByStatus() {
        Mockito.when(this.appointmentDAO.getAppointmentByStatus("pending"))
                .thenReturn(Arrays.asList(new Appointment(), new Appointment()));

        Assert.assertEquals(2, appointmentService.getAppointmentByStatus("pending").size());
    }

    @Test
    public void testUpdate(){
        Appointment a = new Appointment(new Person(1,"Colby","0000000000","colbyat@email.arizona.edu",new Position(1,"patient")), new Person(2,"Rabinson","5624896573","a@b.c",new Position(1,"patient")), Date.valueOf("2021-10-10"), "");
/*
        new AppointmentDAOImpl().add(a);
        System.out.println(a.toString());
*/
        Mockito.when(this.appointmentDAO.update(a)).thenReturn(false);

        Assert.assertFalse(appointmentService.update(a));
    }

    @Test
    public void testGetAppointmentByID(){
        Mockito.when(this.appointmentDAO.getAppointmentByID(2))
                .thenReturn(new Appointment(2, new Person(), new Person(), Date.valueOf("2020-12-12"), "", ""));

        Assert.assertEquals(2, appointmentService.getAppointmentByID(2).getId());
        Assert.assertNull(appointmentService.getAppointmentByID(3));
    }

    @Test
    public void testGetAll(){
        Mockito.when(this.appointmentDAO.getAll()).thenReturn(Arrays.asList(new Appointment(), new Appointment(), new Appointment()));

        Assert.assertEquals(3, appointmentService.getAll().size());
    }

}
