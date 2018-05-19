package banksystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// change Currency
class ChangeCurrency extends javax.swing.JDialog {
    private JButton proceed;  // to transfer to another page
    private JButton cancel;     // to cancel the operation
    private JButton UsDollar;  // dollar currency source
    private JButton UsDollarDes;
    private JButton Euro;       // euro currency
    private JButton Eurodes;
    private JButton Yen;        // japanese currence
    private JButton Yendes;
    private JButton EgyPound;   // el gnih elmasry currency
    private JButton EgyPounddes;
    private JTextField Money;
    private JLabel Mney;
    private JPanel Panel1;  // fo2
    private JPanel Panel2; // t7t
    private JPanel Panel3; // middle
    private JLabel Type;
    private JPanel flow1;
    private JPanel flow2;
    private JPanel flow3;
    private JPanel flow4;
    private JPanel flow5;
    protected int flag1;
    protected int flag2;
    private JTextField current;
    private JTextField IsRequired; 
    public ChangeCurrency(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
       
        
        setLocationRelativeTo(null);
        this.setTitle("Currency Change");
        this.setBounds(1920 / 2 - 200, 300, 400, 300);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        //*****************************************        
        this.Panel1 = new JPanel();
        this.Panel1.setLayout(new FlowLayout());
        this.Mney = new JLabel("Money Value");
        Panel1.add(Mney);
        this.Money = new JTextField(20);
        Panel1.add(Money);
        c.add(Panel1, BorderLayout.NORTH);
        //***********************************************
        //goz2 ele fl nos
        this.current = new JTextField(6);
        this.IsRequired = new JTextField(6);
        this.Type = new JLabel("Choose Currency");
        this.EgyPound = new JButton("EGY Pound");
        this.EgyPound.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag1 = 0;
                current.setText("Egy Pound");
            }
        });
        this.Yen = new JButton("Yen");
        this.Yen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag1 = 1;
                current.setText("Yen");
            }
        });
        this.UsDollar = new JButton("US Dollar");
        this.UsDollar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag1 = 2;
                current.setText("US Dollar");
            }
        });
        this.Euro = new JButton("Euro");
        this.Euro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag1 = 3;
                current.setText("Euro");
            }
        });
        this.EgyPounddes = new JButton("EGY Pound");
        this.EgyPounddes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag2 = 0;
                IsRequired.setText("Egy Pound");
            }
        });
        this.Yendes = new JButton("Yen");
        this.Yendes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag2 = 1;
                IsRequired.setText("Yen");
            }
        });
        this.UsDollarDes = new JButton("US Dollar");
        this.UsDollarDes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag2 = 2;
                IsRequired.setText("US Dollars");
            }
        });
        this.Eurodes = new JButton("Euro");
        this.Eurodes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag2 = 3;
                IsRequired.setText("Euro");
            }
        });
        this.Panel3 = new JPanel();
        this.Panel3.setLayout(new GridLayout(5, 1));
        this.flow1 = new JPanel();
        this.flow2 = new JPanel();
        this.flow3 = new JPanel();
        this.flow4 = new JPanel();
        this.flow5 = new JPanel();
        this.flow1.setLayout(new FlowLayout());
        this.flow2.setLayout(new FlowLayout());
        this.flow3.setLayout(new FlowLayout());
        this.flow4.setLayout(new FlowLayout());
        this.flow5.setLayout(new FlowLayout());
        Panel3.add(flow1);
        Panel3.add(flow2);
        Panel3.add(flow3);
        Panel3.add(flow4);
        Panel3.add(flow5);
        this.Type = new JLabel("Select Source Currency");
        flow1.add(Type);
        flow2.add(EgyPound);
        flow2.add(UsDollar);
        flow2.add(Yen);
        flow2.add(Euro);
        flow4.add(EgyPounddes);
        flow4.add(UsDollarDes);
        flow4.add(Yendes);
        flow4.add(Eurodes);
        this.Type = new JLabel("Select required Currency");
        flow3.add(Type);
        this.Type = new JLabel("Current");
        flow5.add(Type);
        flow5.add(current);
        this.Type = new JLabel("required");
        flow5.add(Type);
        flow5.add(IsRequired);
        c.add(Panel3, BorderLayout.CENTER);
//********************************************
        //goz2 ele t7t
        
        this.cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = JOptionPane.showConfirmDialog(null, "Are You Sure you want to Cancel?", "Confirmation", 0);
                if (x == JOptionPane.YES_OPTION) {
                    
                    dispose();
                }
            }
        });
        this.proceed = new JButton("Start");
        proceed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = JOptionPane.showConfirmDialog(null, "Are You Sure ?", "Confirmation", 0);
                if (x == JOptionPane.YES_OPTION)
                {
                    double m =Double.parseDouble(Money.getText());
                    JOptionPane.showMessageDialog(null, "previous Money = " + Money.getText()+flagToWord(flag1) +"\nCurrent Money = " + String.valueOf(Change(m,flag1,flag2))+flagToWord(flag2) ,"Small Report",2);
                    
                    dispose();
                }
            }
        });
            this.Panel2  = new JPanel();
            this.Panel2.setLayout (
            new GridLayout(1, 2));
            this.Panel2.add (proceed);
            this.Panel2.add (cancel);
            c.add (Panel2, BorderLayout.SOUTH);
        }
        //methods  
        public static double Change(double amount, int flag1, int flag2) {
        double des = 0;
        if (flag1 == 0)// for egypt
        {
            switch (flag2) {
                case 0:
                    des = amount;
                    break;
                case 1:
                    des = amount * 12.5;
                    break;
                case 2:
                    des = amount * 0.113;
                    break;
                case 3:
                    des = amount * 0.1;
                    break;
            }
        } else if (flag1 == 1) // for yen
        {
            switch (flag2) {
                case 0:
                    des = amount * 0.08;
                    break;
                case 1:
                    des = amount;
                    break;
                case 2:
                    des = amount * 0.009;
                    break;
                case 3:
                    des = amount * 0.008;
                    break;
            }
        } else if (flag1 == 2) // for usDollar
        {
            switch (flag2) {
                case 0:
                    des = amount * 8.88;
                    break;
                case 1:
                    des = amount * 111;
                    break;
                case 2:
                    des = amount;
                    break;
                case 3:
                    des = amount * 0.88;
                    break;
            }
        } else if (flag1 == 3) // for euro
        {
            switch (flag2) {
                case 0:
                    des = amount * 10;
                    break;
                case 1:
                    des = amount * 125;
                    break;
                case 2:
                    des = amount * 1.14;
                    break;
                case 3:
                    des = amount;
                    break;
            }
        }
        return des;
    }
    protected String flagToWord(int x) {
        switch(x){
            case 0: 
                return " EG";
            case 1:
                return " Yen";
            case 2:
                return " $";
            case 3:
                return " Euro";
        }
        return "";
    }
}

