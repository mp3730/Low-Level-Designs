package ATM.Model;

import java.util.Date;

public class Card {
    private int cardNumber;
    private int cvv;
    private Date expiryDate;
    private int holderName;
    private BankAccount bankAccount;

    private static int PIN_NUMBER = 1234;

    public boolean isValidPIN(int pin){
        return pin == PIN_NUMBER;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public double getBankBalance(){
        return bankAccount.getBalance();
    }

    public void updateBalanceAfterWithdrawal(double amount){
        bankAccount.setBalance(getBankBalance() - amount);
    }
}
