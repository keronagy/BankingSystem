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
/**
 *
 * @author Mina Rafla
 */
public class SaveTest{
    Account acc;
    @Before
    public void setUp () 
    {
        try {
            acc = new Account("Mina" , "0" , 1000.0 , "TEST");
        } catch (Exception ex) {
            assertTrue(true);
        }
       
        
    }
    @Test 
    public void TestSave()
    {
        try {
            try {
                acc.save();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SaveTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(SaveTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            acc.name="askdjahskdj";
            acc.load();
            assertTrue(true);
            assertEquals("Mina" , acc.name);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
