/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Interface;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class VisitorRegisterPageIT {
    
    public VisitorRegisterPageIT() {
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
     * Test of validateField method, of class VisitorRegisterPage.
     */
    @Test
    public void testValidateField() {
        System.out.println("validateField");
        VisitorRegisterPage instance = new VisitorRegisterPage("020729-07-0299");
        boolean expResult = true;
        boolean result = instance.validateField();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertSignupDetails method, of class VisitorRegisterPage.
     
    @Test
    public void testInsertSignupDetails() {
        System.out.println("insertSignupDetails");
        VisitorRegisterPage instance = new VisitorRegisterPage("020729-07-0299");
        instance.insertSignupDetails();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/

    /**
     * Test of main method, of class VisitorRegisterPage.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        VisitorRegisterPage.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
