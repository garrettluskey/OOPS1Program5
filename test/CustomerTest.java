/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
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
public class CustomerTest {
    
    public CustomerTest() {
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
     * Test of isAlreadyCustomer method, of class Customer.
     */
    @Test
    public void testIsAlreadyCustomer() {
        System.out.println("isAlreadyCustomer");
        Customer test = new Customer("123-45-6789", "Jim");
        String givenSsn = "123-45-6789";
        String givenName = "Jim";
        boolean expResult = true;
        boolean result = test.isAlreadyCustomer(givenSsn, givenName);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasSameSSN method, of class Customer.
     */
    @Test
    public void testHasSameSSN() {
        System.out.println("hasSameSSN");
        String enteredSSN = "123-45-6789";
        Customer instance = new Customer("123-45-6789", "Jim");
        boolean expResult = true;
        boolean result = instance.hasSameSSN(enteredSSN);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAccountList method, of class Customer.
     */
    @Test
    public void testGetAccountList() {
        System.out.println("getAccountList");
        Customer instance = new Customer("123-45-6789", "Jim");
        Account account = new CheckingAccount("Jim",11111);
        instance.addAccount(account);
        ArrayList<Account> expResult = instance.getAccountList();
        ArrayList<Account> result = instance.getAccountList();
        assertEquals(expResult, result);
    }

    /**
     * Test of addAccount method, of class Customer.
     */
    @Test
    public void testAddAccount() {
        System.out.println("addAccount");
        Account acc = new CheckingAccount("Jim",11111);
        Customer instance = new Customer("123-45-6789", "Jim");
        instance.addAccount(acc);
    }

    /**
     * Test of getCustomerName method, of class Customer.
     */
    @Test
    public void testGetCustomerName() {
        System.out.println("getCustomerName");
        Customer instance = new Customer("123-45-6789", "Jim");
        String expResult = "Jim";
        String result = instance.getCustomerName();
        assertEquals(expResult, result);
    }
    
}
