/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.sikuli.script.Screen;
import org.junit.Assert;
import banksystem1.MainMenue;
import static org.sikuli.script.ImagePath.find;
import org.sikuli.script.Key;
import org.sikuli.script.*;
import static org.sikuli.script.Do.popup;
import org.sikuli.script.Region.*;

/**
 *
 * @author Dead Lock
 */
public class BankTest {

    String user = "user";
    String pass = "123";

    public void GUIThread() {

    }

    @Test
    public void testGUI() {
        try {

            Screen s = new Screen();
            MainMenue w = new MainMenue();
            w.setVisible(true);
            popup("begin testing\nI hope you enjoy :D ",3);
            popup("The Happy scenario :D ");
            // happy scenario :D 
            // create 5 accounts
            popup("adding 5 accounts ");
            for (int i = 0; i < 5; i++) {
                s.click("imgs\\AddAcc\\AddAccountBtn.PNG");

                s.type((user + (i + 1)) + Key.TAB + ("1" + (i * 200)) + Key.TAB + pass);
                s.click("imgs\\AddAcc\\AddAccCreateBtn.PNG");
                Assert.assertNotNull("error in creating Account when i = " + i, s.exists("imgs\\AddAcc\\AddAccount.PNG"));
                s.click("imgs\\okBtn.PNG");
            }
            //enqueue all 5 accounts
            popup("enqueue 5 accounts ");
            for (int i = 0; i < 5; i++) {
                s.click("imgs\\enque\\EnqueueBtn.PNG");
                s.type(i + 1 + Key.TAB + pass);
                s.click("imgs\\enque\\EnqueueEnqBtn.PNG");
            }
            popup("dequeue the first account");
            //dequeue first account by clicking finish
            s.click("imgs\\finish\\FinishBtn.PNG");
            popup("making withdraw");
            // withdraw from first account in queue
            s.click("imgs\\withdraw\\WithdrawBtn.PNG");
            s.type("500");
            s.click("imgs\\withdraw\\WithdrawWithBtn.PNG");
            Assert.assertNotNull("error", s.exists("imgs\\withdraw\\success.PNG"));
            s.click("imgs\\okBtn.PNG");

            // deposite
            popup("making deposite");
            s.click("imgs\\deposite\\DepositBtn.PNG");
            s.type("5000");
            s.click("imgs\\deposite\\depositedepoBtn.PNG");
            Assert.assertNotNull("error", s.exists("imgs\\deposite\\success.PNG"));
            s.click("imgs\\okBtn.PNG");

            //dequeue on account
            popup("dequeue");
            s.click("imgs\\finish\\FinishBtn.PNG");
            popup("transfering money");
            //transfer
            s.click("imgs\\transfer\\TransferBtn.PNG");
            s.type("5" + Key.TAB + "1000");
            s.click("imgs\\transfer\\TransferTransBtn.PNG");
            Assert.assertNotNull("error", s.exists("imgs\\transfer\\success.PNG"));
            s.click("imgs\\okBtn.PNG");

            //finish all
            popup("dequeue all");
            for (int i = 0; i < 4; i++) {
                s.click("imgs\\finish\\FinishBtn.PNG");
                if (i == 3) {
                    assertNotNull("ERROR", s.exists("imgs\\finish\\noelements.PNG"));
                    s.click("imgs\\okBtn.PNG");
                }
            }
            popup("happy senario finished\nStarting individual tests");
            // enqueue for 1 account
            s.click("imgs\\enque\\EnqueueBtn.PNG");
            s.type("5" + Key.TAB + pass);
            s.click("imgs\\enque\\EnqueueEnqBtn.PNG");


            popup("begin Add account tests");
            //----- begin AddAccount Jframe Test name, balance, pass empty or wrong --------------
            s.click("imgs\\AddAcc\\AddAccountBtn.PNG");
            s.type((user+"6") + Key.TAB + Key.TAB + pass);
            s.click("imgs\\AddAcc\\AddAccCreateBtn.PNG");
            //balance empty
            Assert.assertNotNull("balance empty ", s.exists("imgs\\AddAcc\\balnceempty.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.click("imgs\\AddAcc\\balance.PNG");
            s.type("kero");
            s.click("imgs\\AddAcc\\AddAccCreateBtn.PNG");
            // balance not a number
            Assert.assertNotNull("Balance not a number ", s.exists("imgs\\AddAcc\\balancemustbenumber.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\AddAcc\\balance.PNG");
            s.type(Key.BACKSPACE+"5000");
            s.doubleClick("imgs\\AddAcc\\name.PNG");
            s.type(Key.BACKSPACE);
            s.click("imgs\\AddAcc\\AddAccCreateBtn.PNG");
            // name empty
            Assert.assertNotNull("name empty ", s.exists("imgs\\AddAcc\\nameempty.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.type("imgs\\AddAcc\\name.PNG","user6");
            s.doubleClick("imgs\\AddAcc\\pass.PNG");
            s.type(Key.BACKSPACE);
            s.click("imgs\\AddAcc\\AddAccCreateBtn.PNG");
            // pass empty
            Assert.assertNotNull("pass empty ", s.exists("imgs\\AddAcc\\passempty.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.click("imgs\\AddAcc\\pass.PNG");
            s.type(pass);
            s.click("imgs\\AddAcc\\AddAccCreateBtn.PNG");
            s.click("imgs\\okBtn.PNG");
            popup("finish add account tests");
            // -------------------- end add account test -------------
            
            popup("bigin enqueue tests");
            // ------ begin enqueue Jframe test pass , acc num , if acc alredy enqueued ------------
            s.click("imgs\\enque\\EnqueueBtn.PNG");
            s.type(6 + Key.TAB + "1234");
            s.click("imgs\\enque\\EnqueueEnqBtn.PNG");
            //wrong pass
            Assert.assertNotNull("Pass error ", s.exists("imgs\\enque\\wrongpass.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\enque\\wrongpasstxt.PNG");
            s.type(Key.BACKSPACE+pass);
            s.doubleClick("imgs\\enque\\accnum.PNG");
            s.type(Key.BACKSPACE+666);
            s.click("imgs\\enque\\EnqueueEnqBtn.PNG");
            // not number
            Assert.assertNotNull("Pass error ", s.exists("imgs\\enque\\accmustbenum.PNG"));
            s.click("imgs\\okBtn.PNG");
            //alreadyexist
            s.doubleClick("imgs\\enque\\accnum.PNG");
            s.type(Key.BACKSPACE+"5");
            s.click("imgs\\enque\\EnqueueEnqBtn.PNG");
            //already exist
            Assert.assertNotNull("Pass error ", s.exists("imgs\\enque\\alreadyexist.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.click("imgs\\enque\\EnqueueBtn.PNG");
            s.type("6" + Key.TAB + pass);
            s.click("imgs\\enque\\EnqueueEnqBtn.PNG");
            popup("finish enqueue tests");
            // --------- end enqueue test ---------------------

            //------- begin withdraw test ---------------------
            popup("begin withdraw tests");
            s.click("imgs\\withdraw\\WithdrawBtn.PNG");
            s.type("keroo");
            s.click("imgs\\withdraw\\WithdrawWithBtn.PNG");
            //must be a number
            Assert.assertNotNull("value is not number ", s.exists("imgs\\withdraw\\mustbenumber.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\withdraw\\value.PNG");
            s.type(Key.BACKSPACE + "50000");
            s.click("imgs\\withdraw\\WithdrawWithBtn.PNG");
            // big value
            Assert.assertNotNull("big value ", s.exists("imgs\\withdraw\\errorbigvalue.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\withdraw\\value.PNG");
            s.type(Key.BACKSPACE + "-1000");
            s.click("imgs\\withdraw\\WithdrawWithBtn.PNG");
            // -ve
            Assert.assertNotNull("-ve value ", s.exists("imgs\\withdraw\\zerovalue.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\withdraw\\value.PNG");
            s.type(Key.BACKSPACE+ Key.BACKSPACE + "0");
            s.click("imgs\\withdraw\\WithdrawWithBtn.PNG");
            // zero
            Assert.assertNotNull("zero ", s.exists("imgs\\withdraw\\zerovalue.PNG"));
            s.click("imgs\\okBtn.PNG");
            
            s.doubleClick("imgs\\withdraw\\value.PNG");
            s.type(Key.BACKSPACE +Key.BACKSPACE+ "1000");
            s.click("imgs\\withdraw\\WithdrawWithBtn.PNG");
            //success
            Assert.assertNotNull("error ", s.exists("imgs\\withdraw\\success.PNG"));
            s.click("imgs\\okBtn.PNG");
            popup("finish withdraw tests");
            //-------------- end withdraw test -----------------
            
            
            //-------------- begin deposite test ----------------------
            popup("begin deposite tests");
            s.click("imgs\\deposite\\DepositBtn.PNG");
            s.type("kk");
            s.click("imgs\\deposite\\depositedepoBtn.PNG");
            // not number
            Assert.assertNotNull("not number ", s.exists("imgs\\deposite\\number.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\deposite\\value.PNG");
            s.type(Key.BACKSPACE +Key.BACKSPACE+ "0");
            s.click("imgs\\deposite\\depositedepoBtn.PNG");
            // zero
            Assert.assertNotNull("zero ", s.exists("imgs\\deposite\\zero.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\deposite\\value.PNG");
            s.type(Key.BACKSPACE +Key.BACKSPACE+ "-1000");
            s.click("imgs\\deposite\\depositedepoBtn.PNG");
            // -ve
            Assert.assertNotNull("-ve ", s.exists("imgs\\deposite\\zero.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\deposite\\value.PNG");
            s.type(Key.BACKSPACE +Key.BACKSPACE+ "5000");
            s.click("imgs\\deposite\\depositedepoBtn.PNG");
            //success
            Assert.assertNotNull("success ", s.exists("imgs\\deposite\\success.PNG"));
            s.click("imgs\\okBtn.PNG");
            popup("finish deposite tests");
            //----------------- end deposite test ---------------------
            
            
            // ----------------- begin transfer test -------------------
            popup("begin transfer tests");
            s.click("imgs\\transfer\\TransferBtn.PNG");
            s.type("594" + Key.TAB+ "2000");
            s.click("imgs\\transfer\\TransferTransBtn.PNG");
            // no account with this number
            Assert.assertNotNull("no account with this number ", s.exists("imgs\\transfer\\accnotexist.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\transfer\\transfree.PNG");
            s.type(Key.BACKSPACE + "kk");
            s.click("imgs\\transfer\\TransferTransBtn.PNG");
            // must be number
            Assert.assertNotNull("must be number ", s.exists("imgs\\transfer\\accmustbenum.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\transfer\\transfree.PNG");
            s.type(Key.BACKSPACE );
            s.click("imgs\\transfer\\TransferTransBtn.PNG");
            // empty acc num
            Assert.assertNotNull("empty acc num ", s.exists("imgs\\transfer\\accmustbenum.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\transfer\\transfree.PNG");
            s.type(Key.BACKSPACE +"5" );
            s.click("imgs\\transfer\\TransferTransBtn.PNG");
            // same acc
            Assert.assertNotNull("same acc ", s.exists("imgs\\transfer\\sameacc.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\transfer\\transfree.PNG");
            s.type(Key.BACKSPACE +"6" );
            s.doubleClick("imgs\\transfer\\value.PNG");
            s.type(Key.BACKSPACE +"50000" );
            s.click("imgs\\transfer\\TransferTransBtn.PNG");
            // more than existing balance
            Assert.assertNotNull("more than existing balance", s.exists("imgs\\transfer\\morethanexisiting.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\transfer\\value.PNG");
            s.type(Key.BACKSPACE +"kero" );
            s.click("imgs\\transfer\\TransferTransBtn.PNG");
            // must be num
            Assert.assertNotNull("must be num", s.exists("imgs\\transfer\\valuemustbnum.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\transfer\\value.PNG");
            s.type(Key.BACKSPACE +"0" );
            s.click("imgs\\transfer\\TransferTransBtn.PNG");
            // value cannot be zero
            Assert.assertNotNull("zero", s.exists("imgs\\transfer\\zero.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\transfer\\value.PNG");
            s.type(Key.BACKSPACE +"-2000" );
            s.click("imgs\\transfer\\TransferTransBtn.PNG");
            // value cannot be -ve value
            Assert.assertNotNull("-ve value", s.exists("imgs\\transfer\\zero.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.doubleClick("imgs\\transfer\\value.PNG");
            s.type(Key.BACKSPACE +Key.BACKSPACE +"5000");
            s.click("imgs\\transfer\\TransferTransBtn.PNG");
            // success
            Assert.assertNotNull("success", s.exists("imgs\\transfer\\success.PNG"));
            s.click("imgs\\okBtn.PNG");
            popup("finish transfer tests");
            // --------------- end transfer test -----------------
            
            // --------- begin close and open test -------------
            popup("begin open and close account tests");
            s.click("imgs\\open\\OpenAccBtn.PNG");
            //already opened
            Assert.assertNotNull("already opened", s.exists("imgs\\open\\alreadyopened.PNG"));
            s.click("imgs\\okBtn.PNG");
            //close
            s.click("imgs\\close\\CloseAccBtn.PNG");
            //still have money
            Assert.assertNotNull("still have money", s.exists("imgs\\close\\stillhavemoney.PNG"));
            s.click("imgs\\okBtn.PNG");
            //withdraw
            s.click("imgs\\withdraw\\WithdrawBtn.PNG");
            s.type("1800");
            s.click("imgs\\withdraw\\WithdrawWithBtn.PNG");
            s.click("imgs\\okBtn.PNG");
            s.click("imgs\\close\\CloseAccBtn.PNG");
            
            // test functions
            s.click("imgs\\withdraw\\WithdrawBtn.PNG");
            Assert.assertNotNull("closed", s.exists("imgs\\close\\functions.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.click("imgs\\transfer\\TransferBtn.PNG");
            Assert.assertNotNull("closed", s.exists("imgs\\close\\functions.PNG"));
            s.click("imgs\\okBtn.PNG");
            s.click("imgs\\deposite\\DepositBtn.PNG");
            Assert.assertNotNull("closed", s.exists("imgs\\close\\functions.PNG"));
            s.click("imgs\\okBtn.PNG");
            Thread.sleep(500);
            s.click("imgs\\close\\CloseAccBtn.PNG");
            //already closed
            Assert.assertNotNull("already closed", s.exists("imgs\\close\\alreadyclosed.PNG"));
            s.click("imgs\\okBtn.PNG");
            
            s.click("imgs\\open\\OpenAccBtn.PNG");
            popup("finish open and close tests");
            // --------- end of open and close test ---------------
            
            // ---------- begin change currency test ---------------
            popup("begin change currency test");
            s.click("imgs\\changecurr\\changecurrBtn.PNG");
            s.type("50");
            s.click("imgs\\changecurr\\us.PNG");
            s.click("imgs\\changecurr\\yen.PNG");
            s.click("imgs\\changecurr\\start.PNG");
            s.click("imgs\\changecurr\\yes.PNG");
            Assert.assertNotNull("success", s.exists("imgs\\changecurr\\success.PNG"));
            s.click("imgs\\okBtn.PNG");
            popup("finish tests");
            // ---------- end of change currency test ----------
            s.click("imgs\\finish\\FinishBtn.PNG");
            s.click("imgs\\finish\\FinishBtn.PNG");
            
            popup("THE END \n THANK YOU ALL :D ",5);
            
            s.click("imgs\\about.PNG");
            Thread.sleep(5000);
            s.click("imgs\\close.png");
            
            
            
            
            
                    
                    
        } catch (Exception e) {
        }
    }
}
