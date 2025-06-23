package BookMyShow.Model;

import java.util.ArrayList;
import java.util.List;

public class ShowDetails {
    int showId;
    Movie movieName;
    int time;
    Screen screen;
    List<Integer> bookedSeats = new ArrayList<>();

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getShowId() {
        return showId;
    }

    public void setMovieName(Movie movieName) {
        this.movieName = movieName;
    }

    public Movie getMovieName() {
        return movieName;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setBookedSeats(List<Integer> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }
}
