package HotelManagementSystem;

import HotelManagementSystem.Model.*;
import HotelManagementSystem.Model.Payment.CreditCardPayment;
import HotelManagementSystem.Model.Payment.Payment;

import java.time.LocalDate;
import java.util.Date;

public class HotelManagementStarter {
    public void start(){
        HotelManagementController hotelSystem = HotelManagementController.getInstance();

        //create customers
        Customer customer1 = new Customer(1, "Mansi", "mansi@example.com", "123456");
        Customer customer2 = new Customer(2, "Shikha", "shikha@example.com", "123457");
        Customer customer3 = new Customer(3, "Isha", "isha@example.com", "123458");

        //create room objects in hotel
        Room room1 = new Room(101, 1000, RoomType.SINGLE);
        Room room2 = new Room(102, 2000, RoomType.DOUBLE);
        Room room3 = new Room(103, 5000, RoomType.DELUX);

        //add rooms to hotel
        hotelSystem.addRoom(room1);
        hotelSystem.addRoom(room2);
        hotelSystem.addRoom(room3);

        //Book a room
        LocalDate checkInDate = LocalDate.now();
        LocalDate checkOutDate = LocalDate.now().plusDays(3);

        BookingDetails bookingDetails = hotelSystem.bookRoom(customer1, room3, checkInDate, checkOutDate);
        if(bookingDetails != null) {
            System.out.println("Booking successful!");
            bookingDetails.displayDetails();
        }else{
            System.out.println("Booking failed. Room not available.");
        }



        //Check-in a customer
        hotelSystem.checkInCustomer(bookingDetails.getBookingId());
        System.out.println("Checked-in successfully - Booking ID: " + bookingDetails.getBookingId());

        //Check-out a customer
        CreditCardPayment payment = new CreditCardPayment();
        hotelSystem.checkOutCustomer(bookingDetails.getBookingId(), payment);
        System.out.println("Checked-out successfully - Booking ID: " + bookingDetails.getBookingId());

        //Cancel booking
        hotelSystem.cancelBooking(bookingDetails.getBookingId());
        System.out.println("Booking Cancelled - Booking ID: " + bookingDetails.getBookingId());
    }
}
