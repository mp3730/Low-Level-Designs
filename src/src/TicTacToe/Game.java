package TicTacToe;

import TicTacToe.Model.*;

import java.util.*;
import javafx.util.Pair;

public class Game {
    Board board;
    Deque<Player> players; //taking deque so we can remove from front and add player at end

    public void initializeGame(){
        players = new LinkedList<>();

        PlayingPieceX cross = new PlayingPieceX();
        Player player1 = new Player("Player1", cross);

        PlayingPieceO circle = new PlayingPieceO();
        Player player2 = new Player("Player2", circle);

        players.add(player1);
        players.add(player2);

        board = new Board(3);
    }

    public String startGame(){

        boolean isWinnerDecided = false;
        while(!isWinnerDecided){
            
            Player currentPlayer = players.removeFirst();
            board.printBoard();
            
            //check if there is no empty cell then come out of loop
            List<Pair<Integer,Integer>>freeCells = board.getEmptyCells();
            if(freeCells.isEmpty()){
                isWinnerDecided = true;
                continue;
            }
            
            //get the input from user/player for the position of piece
            System.out.println("Player: " + currentPlayer.getName() + ", Enter the row, col: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputCol = Integer.valueOf(values[1]);
            
            //placing the piece
            boolean isSuccessfullyPlaced = board.addPiece(inputRow,inputCol,currentPlayer.piece);
            
            if(!isSuccessfullyPlaced){
                System.out.println("Incorrect position, Please try again!");
                players.addFirst(currentPlayer);
                continue;
            }else{
                players.addLast(currentPlayer);
            }
            
            //check if the winner is there
            boolean winner = isThereWinner(inputRow, inputCol, currentPlayer.piece.type);
            if(winner)return currentPlayer.getName();
        }

        return "tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<board.size;i++) {
            if(board.board[row][i] == null || board.board[row][i].type != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<board.size;i++) {
            if(board.board[i][column] == null || board.board[i][column].type != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<board.size;i++,j++) {
            if (board.board[i][j] == null || board.board[i][j].type != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=board.size-1; i<board.size;i++,j--) {
            if (board.board[i][j] == null || board.board[i][j].type != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
