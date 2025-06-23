package ParkingLot.Model;

public class ParkingSpot {
    private final int spotId;
    private Vehicle vehicle;
    private VehicleType vehicleType;
    private boolean isAvailable;

    ParkingSpot(int spotId, VehicleType vehicleType){
        this.spotId = spotId;
        this.vehicleType = vehicleType;
        this.isAvailable = true; //at start the spot will be available
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        if(isAvailable() && vehicleType == vehicle.getVehicleType()){
            this.vehicle =  vehicle;
            isAvailable = false;
        }else{
            throw new IllegalArgumentException("The spot is not available or invalid vehicle type!!");
        }
    }

    public synchronized void unparkVehicle(Vehicle vehicle){
        if(!isAvailable() &&  vehicle == getVehicle()){
            this.vehicle =  null;
            isAvailable = false;
        }
    }

    public int getSpotId() {
        return spotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
