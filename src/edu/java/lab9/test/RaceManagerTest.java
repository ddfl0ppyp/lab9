package edu.java.lab9.test;

import org.junit.Test;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.junit.Assert;
import org.junit.Before;

import edu.java.lab9.*;
import edu.java.lab9.RaceManager.*;

public class RaceManagerTest {
    private RaceManager app;
    private DefaultTableModel model;

    @Before
    public void setup()
    {
        app = new RaceManager();
        model = new DefaultTableModel(new String[]{"Red Bull Racing","Макс Ферстаппен","Спа-Франкоршам","28-08-2022 15:00","1","25"}, 0);
        app.model = model;
    }

    @Test
    public void testValidcheckName() 
    {
        JTextField find = new JTextField("Имя");
        Exception exception = null;

        try {
            app.checkName(find);
        } catch (NoNameException | NullPointerException e) {
            exception = e;
        }

        Assert.assertNull(exception);
    }

    @Test
    public void testInvalidcheckName() 
    {
        JTextField find = new JTextField("Имя пилота");
        Exception exception = null;

        try {
            app.checkName(find);
        } catch (NoNameException | NullPointerException e) {
            exception = e;
        }

        Assert.assertNotNull(exception);
    }
}
