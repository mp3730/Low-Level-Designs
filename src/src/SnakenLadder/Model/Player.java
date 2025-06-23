package SnakenLadder.Model;

public class Player {
    String name;
    int currentPos;

    public Player(String name, int position){
        this.name = name;
        this.currentPos = position;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }
}
