package SnakenLadder;

import SnakenLadder.Model.Board;
import SnakenLadder.Model.Cell;
import SnakenLadder.Model.Dice;
import SnakenLadder.Model.Player;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Deque<Player> playerList = new LinkedList<>(); //easier to use, pop from front and add to end
    Dice dice;
    Player winner;

    public Game(){
        initialize();
    }

    public void initialize(){
        board = new Board(10, 4, 5);
        dice = new Dice(2);
        addPlayers();
        winner = null;
    }

    public void startGame(){
        while(winner == null){

            //get the player whose turn it is
            Player current = findPlayer();
            System.out.println("Current player: " + current.getName() + " and it's current position: " + current.getCurrentPos());

            //roll the dice
            int steps = dice.rollDice();

            //for new position check if there is a ladder or a snake in that cell
            int newPosition = current.getCurrentPos() + steps;
            newPosition = checkJump(newPosition);
            current.setCurrentPos(newPosition);

            System.out.println("New position: " + newPosition);

            if(newPosition >= board.getSize()*board.getSize() - 1){
                winner = current;
            }
        }

        System.out.println("************* Winner is : " + winner.getName() + " *************");
    }

    public void addPlayers(){
        playerList.add(new Player("P1", 0));
        playerList.add(new Player("P2", 0));
        playerList.add(new Player("P3", 0));
    }

    public Player findPlayer(){
        Player player = playerList.getFirst();
        playerList.removeFirst();
        playerList.addLast(player);

        return player;
    }

    public int checkJump(int position){
        if(position > board.getSize()* board.getSize()-1){
            return position;
        }

        int positionAfterJump = position;
        Cell cell = board.getCellToBeUpdated(position);
        if(cell.getSnake() != null && position == cell.getSnake().getStartPos()){
            positionAfterJump = cell.getSnake().getEndPos();
            System.out.println("Snake present, jump from: " + position + " to: "+ positionAfterJump);
        }

        if(cell.getLadder() != null && position == cell.getLadder().getStartPos()){
            positionAfterJump = cell.getLadder().getEndPos();
            System.out.println("Ladder present, jump from: " + position + " to: "+ positionAfterJump);
        }

        return positionAfterJump;
    }
}
