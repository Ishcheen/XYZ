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

    public void run(){
        for(int i=0; i<=10; i++){
            if(account.getBalance()>=100){
                System.out.println((i+1)+". "+Thread.currentThread().getName()+" has withdrawn 100 rupees from the bank."
                                             +" Remaining balance: "+account.getBalance());
                account.withdraw(100);
            }
            if(account.getBalance()<0){
                System.out.println("Overdrawn");
                break;
            }
        }
    }
    
}