package BookMyShow.Model;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    int screenNumber;
    ShowDetails showDetails;
    List<Seat> seatList = new ArrayList<>();

    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public void setShowDetails(ShowDetails showDetails) {
        this.showDetails = showDetails;
    }

    public ShowDetails getShowDetails() {
        return showDetails;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }
}
