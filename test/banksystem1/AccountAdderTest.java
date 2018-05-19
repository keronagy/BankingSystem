/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem1;
import java.awt.Frame;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static junit.framework.TestCase.assertEquals;

public class AccountAdderTest {
Account acc;
    
@Before
    public void TestAddingAccount()
    {
    try {
        acc= new Account("Mina" , "0" , 1000.0 , "Test");
        assertTrue(true);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(AccountAdderTest.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedEncodingException ex) {
        Logger.getLogger(AccountAdderTest.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
}
