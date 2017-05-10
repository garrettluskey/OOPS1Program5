/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.text.DecimalFormat;
import static org.junit.Assert.*;

/**
 *
 * @author My
 */
public class SavingsAccountTest {
    
    public SavingsAccountTest() {
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
     * Test of getAccountBalance method, of class SavingsAccount.
     */
    @Test
    public void testGetAccountBalance() {
        System.out.println("getAccountBalance");
        SavingsAccount instance = new SavingsAccount("Jim",11111);
        instance.balance = 60.0F;
        float expResult = 60.30062484741211f;
        float result = instance.getAccountBalance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getAccountSummary method, of class SavingsAccount.
     */
    @Test
    public void testGetAccountSummary() {
        System.out.println("getAccountSummary");
        SavingsAccount instance = new SavingsAccount("Jim",11111);
        String expResult = "Account holder is Jim; Account number is 11111; Account type is savings; Account balance is 0";
        String result = instance.getAccountSummary();
        assertEquals(expResult, result);
    }
    
}
