package ParkingLot.Model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private List<Level> listOfLevels;

    private ParkingLot(){
        this.listOfLevels = new ArrayList<>();
    }

    //to maintain only one instance of ParkingLot class - Singleton design pattern
    public static ParkingLot getInstance(){
        if(instance == null){
            return new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level){
        listOfLevels.add(level);
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        //try in each level if there is space to park
        for(Level level : listOfLevels){
            if(level.parkTheVehicle(vehicle)){
                System.out.println("Vehicle parked successfully :)");
                return true;
            }
        }
        System.out.println("Vehicle couldn't be parked :(");
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle){
        //try in each level and unpark the vehicle wherever present
        for(Level level : listOfLevels){
            if(level.unParkTheVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        //display the spots with availability for each floor
        for(Level level : listOfLevels){
            level.displayAvailability();
        }
    }
}
