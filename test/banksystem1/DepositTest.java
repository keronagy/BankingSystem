/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static junit.framework.TestCase.assertEquals;
/**
 *
 * @author Mina Rafla
 */
public class DepositTest {
    
    Account acc1;
    
    @Before
    public void setUp() throws Exception
    {
        acc1=new Account("khaled" , "0" , 1000.0,"TestDeposit");
    }
    @Test
    public void TestDeposit() {
        try {
            acc1.deposit(1500.0);
            assertTrue(true);
        } catch (Exception ex) {
        }
        assertEquals(2500.0, acc1.getBalance());
        try {
            acc1.deposit(-6);
            assertTrue(true);
        } catch (Exception ex) {
           
        }
        assertEquals(2500.0, acc1.getBalance());
    }
    
}
