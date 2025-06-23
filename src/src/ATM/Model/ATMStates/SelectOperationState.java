package ATM.Model.ATMStates;

import ATM.Model.ATM;
import ATM.Model.Card;
import ATM.Model.TransactionType;

public class SelectOperationState extends ATMState{

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType transactionType){

        switch(transactionType){
            case BALANCE_INQUIRY:
                atm.setCurrentState(new BalanceInquiryState());
                break;
            case WITHDRAWAL:
                atm.setCurrentState(new CashWithdrawalState());
                break;
            case DEPOSIT:
                atm.setCurrentState(new CashDepositState());
                break;
            default:
                System.out.println("Invalid operation type!");
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

    public void displayOperations(){
        System.out.println("Select the operation to perform:");
        for(TransactionType t : TransactionType.values()){
            System.out.println(t.ordinal() + ". " + t.name());
        }
    }
}
