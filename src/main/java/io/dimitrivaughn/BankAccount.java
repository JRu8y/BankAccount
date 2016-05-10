package io.dimitrivaughn;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by dimitrivaughn on 5/2/16.
 */
public class BankAccount {

    /**
     * Declare variables/fields
     */
    private String accountName;
    private String accountNumber;
    private String accountType;
    private String accountStatus;
    private String overdraftPrevention;
    private double currentBalance;
    private double interestRate;


    /**
     * Creation of constructor
     */

    public BankAccount(String accountName, String accountNumber, String accountType){
    this.accountName = accountName;
    this.accountNumber = accountNumber;
    this.accountType = accountType;
    }

    /**
     * Creation of setters for account information
     */

    public void setAccountName(String accountName){
        if(checkAccountClosed()){
            System.out.println("This transaction could not be processed. Please check your account status.");
        }
        this.accountName = accountName;
    }

    public void setAccountStatus(String accountStatus){
        if(checkAccountClosed()){
            System.out.println("This transaction could not be processed. Please check your account status.");
        }
        this.accountStatus = accountStatus;
    }

    public void setOverdraftPrevention(String overdraftPrevention){
        this.overdraftPrevention = overdraftPrevention;
    }

    public void setCurrentBalance(double currentBalance){
        this.currentBalance = currentBalance;
    }

    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    public void setToClosedAccount(){
        if(this.getCurrentBalance()== 0)
        this.accountStatus = "Closed";
    }

    /**
     * Creation of a getter to access current balance
     */

    public double getCurrentBalance(){
        if(!checkAccountOpen()){
            System.out.println("This transaction could not be processed. Please check your account status.");
        }
        System.out.println("Your current balance is: $"+currentBalance);
        return currentBalance;
    }

    /**
     * Creation of a getter to check account status
     */

    public boolean checkAccountClosed() {
       return this.accountStatus == "Closed";
    }
    public boolean checkAccountFrozen() {
        return this.accountStatus == "Frozen";
    }
    public boolean checkAccountOpen() {
        return this.accountStatus == "Open";
    }

    /**
     * Creation of a getter to compare account owner
     */

    public boolean isSameAccount(BankAccount account1, BankAccount account2){
        return account1.accountName == account2.accountName;
    }


    /**
     * Creation of add and subtract methods for account transactions
     */

    public void subtractCreditTransaction(double withdrawAmount){
        if(!checkAccountOpen()){
            System.out.println("Your credit transaction in the amount of -$" + withdrawAmount +" has been declined");
        }
        else {
            this.currentBalance = this.currentBalance - withdrawAmount;
            if(this.currentBalance<0){
                System.out.println("Appropriate funds not found. Please check your current balance.");
                this.currentBalance = this.currentBalance + withdrawAmount;
            }
            else {
                System.out.println("Your credit transaction has been approved!");
                System.out.println("Your current balance is: $" + currentBalance);
            }
        }

    }

    public void addDebitTransaction(double depositAmount){
        if(!checkAccountOpen()){
            System.out.println("Your debit transaction in the amount of +$" + depositAmount +" has been declined");
        }
        this.currentBalance = this.currentBalance + depositAmount;
        System.out.println("Your debit transaction has been approved!");
        System.out.println("Your current balance is: $" + currentBalance);
    }

    /**
     *Building the transfer fund method
     */



    public void transferFunds(BankAccount account1, BankAccount account2, double amount){
        if(account1.checkAccountOpen()&&account2.checkAccountOpen()){
            if((account1.getCurrentBalance()-amount)>0) {
                if (isSameAccount(account1, account2)) {
                    account1.subtractCreditTransaction(amount);
                    account2.addDebitTransaction(amount);
                } else {
                    System.out.println("This transaction could not be processed. Account owners are not the same.");
                }
            }
            else {
                System.out.println("Appropriate funds not found. Please check your current balance.");
        }


        }
    }

}
