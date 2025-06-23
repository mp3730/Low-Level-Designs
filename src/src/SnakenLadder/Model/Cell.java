package SnakenLadder.Model;

import java.util.List;

public class Cell {
    Snake snake;
    Ladder ladder;

    public Cell(){
        this.snake = null;
        this.ladder = null;
    }

    public Snake getSnake() {
        return snake;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
