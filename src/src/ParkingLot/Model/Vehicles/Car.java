package ParkingLot.Model.Vehicles;

import ParkingLot.Model.Vehicle;
import ParkingLot.Model.VehicleType;

public class Car extends Vehicle {
    public Car(String licensePlate){
        super(licensePlate, VehicleType.CAR);
    }
}
