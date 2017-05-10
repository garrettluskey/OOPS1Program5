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
public class AccountTest {
    
    public AccountTest() {
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
     * Test of withdraw method, of class Account.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        float amount = 100F;
        Account instance = new AccountImpl();
        instance.balance = 600f;
        boolean expResult = true;
        boolean result = instance.withdraw(amount);
        assertEquals(expResult, result);
    }

    /**
     * Test of deposit method, of class Account.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit");
        float amount = 100.0F;
        Account instance = new AccountImpl();
        instance.balance = 600f;
        boolean expResult = true;
        boolean result = instance.deposit(amount);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAccountBalance method, of class Account.
     */
    @Test
    public void testGetAccountBalance() {
        System.out.println("getAccountBalance");
        Account instance = new AccountImpl();
        float expResult = 600.0F;
        float result = instance.getAccountBalance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of compareTo method, of class Account.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Account instance = new AccountImpl();
        Account test = new AccountImpl();
        test.balance = 400;
        int expResult = 1;
        int result = instance.compareTo(test);
        assertEquals(expResult, result);
    }

    /**
     * Test of isAccount method, of class Account.
     */
    @Test
    public void testIsAccount() {
        System.out.println("isAccount");
        int accountNumber = 11111;
        Account instance = new AccountImpl();
        instance.accountNumber = 11111;
        boolean expResult = true;
        boolean result = instance.isAccount(accountNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnAccountNumber method, of class Account.
     */
    @Test
    public void testReturnAccountNumber() {
        System.out.println("returnAccountNumber");
        Account instance = new AccountImpl();
        instance.accountNumber = 11111;
        int expResult = 11111;
        int result = instance.returnAccountNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of isBalanceZero method, of class Account.
     */
    @Test
    public void testIsBalanceZero() {
        System.out.println("isBalanceZero");
        Account instance = new AccountImpl();
        instance.balance = 600f;
        boolean expResult = false;
        boolean result = instance.isBalanceZero();
        assertEquals(expResult, result);
    }

    /**
     * Test of newBalance method, of class Account.
     */
    @Test
    public void testNewBalance() {
        System.out.println("newBalance");
        Account instance = new AccountImpl();
        instance.balance = 600f;
        String expResult = "Your new balance is: 600.0";
        String result = instance.newBalance();
        assertEquals(expResult, result);
    }

    /**
     * Test of totalNumberOfAccounts method, of class Account.
     */
    @Test
    public void testTotalNumberOfAccounts() {
        System.out.println("totalNumberOfAccounts");
        int expResult = 1;
        SavingsAccount instance = new SavingsAccount("Jim", 11111);
        int result = Account.totalNumberOfAccounts();
        assertEquals(expResult, result);
    }

    public class AccountImpl extends Account {

        public float getAccountBalance() {
            return 600.0F;
        }
    }
    
}
