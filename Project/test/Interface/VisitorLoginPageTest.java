/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jianlin070
 */
public class VisitorLoginPageTest {
    
    public VisitorLoginPageTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
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
