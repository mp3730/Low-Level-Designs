package ParkingLot.Model.Vehicles;

import ParkingLot.Model.Vehicle;
import ParkingLot.Model.VehicleType;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate){
        super(licensePlate, VehicleType.MOTORCYCLE);
    }
}
