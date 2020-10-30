package com.revature.utility;

import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

//import org.junit.Assert;

public class HibernateSessionFactoryTest {

    @Test
    public void testSession(){
        Session s = HibernateSessionFactory.getSession();

        assertNotNull(s);
    }
}
