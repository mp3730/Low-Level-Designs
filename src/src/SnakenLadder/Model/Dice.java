package SnakenLadder.Model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;

    public Dice(int diceCount){
        this.diceCount = diceCount;
    }
    public int rollDice(){
        int totalSteps = 0;
        int dice = 0;

        //diceCount is the number of times the dice needs to be rolled for each player
        while(dice < diceCount){
            totalSteps += ThreadLocalRandom.current().nextInt(1,7); //to generate random number bw [1,7)
            dice++;
        }

        return totalSteps;
    }
}
