package ATM.Model.CashWithdrawal;

import ATM.Model.ATM;

public class OneHundredNoteDispenser extends CashDispenser{

    public OneHundredNoteDispenser(CashDispenser nextCashDispenser) {
        super(nextCashDispenser);
    }

    @Override
    public void dispenseCash(ATM atm, int amount) {
        int notes = amount/100;
        int remaining = amount%100;

        if(notes <= atm.getTotalOneHundredNotes()){
            atm.deductOneHundredNotes(notes);
        }else if(notes > atm.getTotalOneHundredNotes()){
            atm.deductOneHundredNotes(atm.getTotalOneHundredNotes());
            remaining = remaining + (notes - atm.getTotalOneHundredNotes())*2000;
        }

        if(remaining > 0){
            super.dispenseCash(atm, remaining);
        }
    }
}
