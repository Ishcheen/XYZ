/*
 * Classname: Assigment1.java
 */
import java.util.*;

class Account{
    private String name;
    private int balance=1000;
    public int getBalance(){
        return this.balance;
    }
    public void withdraw(int amount){
        balance= balance-amount;
    }
}

class AccountOverdrawDemo implements Runnable{
    Account account=new Account();
    public static void main(String args){
        AccountOverdrawDemo bankWithdraw= new AccountOverdrawDemo();
        Thread one=new Thread(bankWithdraw);
        Thread two=new Thread(bankWithdraw);
        one.setName("Person 1");
        two.setName("Person 2");
        one.start();
        two.start();
    }    
}