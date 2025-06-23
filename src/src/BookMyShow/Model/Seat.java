package BookMyShow.Model;

import BookMyShow.Model.Enums.*;

public class Seat {
    int seatNumber;
    int row;
    SeatType seatType;

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
