/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Interface;

import static Interface.VisitorCheckStatusPage.ic_no;
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
public class VisitorCheckStatusPageIT {
    
    public VisitorCheckStatusPageIT() {
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
     * Test of validateStatus method, of class VisitorCheckStatusPage.
     */
    @Test
    public void testValidateStatus() {
        System.out.println("validateStatus");
        VisitorCheckStatusPage instance = new VisitorCheckStatusPage(ic_no);
        boolean expResult = false;
        boolean result = instance.validateStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkSatus method, of class VisitorCheckStatusPage.
     */
    @Test
    public void testCheckSatus() {
        System.out.println("checkSatus");
        VisitorCheckStatusPage instance = new VisitorCheckStatusPage(ic_no);
        instance.checkSatus();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class VisitorCheckStatusPage.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        VisitorCheckStatusPage.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
