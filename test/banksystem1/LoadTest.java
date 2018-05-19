/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem1;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.Assert.assertEquals;

public class LoadTest{
    Account acc1 ,acc2;
    
    @Before
    public void setUp() throws FileNotFoundException, UnsupportedEncodingException
    {
        acc1=new Account("j" , "s" , 2558 , "sad");
        acc2=new Account("j" , "s" , 2558 , "sad");
        acc2.name = "MINAWAGDIFIKRI";
        acc2.accNum = 2500;
        acc2.passKey = "123";
        acc2.balance = 5000.0;    
        acc2.type= "Standard";
        acc2.opened = true; 
    }
    @Test
    public void TestLoad() 
    {
        acc1.accNum=2500;
        try { 
            acc1.load();
            assertTrue(true);
        } catch (FileNotFoundException ex) {
            
        }
        assertEquals(acc2,acc1);
        acc1.accNum=66666;
        try {
            acc1.load();
        } catch (FileNotFoundException ex) {
            assertTrue(true);
        }
        
    
}
}
