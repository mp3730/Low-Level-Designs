package ATM.Model.ATMStates;

import ATM.Model.ATM;
import ATM.Model.Card;
import ATM.Model.CashWithdrawal.CashDispenser;
import ATM.Model.CashWithdrawal.FiveHundredNoteDispenser;
import ATM.Model.CashWithdrawal.OneHundredNoteDispenser;
import ATM.Model.CashWithdrawal.TwoThousandNoteDispenser;

public class CashWithdrawalState extends ATMState{

    public CashWithdrawalState(){
        System.out.println("Enter amount to withdraw: ");
    }

    @Override
    public void withdrawCash(ATM atm, Card card, int amount){
        if(card.getBankBalance() < amount) {
            System.out.println("Insufficient balance in Bank account!");
            exit(atm);
        }else if(atm.getAtmBalance() < amount){
            System.out.println("Insufficient balance in ATM!");
            exit(atm);
        }else{
            card.updateBalanceAfterWithdrawal(amount);
            atm.deductAtmBalance(amount);

            CashDispenser cashDispenser = new TwoThousandNoteDispenser(new FiveHundredNoteDispenser(new OneHundredNoteDispenser(null)));
            cashDispenser.dispenseCash(atm, amount);
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
