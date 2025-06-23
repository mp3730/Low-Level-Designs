package HotelManagementSystem.Model;

import HotelManagementSystem.Model.Payment.Payment;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HotelManagementController {
    private static HotelManagementController instance;
    private Map<String, BookingDetails> bookingsList;
    private Map<Integer, Room> rooms;
    private Map<Integer, Customer> customers;

    public HotelManagementController(){
        bookingsList = new ConcurrentHashMap<>();
        rooms = new ConcurrentHashMap<>();
        customers = new ConcurrentHashMap<>();
    }

    public static HotelManagementController getInstance(){
        if(instance == null){
            return new HotelManagementController();
        }
        return instance;
    }

    public void addCustomer(Customer customer){
        customers.put(customer.getCustomerId(), customer);
    }

    public void addRoom(Room room){
        rooms.put(room.getRoomId(), room);
    }

    public BookingDetails bookRoom(Customer customer, Room room, LocalDate checkInDate, LocalDate checkOutDate){
        if(room.getRoomStatus() == RoomStatus.AVAILABLE){
            room.book();
            String bookingId = "Booking" + UUID.randomUUID().toString();
            BookingDetails bookingDetails = new BookingDetails(bookingId, customer, room, checkInDate, checkOutDate);
            bookingsList.put(bookingId, bookingDetails);
            return bookingDetails;
        }
        return null;
    }

    public synchronized void checkInCustomer(String bookingId){
        BookingDetails booking = bookingsList.get(bookingId);
        if(booking != null && booking.getBookingStatus() == BookingStatus.CONFIRMED){
            booking.getRoom().checkIn();
        }else{
            throw new IllegalStateException("Invalid check-in or reservation not confirmed!");
        }
    }

    public void displayBookingDetails(String bookingId){
        BookingDetails booking = bookingsList.get(bookingId);
        booking.displayDetails();
    }

    public synchronized void checkOutCustomer(String bookingId, Payment payment){
        BookingDetails booking = bookingsList.get(bookingId);
        if(booking != null && booking.getBookingStatus() == BookingStatus.CONFIRMED){
            Room room = booking.getRoom();
            double amount = calculateAmountToPay(room, booking);

            if(payment.completePayment(amount)){
                room.checkOut();
                bookingsList.remove(bookingId);
            }else{
                throw new IllegalStateException("Payment failed!");
            }
        }else{
            throw new IllegalStateException("Invalid check-out or reservation not confirmed!");
        }
    }

    public void cancelBooking(String bookingId){
        BookingDetails booking = bookingsList.get(bookingId);
        if(booking != null && booking.getBookingStatus() == BookingStatus.CONFIRMED){
            booking.getRoom().cancelBooking();
            booking.cancelBooking();
            bookingsList.remove(bookingId);
        }else{
            throw new IllegalStateException("Invalid cancel operation or reservation never created!");
        }
    }

    public double calculateAmountToPay(Room room, BookingDetails booking){
        int days = (int)ChronoUnit.DAYS.between(booking.getCheckInDate(), booking.getChaeckOutDate());
        return room.getPrice() * days;
    }

}
