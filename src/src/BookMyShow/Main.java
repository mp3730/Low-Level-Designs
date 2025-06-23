package BookMyShow;

import BookMyShow.Model.Enums.City;

public class Main {
    public static void main(String args[]){
        Booking booking = new Booking();
        booking.initialise();

        booking.startBooking(City.Chennai, "AMARAN");
        booking.startBooking(City.Bangalore, "BARFI");
    }
}
