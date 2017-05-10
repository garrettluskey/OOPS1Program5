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
import static org.junit.Assert.*;

/**
 *
 * @author My
 */
public class CheckingAccountTest {
    
    public CheckingAccountTest() {
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
     * Test of getAccountBalance method, of class CheckingAccount.
     */
    @Test
    public void testGetAccountBalance() {
        System.out.println("getAccountBalance");
        Account instance = new CheckingAccount("Tim", 11111);
        instance.balance = 600f;
        float expResult = 600.0F;
        float result = instance.getAccountBalance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getAccountSummary method, of class CheckingAccount.
     */
    @Test
    public void testGetAccountSummary() {
        System.out.println("getAccountSummary");
        Account instance = new CheckingAccount("Tim", 11111);
        instance.balance = 600f;
        String expResult = "Account holder is Tim; Account number is 11111; Account type is checking; Account balance is 600";
        String result = instance.getAccountSummary();
        assertEquals(expResult, result);
    }
    
}
