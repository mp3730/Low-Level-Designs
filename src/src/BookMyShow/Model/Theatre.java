package BookMyShow.Model;

import BookMyShow.Model.Enums.City;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    int theatreId;
    String address;
    City city;
    List<Screen> screens = new ArrayList<>();
    List<ShowDetails> showDetails = new ArrayList<>();

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setShowDetails(List<ShowDetails> showDetails) {
        this.showDetails = showDetails;
    }

    public List<ShowDetails> getShowDetails() {
        return showDetails;
    }
}
