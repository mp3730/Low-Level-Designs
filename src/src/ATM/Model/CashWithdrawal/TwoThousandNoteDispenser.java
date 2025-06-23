package ATM.Model.CashWithdrawal;

import ATM.Model.ATM;

public class TwoThousandNoteDispenser extends CashDispenser{

    public TwoThousandNoteDispenser(CashDispenser nextCashDispenser) {
        super(nextCashDispenser);
    }

    @Override
    public void dispenseCash(ATM atm, int amount) {
        int notes = amount/2000;
        int remaining = amount%2000;

        if(notes <= atm.getTotalTwoThousandNotes()){
            atm.deductTwoThousandNotes(notes);
        }else if(notes > atm.getTotalTwoThousandNotes()){
            atm.deductTwoThousandNotes(atm.getTotalTwoThousandNotes());
            remaining = remaining + (notes - atm.getTotalTwoThousandNotes())*2000;
        }

        if(remaining > 0){
            super.dispenseCash(atm, remaining);
        }
    }
}
