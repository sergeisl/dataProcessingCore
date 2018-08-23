/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.core.dataProvide;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.sfedu.core.model.ExampleExperiment;
import ru.sfedu.core.model.Experiment;
import ru.sfedu.core.model.Info;
import ru.sfedu.core.model.Users;

/**
 *
 * @author sergei
 */
public class DataProviderTest {
    
    public DataProviderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addExperiment method, of class DataProvider.
     */
    @Test
    public void testAddExperiment() {
        System.out.println("addExperiment");
        Experiment experiment = null;
        DataProvider instance = new DataProvider();
        String expResult = "";
        String result = instance.addExperiment(experiment);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExperimentById method, of class DataProvider.
     */
    @Test
    public void testGetExperimentById() {
        System.out.println("getExperimentById");
        Long id = null;
        DataProvider instance = new DataProvider();
        Experiment expResult = null;
        Experiment result = instance.getExperimentById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExperimentAll method, of class DataProvider.
     */
    @Test
    public void testGetExperimentAll() {
        System.out.println("getExperimentAll");
        DataProvider instance = new DataProvider();
        List<ExampleExperiment> expResult = null;
        List<ExampleExperiment> result = instance.getExperimentAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStrategySecond method, of class DataProvider.
     */
    @Test
    public void testGetStrategySecond() {
        System.out.println("getStrategySecond");
        Long id = null;
        DataProvider instance = new DataProvider();
        Info expResult = null;
        Info result = instance.getStrategySecond(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserById method, of class DataProvider.
     */
    @Test
    public void testGetUserById() {
        System.out.println("getUserById");
        long id = 0L;
        DataProvider instance = new DataProvider();
        Users expResult = null;
        Users result = instance.getUserById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class DataProvider.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        DataProvider instance = new DataProvider();
        List<Users> expResult = null;
        List<Users> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class DataProvider.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        Users user = null;
        DataProvider instance = new DataProvider();
        Users expResult = null;
        Users result = instance.updateUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class DataProvider.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        Users user = null;
        DataProvider instance = new DataProvider();
        List<Users> expResult = null;
        List<Users> result = instance.deleteUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteExperiment method, of class DataProvider.
     */
    @Test
    public void testDeleteExperiment() {
        System.out.println("deleteExperiment");
        ExampleExperiment experiment = null;
        DataProvider instance = new DataProvider();
        List<ExampleExperiment> expResult = null;
        List<ExampleExperiment> result = instance.deleteExperiment(experiment);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUser method, of class DataProvider.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        Users user = null;
        DataProvider instance = new DataProvider();
        List<Users> expResult = null;
        List<Users> result = instance.createUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
