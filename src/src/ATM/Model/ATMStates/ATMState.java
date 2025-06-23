package ATM.Model.ATMStates;

import ATM.Model.ATM;
import ATM.Model.BankAccount;
import ATM.Model.Card;
import ATM.Model.TransactionType;

public abstract class ATMState{

    public void insertCard(ATM atm, Card card){System.out.println("Card Inserted!");}

    public void authenticateUser(ATM atm, Card card, int pin){System.out.println("Authenticating User...");}

    public void checkBalance(ATM atm, Card card){System.out.println("Checking Balance...");}

    public void selectOperation(ATM atm, Card card, TransactionType transactionType){System.out.println("Enter transaction type");}

    public void withdrawCash(ATM atm, Card card, int amount){System.out.println("Withdrawing cash...");}

    public void depositCash(ATM atm, Card card, double amount){System.out.println("Depositing cash...");}

    public void returnCard(){System.out.println("Card Returned. Something went wrong!");}

    public void exit(ATM atm){System.out.println("Exit ATM");}
}
