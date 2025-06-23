package ParkingLot;

import ParkingLot.Model.Level;
import ParkingLot.Model.ParkingLot;
import ParkingLot.Model.Vehicle;
import ParkingLot.Model.Vehicles.Car;
import ParkingLot.Model.Vehicles.Motorcycle;

public class ParkingLotController {
    public static void run(){
        ParkingLot parkingLot = ParkingLot.getInstance();

        //Add levels to the parking lot
        parkingLot.addLevel(new Level(1,50));
        parkingLot.addLevel(new Level(2,30));

        //create vehicle objects to park
        Vehicle car = new Car("abc123");
        Vehicle motorCycle = new Motorcycle("xy89");

        //park the vehicles
        System.out.println(car.getVehicleType() + " with id: " + car.getLicensePlate() + " entered the lot!");
        parkingLot.parkVehicle(car);
        System.out.println(motorCycle.getVehicleType() + " with id: " + motorCycle.getLicensePlate() + " entered the lot!");
        parkingLot.parkVehicle(motorCycle);

        //display availability
        parkingLot.displayAvailability();

        //unpark the vehicle
        System.out.println(car.getVehicleType() + " with id: " + car.getLicensePlate() + " exiting the lot!");
        parkingLot.unparkVehicle(car);

        //display availability again
        parkingLot.displayAvailability();
    }
}
