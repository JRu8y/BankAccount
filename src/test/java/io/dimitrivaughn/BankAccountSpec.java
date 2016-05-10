package io.dimitrivaughn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dimitrivaughn on 5/2/16.
 */
public class BankAccountSpec {

    @Test
    public void getCurrentBalanceTest(){
        BankAccount myAccount = new BankAccount("Mark","001", "checking");
        myAccount.setAccountStatus("Open");
        myAccount.setCurrentBalance(100.00);
        double expectedValue = 100;
        double actualValue = myAccount.getCurrentBalance();
        assertEquals("Expected value = 100.00",expectedValue, actualValue, .0001);
    }

    @Test
    public void subtractCreditTransactionTest(){
        BankAccount myAccount = new BankAccount("Mark","001", "checking");
        myAccount.setAccountStatus("Open");
        myAccount.setCurrentBalance(150.00);
        myAccount.subtractCreditTransaction(100.00);
        double expectedValue = 50;
        double actualValue = myAccount.getCurrentBalance();
        assertEquals("Expected value = 100.00",expectedValue, actualValue, .0001);
    }

    @Test
    public void addDebitTransactionTest(){
        BankAccount myAccount = new BankAccount("Mark","001", "checking");
        myAccount.setAccountStatus("Open");
        myAccount.setCurrentBalance(150.00);
        myAccount.addDebitTransaction(100.00);
        double expectedValue = 250;
        double actualValue = myAccount.getCurrentBalance();
        assertEquals("Expected value = 100.00",expectedValue, actualValue, .0001);
    }

    @Test
    public void transferFundTest(){
        BankAccount first = new BankAccount("Mark","001", "checking");
        BankAccount second = new BankAccount("Mark","002", "savings");
        first.setCurrentBalance(150.00);
        second.setCurrentBalance(150.00);
        first.setAccountStatus("Open");
        second.setAccountStatus("Open");
        first.transferFunds(first, second, 50);
        double expectedValue1 = 100;
        double actualValue1 = first.getCurrentBalance();
        double expectedValue2 = 200;
        double actualValue2 = second.getCurrentBalance();
        assertEquals("Expected value = 200.00",expectedValue1, actualValue1, .0001);
        assertEquals("Expected value = 50.00",expectedValue2, actualValue2, .0001);

    }

}
