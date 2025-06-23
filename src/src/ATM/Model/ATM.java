package ATM.Model;

import ATM.Model.ATMStates.ATMState;

public class ATM {
    private static ATM atmObject = new ATM(); //singleton pattern
    ATMState currentAatmState;

    private int atmBalance;
    int totalTwoThousandNotes;
    int totalFiveHundredNotes;
    int totalOneHundredNotes;

    private ATM() {
    }

    public static ATM getAtmObject(){
        if(atmObject == null){
            atmObject = new ATM();
        }
        return atmObject;
    }

    public void setCurrentState(ATMState atmState){
        this.currentAatmState = atmState;
    }

    public void setAtmBalance(int amount, int twoThousand, int fiveHundred, int oneHundred){
        this.atmBalance = amount;
        this.totalTwoThousandNotes = twoThousand;
        this.totalFiveHundredNotes = fiveHundred;
        this.totalOneHundredNotes = oneHundred;
    }

    public ATMState getAtmState(){
        return currentAatmState;
    }

    public int getAtmBalance(){
        return atmBalance;
    }

    public void deductAtmBalance(int amount){
        atmBalance = atmBalance - amount;
    }

    public int getTotalTwoThousandNotes() {return totalTwoThousandNotes;}
    public int getTotalFiveHundredNotes() {return totalFiveHundredNotes;}
    public int getTotalOneHundredNotes() {return totalOneHundredNotes;}

    public void deductTwoThousandNotes(int cnt) {totalTwoThousandNotes = totalTwoThousandNotes - cnt;}
    public void deductFiveHundredNotes(int cnt) {totalFiveHundredNotes = totalFiveHundredNotes - cnt;}
    public void deductOneHundredNotes(int cnt) {totalOneHundredNotes = totalOneHundredNotes - cnt;}

    public void displayATMStatus(){
        System.out.println("Total amount: " + atmBalance);
        System.out.println("Total 2000 notes: " + totalTwoThousandNotes);
        System.out.println("Total 500 notes: " + totalFiveHundredNotes);
        System.out.println("Total 100 notes: " + totalOneHundredNotes);
    }
}
