/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem1;

import java.awt.Frame;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author Mina Rafla
 */
public class ChangeCurrencyTest{
    
    ChangeCurrency money;
    double ChangedMoney;
    
    @Before
    public void setUp () throws Exception
    {
        money = new ChangeCurrency(new Frame() , true);
       
        
        
    }

    @Test
    public void TestChangeCurrency() {
        //flag 0 for egyptian 
        //flag 1 for Yen
        //flag 2 for US dollar
        //flag 3 for Euro
        ChangedMoney=ChangeCurrency.Change(2000,0 ,2 );
        assertEquals(226.0,ChangedMoney);
        ChangedMoney=ChangeCurrency.Change(2000,0,1);
        assertEquals(25000.0,ChangedMoney);
        ChangedMoney=ChangeCurrency.Change(2000,0,0);
        assertEquals(2000.0,ChangedMoney);
        ChangedMoney=ChangeCurrency.Change(2000,0,3);
        assertEquals(200.0,ChangedMoney);
        
        ChangedMoney=ChangeCurrency.Change(2000,1 ,0 );
        assertEquals(160.0,ChangedMoney);
        ChangedMoney=ChangeCurrency.Change(2000,1,1);
        assertEquals(2000.0,ChangedMoney);
        ChangedMoney=ChangeCurrency.Change(2000,1,2);
        assertEquals(18.0,ChangedMoney);
        ChangedMoney=ChangeCurrency.Change(2000,1,3);
        assertEquals(16.0,ChangedMoney);
        
        ChangedMoney=ChangeCurrency.Change(2000,2 ,0);
        assertEquals(17760.0,ChangedMoney);
        ChangedMoney=ChangeCurrency.Change(2000,2,1);
        assertEquals(222000.0,ChangedMoney);
        ChangedMoney=ChangeCurrency.Change(2000,2,2);
        assertEquals(2000.0,ChangedMoney);
        ChangedMoney=ChangeCurrency.Change(2000,2,3);
        assertEquals(1760.0,ChangedMoney);
        
        ChangedMoney=ChangeCurrency.Change(2000,3 ,0);
        assertEquals(20000.0,ChangedMoney);
        ChangedMoney=ChangeCurrency.Change(2000,3,1);
        assertEquals(250000.0,ChangedMoney);
        ChangedMoney=ChangeCurrency.Change(2000,3,2);
        assertEquals(2280.0,ChangedMoney);
        ChangedMoney=ChangeCurrency.Change(2000,3,3);
        assertEquals(2000.0,ChangedMoney);
        
        
       
        
        
    }
    
}
