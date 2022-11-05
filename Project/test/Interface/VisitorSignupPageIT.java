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
public class VisitorSignupPageIT {
    
    public VisitorSignupPageIT() {
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
     * Test of insertSignupDetails method, of class VisitorSignupPage.
     */
    @Test
    public void testInsertSignupDetails() {
        System.out.println("insertSignupDetails");
        VisitorSignupPage instance = new VisitorSignupPage();
        instance.insertSignupDetails();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateSignup method, of class VisitorSignupPage.
     */
    @Test
    public void testValidateSignup() {
        System.out.println("validateSignup");
        VisitorSignupPage instance = new VisitorSignupPage();
        boolean expResult = false;
        boolean result = instance.validateSignup();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkDuplicateVisitor method, of class VisitorSignupPage.
     */
    @Test
    public void testCheckDuplicateVisitor() {
        System.out.println("checkDuplicateVisitor");
        VisitorSignupPage instance = new VisitorSignupPage();
        boolean expResult = true;
        boolean result = instance.checkDuplicateVisitor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class VisitorSignupPage.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        VisitorSignupPage.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
