package ATM;

import ATM.Model.*;
import ATM.Model.ATMStates.IdleState;

import java.util.Date;

public class ATMController {
    ATM atm;
    User user;

    public void initialise(){
        atm = ATM.getAtmObject();
        atm.setAtmBalance(4000,1,2,10);
        atm.setCurrentState(new IdleState());

        user = createUser();
    }

    public User createUser(){
        BankAccount bankAccount = new BankAccount(123, 2500);
        Card card = createCard(bankAccount);
        return new User(bankAccount, card);
    }

    public Card createCard(BankAccount bankAccount){
        Card card = new Card();
        card.setBankAccount(bankAccount);
        return card;
    }

    public void performOperations(){

//        Cash Withdrawal steps-------------------------------
        atm.displayATMStatus();
        atm.getAtmState().insertCard(atm, user.getCard()); //State 1
        atm.getAtmState().authenticateUser(atm, user.getCard(), 1234); //State 2
        atm.getAtmState().selectOperation(atm, user.getCard(), TransactionType.WITHDRAWAL); //State 3
        atm.getAtmState().withdrawCash(atm, user.getCard(), 1000); //State 4
        atm.displayATMStatus();


//        Balance Inquiry steps--------------------------------
//        atm.displayATMStatus();
//        atm.getAtmState().insertCard(atm, user.getCard()); //State 1
//        atm.getAtmState().authenticateUser(atm, user.getCard(), 1234); //State 2
//        atm.getAtmState().selectOperation(atm, user.getCard(), TransactionType.BALANCE_INQUIRY); //State 3
//        atm.getAtmState().checkBalance(atm, user.getCard()); //State 4
//        atm.displayATMStatus();
    }
}
