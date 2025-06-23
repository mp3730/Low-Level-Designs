package ATM.Model.CashWithdrawal;

import ATM.Model.ATM;

public class FiveHundredNoteDispenser extends CashDispenser{

    public FiveHundredNoteDispenser(CashDispenser nextCashDispenser) {
        super(nextCashDispenser);
    }

    @Override
    public void dispenseCash(ATM atm, int amount) {
        int notes = amount/500;
        int remaining = amount%500;

        if(notes <= atm.getTotalFiveHundredNotes()){
            atm.deductFiveHundredNotes(notes);
        }else if(notes > atm.getTotalFiveHundredNotes()){
            atm.deductFiveHundredNotes(atm.getTotalFiveHundredNotes());
            remaining = remaining + (notes - atm.getTotalFiveHundredNotes())*2000;
        }

        if(remaining > 0){
            super.dispenseCash(atm, remaining);
        }
    }
}
