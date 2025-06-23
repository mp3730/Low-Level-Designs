package TicTacToe.Model;


import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class Board {
    public int size;
    public Piece[][] board;

    public Board(int size){
        this.size = size;
        this.board = new Piece[size][size];
    }

    //what functionalities can be performed on board
    //1. adding a piece
    //2. checking for the empty cells in board
    //3. print the board

    public boolean addPiece(int x,int y, Piece playingPiece){
        if(board[x][y]!=null)return false; // to check if the space is empty, then only put the piece

        board[x][y] = playingPiece;
        return true;
    }

    public List<Pair<Integer, Integer>> getEmptyCells(){
        List<Pair<Integer, Integer>>emptyCells = new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] == null){
                    emptyCells.add(new Pair<>(i,j));
                }
            }
        }
        return emptyCells;
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]!=null)
                    System.out.print(board[i][j].type.name() + " ");
                else
                    System.out.print("  ");

                System.out.print("|");
            }
            System.out.println(); //new line
        }
    }
}
