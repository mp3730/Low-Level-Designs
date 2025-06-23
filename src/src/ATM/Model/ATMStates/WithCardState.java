package ATM.Model.ATMStates;

import ATM.Model.ATM;
import ATM.Model.Card;

public class WithCardState extends ATMState{

    @Override
    public void authenticateUser(ATM atm, Card card, int pin){
        if(card.isValidPIN(pin)){
            atm.setCurrentState(new SelectOperationState());
        }else{
            System.out.println("Invalid PIN. Please try again.");
            exit(atm);
        }
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
