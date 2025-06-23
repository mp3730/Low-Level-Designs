package BookMyShow.Model;

import java.util.ArrayList;
import java.util.List;

public class BookingDetails {
    ShowDetails show;
    List<Seat> bookedSeats = new ArrayList<>();
    Payment payment;

}
