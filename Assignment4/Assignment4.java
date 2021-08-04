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