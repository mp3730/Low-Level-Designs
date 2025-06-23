package ATM.Model.ATMStates;

import ATM.Model.ATM;
import ATM.Model.Card;

public class IdleState extends ATMState{

    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("Card Inserted!");
        atm.setCurrentState(new WithCardState());
    }
}
