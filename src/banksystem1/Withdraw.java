/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author TH3_HACK3R
 */
public class Withdraw extends javax.swing.JDialog {

    private Account account;
    private int firstRowAccNum;
    /**
     * Creates new form Withdraw
     */
    public void setFirstRowAccNum(int firstRowAccNum)
    {
        this.firstRowAccNum=firstRowAccNum;
    }
            
            
    public Withdraw(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setSize(409 , 100);
        
    }
    public Withdraw(java.awt.Frame parent, boolean modal,int firstRowAccNum) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setSize(409 , 100);
        this.firstRowAccNum=firstRowAccNum;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WValue = new javax.swing.JLabel();
        WValueTxt = new javax.swing.JTextField();
        WBtn = new javax.swing.JButton();
        WCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        WValue.setText("Value");
        getContentPane().add(WValue);
        getContentPane().add(WValueTxt);

        WBtn.setText("Withdraw");
        WBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WBtnActionPerformed(evt);
            }
        });
        getContentPane().add(WBtn);

        WCancel.setText("Cancel");
        WCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WCancelActionPerformed(evt);
            }
        });
        getContentPane().add(WCancel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WCancelActionPerformed
        // TODO add your handling code here:
         this.dispose();
    }//GEN-LAST:event_WCancelActionPerformed

    private void WBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WBtnActionPerformed
        // TODO add your handling code here:
        double Value,Test;
        if(WValueTxt.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Value cannot be empty", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // lazem 2t2ked enha m4 string 34an m4 hy3rf y7wlha

        else
        {
            try
            {
                Test=Double.parseDouble(WValueTxt.getText());
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this, "Value must be a number", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
        }
        if(Double.parseDouble(WValueTxt.getText())<=0)
        {
            JOptionPane.showMessageDialog(this, "Value cannot equal to 0 or negative value", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        

        Value=Double.parseDouble(WValueTxt.getText());
        
        ArrayList accounts;
        try {
            accounts = Account.load2();
            account = (Account)accounts.get(firstRowAccNum-1);
            if(Double.parseDouble(WValueTxt.getText())>account.getBalance())
            {
                JOptionPane.showMessageDialog(this, "Value can't be greater than existing balance", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{
            JOptionPane.showMessageDialog(this, "Withdrawal value = "+ Value);
            account.withdraw(Value);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Withdraw.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Withdraw.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Withdraw.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        



       this.dispose();
    }//GEN-LAST:event_WBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Withdraw dialog = new Withdraw(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton WBtn;
    private javax.swing.JButton WCancel;
    private javax.swing.JLabel WValue;
    private javax.swing.JTextField WValueTxt;
    // End of variables declaration//GEN-END:variables
public Account getAcc()
    {
        return this.account;
    }
}
