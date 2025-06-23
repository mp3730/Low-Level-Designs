package ParkingLot.Model;

import java.util.ArrayList;
import java.util.List;

//floor in parking lot
public class Level {
    private final int floorId;
    List<ParkingSpot> parkingSpotList;

    public Level(int floorId, int totalSpots){
        this.floorId = floorId;
        this.parkingSpotList = new ArrayList<>(totalSpots);

        //assign the types of vehicle to spots
        //Let's say we divide it in ratio Car : Motorcycle : Truck as 50% : 40% : 10%

        int carSpots = (int) (totalSpots * 0.5);
        int bikeSpots = (int) (totalSpots * 0.4);

        //first assign cartype
        for(int i=0;i<carSpots;i++){
            ParkingSpot spot = new ParkingSpot(i,VehicleType.CAR);
            parkingSpotList.add(i, spot);
        }
        //motorcycle type
        for(int i=carSpots;i<bikeSpots + carSpots;i++){
            ParkingSpot spot = new ParkingSpot(i,VehicleType.MOTORCYCLE);
            parkingSpotList.add(i, spot);
        }
        //truck
        for(int i=carSpots+bikeSpots; i<totalSpots; i++){
            ParkingSpot spot = new ParkingSpot(i,VehicleType.TRUCK);
            parkingSpotList.add(i, spot);
        }
    }

    public synchronized boolean parkTheVehicle(Vehicle vehicle){
        for(ParkingSpot ps : parkingSpotList){
            if(ps.isAvailable() && vehicle.getVehicleType() == ps.getVehicleType()){
                ps.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unParkTheVehicle(Vehicle vehicle){
        for(ParkingSpot ps : parkingSpotList){
            if(!ps.isAvailable() &&  ps.getVehicle().equals(vehicle)){
                ps.unparkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        System.out.println("Level " + floorId + " Availability:");
        for(ParkingSpot ps : parkingSpotList){
            System.out.println("Spot: " + ps.getSpotId() + (ps.isAvailable()?" Available for " : " Occupied by ") + ps.getVehicleType());
        }
    }
}
