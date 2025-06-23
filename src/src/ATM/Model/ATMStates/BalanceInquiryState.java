package ATM.Model.ATMStates;

import ATM.Model.ATM;
import ATM.Model.Card;

public class BalanceInquiryState extends ATMState{

    @Override
    public void checkBalance(ATM atm, Card card){
        System.out.println("Account Balance is : " + card.getBankBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atm){
        returnCard();
        System.out.println("Exited the session!");
        atm.setCurrentState(new IdleState());
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card.");
    }
}
