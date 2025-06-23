package SnakenLadder.Model;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    int size;
    int noOfSnakes;
    int noOfLadders;
    Cell[][] cells;

    public Board(int size, int snakes, int ladders){
        this.size = size;
        this.noOfLadders = ladders;
        this.noOfSnakes = snakes;

        initializeBoard(size);
        addSnakes(cells, snakes);
        addLadders(cells, ladders);
    }

    public void initializeBoard(int size){
        cells = new Cell[size][size]; //this creates Board Cells with each cell value as NULL

        //this is to create Cell instance for each of the cell
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                cells[i][j] = new Cell();
            }
        }
    }

    public void addSnakes(Cell[][] cells, int noOfSnakes){
        while(noOfSnakes > 0){
            int start = ThreadLocalRandom.current().nextInt(0, size*size); //snake head
            int end = ThreadLocalRandom.current().nextInt(0, size*size); //snake tail

            //for snakes start should be greater than end
            if(start <= end)continue;

            Snake obj = new Snake(start, end);

            Cell updateCell = getCellToBeUpdated(start);
            updateCell.snake = obj;

            noOfSnakes--;
        }
    }

    public void addLadders(Cell[][] cells, int noOfLadders){
        while(noOfLadders > 0){
            int start = ThreadLocalRandom.current().nextInt(0, size*size); //snake head
            int end = ThreadLocalRandom.current().nextInt(0, size*size); //snake tail

            //for ladders start should be lesser than end
            if(start >= end)continue;

            Ladder obj = new Ladder(start, end);

            Cell updateCell = getCellToBeUpdated(start);

            //update ladder only if it is not assigned to snake
            if(updateCell.snake == null) {
                updateCell.ladder = obj;
                noOfLadders--;
            }
        }
    }

    public Cell getCellToBeUpdated(int position){
        int row = position/size;
        int col = position%size;
        return cells[row][col];
    }

    public int getSize() {
        return size;
    }
}
