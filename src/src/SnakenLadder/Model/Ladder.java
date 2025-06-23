package SnakenLadder.Model;

public class Ladder {
    int startPos;
    int endPos;

    public Ladder(int startPos, int endPos){
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
