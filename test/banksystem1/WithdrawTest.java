/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem1;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author Mina Rafla
 */
public class WithdrawTest{
    Account acc ; 
    
    @Before
    public void setUp() throws Exception{
        acc=new Account("Mina" , "0" , 1000.0 , "TEST");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setFirstRowAccNum method, of class Withdraw.
     */
    @Test
    public void TestWithdraw() throws Exception
    {
        acc.withdraw(100);
        assertEquals(900.0, acc.getBalance());
        acc.withdraw(150);
        assertEquals(750.0 , acc.getBalance());
        acc.withdraw(111111);
        assertEquals(750.0 , acc.getBalance());
        acc.withdraw(-111111);
        assertEquals(750.0 , acc.getBalance());
    }
    
}
