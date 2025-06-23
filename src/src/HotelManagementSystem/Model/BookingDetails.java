package HotelManagementSystem.Model;

import HotelManagementSystem.Model.Payment.Payment;

import java.time.LocalDate;
import java.util.Date;

public class BookingDetails {
    private String bookingId;
    private Customer customer;
    private Room room;
    private final LocalDate checkInDate;
    private final LocalDate chaeckOutDate;
    private BookingStatus bookingStatus;

    public BookingDetails(String bookingId, Customer customer, Room room, LocalDate checkInDate, LocalDate chaeckOutDate) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.chaeckOutDate = chaeckOutDate;
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getChaeckOutDate() {
        return chaeckOutDate;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void cancelBooking(){
        if(bookingStatus == BookingStatus.CONFIRMED){
            bookingStatus = BookingStatus.CANCELLED;
        }else{
            throw new IllegalStateException("Reservation never confirmed!");
        }
    }

    public void displayDetails() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Room Number: " + room.getRoomId());
        System.out.println("Check-in Date: " + checkInDate);
        System.out.println("Check-out Date: " + chaeckOutDate);
        System.out.println("Booking Status: " + bookingStatus);
    }
}
