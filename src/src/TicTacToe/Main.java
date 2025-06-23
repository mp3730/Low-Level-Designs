package TicTacToe;

public class Main {
    public static void main(String args[]){
        TicTacToe.Game game = new TicTacToe.Game();
        game.initializeGame();
        System.out.println("The winner is : " + game.startGame());
    }
}
