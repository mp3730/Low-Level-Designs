package SnakenLadder.Model;

public class Snake {
    int startPos;
    int endPos;

    public Snake(int startPos, int endPos){
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public int getStartPos() {
        return startPos;
    }

    public int getEndPos() {
        return endPos;
    }
}
