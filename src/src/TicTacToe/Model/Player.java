package TicTacToe.Model;

public class Player {
    public String name;
    public Piece piece;

    public Player(String playerName, Piece playingPiece){
        this.name = playerName;
        this.piece = playingPiece;
    }

    public String getName(){return this.name;}

    public void setName(String name){this.name = name;}

    public Piece getPiece(){return this.piece;}

    public void setPiece(Piece playingPiece){this.piece = playingPiece;}
}
