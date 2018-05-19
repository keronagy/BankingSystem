package banksystem1;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
class Account {
    public String name;
    public int accNum;
    public String passKey;
    public double balance;
    String type;
    public boolean opened;
    static int count =0;
    public static Queue q= new Queue();
    public Account(String name, String passKey ,double balance, String type) throws FileNotFoundException, UnsupportedEncodingException {
        this.name = name;
        this.accNum = ++count;
        this.passKey = passKey;
        this.balance = balance;
        this.type=type;
        this.opened = true;
        this.save();
        this.save2();
    }
    
    
    public Account(String name, double balance) throws FileNotFoundException, UnsupportedEncodingException {
        this.name = name;
        this.accNum = ++count;
        if(balance>=0)
            this.balance = balance;
        else this.balance = 0;
        this.opened = true;
        this.save();
        this.save2();
        
    }
    
    public String isOpened()
    {
        if(this.opened==true)
            return "Yes";
        else
            return "No";
    }
    public double getBalance() {
        return this.balance;
    }
    public String getName()
    {
        return this.name;
    }
    public String getPass()
    {
        return this.passKey;
    }
    public int getAccNo()
    {
        return this.accNum;
    }
    public String getAccType()
    {
        return this.type;
    }
    public void closeAcc() throws FileNotFoundException, UnsupportedEncodingException {
        if(this.opened==false)
            System.out.println("already closed");
//        else if(this.balance > 0)
//            System.out.println("can't close, still have money");
        else {
            this.opened = false;
            this.save();
        }
    }
    public void reopenAcc() throws FileNotFoundException, UnsupportedEncodingException {
//        if(this.opened==true)
//            System.out.println("already opened");
         this.opened = true;
         this.save();
    }
    public void deposit(double amount) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        if(this.opened==false||amount<=0) {
            if(this.opened==false)
                System.out.println("account is closed");
            if(amount <=0)
                System.out.println("invalid amount");
        }
        else {
            this.balance+=amount;
            this.save();
            String s1= "deposit value = " + amount;
            this.save3(s1);
        }
    }
    public void transfer(Account a, double amount) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        if(a.opened==false||this.opened==false||amount<=0||this.balance<amount) {
            if(this.opened==false) System.out.println("source account is closed");
            if(a.opened==false) System.out.println("destination account is closed");
            if(amount<=0) System.out.println("amount must be greater than zero");
            if(amount > this.balance) System.out.println("source account has insufficient balance");
        }
        else {
            this.balance-=amount;
            a.balance+=amount;
            this.save();
            a.save();
            String s1= amount+ " Transferd From account "+ this.accNum + " to "+a.accNum;
            this.save3(s1);
            String s2 = amount + " transfered from account "+ this.accNum + " to this account ("+a.accNum+")"  ;
            a.save3(s2);
        }
    }
    public void withdraw(double amount) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        if(amount <=0||amount>this.balance||this.opened == false) {
            if(amount <=0) System.out.println("amount must be greater than zero");
            if(amount>this.balance) System.out.println("amount can't be greater than existing balance");
            if(this.opened == false) System.out.println("account is closed");
        }
        else {
            this.balance-=amount;
            this.save();
            String s1= "withdrawal value = " + amount;
            this.save3(s1);
        }
     }
    public String toString() {
        return super.toString()+"\nAccount Number: "+this.accNum+"\nName: " + this.name +"\nPass Key: "+this.passKey+ "\nBalance: "+this.balance+"\nType: "+this.type + "\nState: "+(this.opened?"Opened\n":"Closed\n");
    }
    public boolean equals(Object obj) {
        if(this==obj) return true;
        else if(this.getClass()==obj.getClass()) {
            Account a = (Account)obj;
            if(this.accNum==a.accNum && this.name.equals(a.name) && this.balance == a.balance && this.opened == a.opened)
                return true;
        }
        return false;
    }
    public void save() throws FileNotFoundException, UnsupportedEncodingException {
        
        PrintWriter writer = new PrintWriter("dataFile"+this.accNum+".txt", "UTF-8");
        writer.println(this.name);
        writer.println(this.accNum);
        writer.println(this.passKey);
        writer.println(this.balance);
        writer.println(this.type);
        writer.println(this.opened);
        writer.close();
    }
    public  void save2() throws FileNotFoundException, UnsupportedEncodingException {
        
        PrintWriter writer = new PrintWriter("countFile.txt", "UTF-8");
        writer.println(Account.count);
        writer.close();
    }
    public void save3(String s1) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        File log = new File("dataFile"+this.accNum+" Transaction.txt");
        try{
    if(!log.exists()){
        System.out.println("We had to make a new file.");
        log.createNewFile();
    }

    FileWriter fileWriter = new FileWriter(log, true);

    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        bufferedWriter.write(dateFormat.format(date));
        bufferedWriter.newLine();
        bufferedWriter.write(s1);
        bufferedWriter.newLine();
        bufferedWriter.write("___________________________________");
        bufferedWriter.newLine();
        bufferedWriter.close();

} catch(IOException e) {
    System.out.println("COULD NOT LOG!!");
}
        
    }
    public void load() throws FileNotFoundException {
        try {
            Scanner s = new Scanner(new File("dataFile"+this.accNum+".txt"));
            this.name = s.nextLine();
            this.accNum = Integer.parseInt(s.nextLine());
            this.passKey = s.nextLine();
            this.balance = Double.parseDouble(s.nextLine());
            this.type= s.nextLine();
            this.opened = Boolean.parseBoolean(s.nextLine());
        }
        catch(FileNotFoundException e) {
            
        }
    }
    public static ArrayList load2() throws FileNotFoundException, UnsupportedEncodingException {
        try {
            Account.count=0;
            Scanner s = new Scanner(new File("countFile.txt"));
            int n = Integer.parseInt(s.nextLine());
            ArrayList al = new ArrayList();
            for(int i =0; i<n; i++) {
                Scanner s2 = new Scanner(new File("dataFile"+(i+1)+".txt"));
                String st = s2.nextLine(); s2.nextLine();
                String pk = s2.nextLine();
                double d = Double.parseDouble(s2.nextLine());
                String t = s2.nextLine();
                al.add(new Account(st,pk,d,t));
                Account a = (Account)al.get(i);
                if(Boolean.parseBoolean(s2.nextLine())==false)
                    a.closeAcc();
            }
            return al;
        }
        catch(FileNotFoundException e) {
            
        }
        return null;
    }
}
class Node {
    private Account data;
    private Node next;
    public Node(Account data, Node next) {
        this.data=data;
        this.next=next;
    }
    public Node(Account data) {
        this(data, null);
    }
    public void setData(Account data) {
        this.data=data;
    }
    public Account getData() {
        return this.data;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getNext() {
        return this.next;
    }
}
class Queue {
    private Node head, tail;
    private int count;
    public Queue() {
        tail=head=null;
        count = 0;
    }
    public void enqueue(Node n) {
        if(head==null)
            tail=head=n;
        else {
            tail.setNext(n);
            tail=n;
        }
        tail.setNext(null);
        count++;
    }
    public Node dequeue() throws IOException {
        if(head==null)
            throw new IOException();
        count--;
        Node n = head;
        if(head==tail) {
            tail = head = null;
        }
        else {
            head=head.getNext();
        }
        return n;
    }
    public int getSize() {
        return this.count;
    }
    public Node getHead() {
        return this.head;
    }
    public Node getTail() {
        return this.tail;
    }
    public boolean isEmpty() {
        return count==0;
    }
    

    
}
