package ParkingLot.Model;

public abstract class Vehicle {
    private String licensePlate;
    private VehicleType vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType){
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
