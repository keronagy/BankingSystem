package banksystem1;
import java.io.*;
import java.util.*;
class Account {
    private String Name;
    private int accNum;
    private double balance;
    private boolean opened;

    public Account(String name, int accNum, double balance) {
        this.Name = name;
        this.accNum = accNum;
        if(balance>=0)
            this.balance = balance;
        else this.balance = 0;
        this.opened = true;
    }
    public double getBalance() {
        return this.balance;
    }
    public void closeAcc() throws FileNotFoundException, UnsupportedEncodingException {
        if(this.opened==false)
            System.out.println("already closed");
        else if(this.balance > 0)
            System.out.println("can't close, still have money");
        else {
            this.opened = false;
            this.save();
        }
    }
    public void reopenAcc() {
        if(this.opened==true)
            System.out.println("already opened");
        else this.opened = true;
    }
    public void deposit(double amount) throws FileNotFoundException, UnsupportedEncodingException {
        if(this.opened==false||amount<=0) {
            if(this.opened==false)
                System.out.println("account is closed");
            if(amount <=0)
                System.out.println("invalid amount");
        }
        else {
            this.balance+=amount;
            this.save();
        }
    }
    public void transfer(Account a, double amount) throws FileNotFoundException, UnsupportedEncodingException {
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
        }
    }
    public void withdraw(double amount) throws FileNotFoundException, UnsupportedEncodingException {
        if(amount <=0||amount>this.balance||this.opened == false) {
            if(amount <=0) System.out.println("amount must be greater than zero");
            if(amount>this.balance) System.out.println("amount can't be greater than existing balance");
            if(this.opened == false) System.out.println("account is closed");
        }
        else {
            this.balance-=amount;
            this.save();
        }
     }
    public String toString() {
        return super.toString()+"\nAccount Number: "+this.accNum+"\nName: " + this.Name + "\nBalance: "+this.balance+"\nState: "+(this.opened?"Opened\n":"Closed\n");
    }
    public boolean equals(Object obj) {
        if(this==obj) return true;
        else if(this.getClass()==obj.getClass()) {
            Account a = (Account)obj;
            if(this.accNum==a.accNum && this.Name.equals(a.Name) && this.balance == a.balance && this.opened == a.opened)
                return true;
        }
        return false;
    }
    public void save() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("dataFile"+this.accNum+".txt", "UTF-8");
        writer.println(this.Name);
        writer.println(this.accNum);
        writer.println(this.balance);
        writer.println(this.opened);
        writer.close();
    }
    public void load() throws FileNotFoundException {
        Scanner s = new Scanner(new File("dataFile"+this.accNum+".txt"));
        this.Name = s.nextLine();
        this.accNum = Integer.parseInt(s.nextLine());
        this.balance = Double.parseDouble(s.nextLine());
        this.opened = Boolean.parseBoolean(s.nextLine());
    }
}
class Node {
    private Account data;
    private Node next;
    public Node(Account data, Node next) {
        this.data=data;
        this.next=next;
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