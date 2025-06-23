package ATM.Model.CashWithdrawal;

import ATM.Model.ATM;

public abstract class CashDispenser {

    CashDispenser nextCashDispenser;

    public CashDispenser(CashDispenser nextCashDispenser){
        this.nextCashDispenser = nextCashDispenser;
    }
    public void dispenseCash(ATM atm, int amount){
        if(nextCashDispenser!=null){
            nextCashDispenser.dispenseCash(atm, amount);
        }
    };
}
