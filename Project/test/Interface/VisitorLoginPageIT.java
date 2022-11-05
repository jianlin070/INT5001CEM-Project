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
public class VisitorLoginPageIT {
    
    public VisitorLoginPageIT() {
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
     * Test of validateLogin method, of class VisitorLoginPage.
     */
    @Test
    public void testValidateLogin() {
        System.out.println("validateLogin");
        VisitorLoginPage instance = new VisitorLoginPage();
        boolean expResult = false;
        boolean result = instance.validateLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class VisitorLoginPage.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        VisitorLoginPage instance = new VisitorLoginPage();
        instance.login();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class VisitorLoginPage.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        VisitorLoginPage.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
