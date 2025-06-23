package HotelManagementSystem.Model;

public class Room {
    private int roomId;
    private double price;
    private RoomStatus roomStatus;
    private RoomType roomType;

    public Room(int roomId, double price, RoomType roomType) {
        this.roomId = roomId;
        this.price = price;
        this.roomStatus = RoomStatus.AVAILABLE;
        this.roomType = roomType;
    }

    public int getRoomId() {
        return roomId;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public void book(){
        if(roomStatus == RoomStatus.AVAILABLE) {
            roomStatus = RoomStatus.BOOKED;
        }else{
            System.out.println("Room is not available for booking!");
        }
    }

    public void checkIn(){
        if(roomStatus == RoomStatus.BOOKED){
            roomStatus = RoomStatus.OCCUPIED;
        }else{
            System.out.println("Room is not booked!");
        }
    }

    public void checkOut(){
        if(roomStatus == RoomStatus.OCCUPIED){
            roomStatus = RoomStatus.AVAILABLE;
        }else{
            System.out.println("Room is not occupied!");
        }
    }

    public void cancelBooking(){
        if(roomStatus == RoomStatus.BOOKED){
            roomStatus = RoomStatus.AVAILABLE;
        }else{
            System.out.println("Room is not booked!");
        }
    }
}
