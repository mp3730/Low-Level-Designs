package TrafficControlSystem;

import TrafficControlSystem.Model.Road;
import TrafficControlSystem.Model.TrafficController;
import TrafficControlSystem.Model.TrafficLight;

public class TrafficSystemDemo {
    public void startSystem(){
        TrafficController trafficController = TrafficController.getInstance();

        //Create roads
        Road road1 = new Road(1, "Airport Road");
        Road road2 = new Road(2, "200ft Radial Road");
        Road road3 = new Road(3, "Chromepet Road");
        Road road4 = new Road(4, "Tambaram Road");

        //Create Traffic lights for each road - with time in milliseconds
        TrafficLight light1 = new TrafficLight(1,4000,7000,2000);
        TrafficLight light2 = new TrafficLight(2,4000,7000,2000);
        TrafficLight light3 = new TrafficLight(3,7000,5000,2000);
        TrafficLight light4 = new TrafficLight(4,7000,4000,1000);

        //assign traffic lights to each road
        road1.setTrafficLight(light1);
        road2.setTrafficLight(light2);
        road3.setTrafficLight(light3);
        road4.setTrafficLight(light4);

        //adding roads to be controlled
        trafficController.addRoad(road1);
        trafficController.addRoad(road2);
        trafficController.addRoad(road3);
        trafficController.addRoad(road4);

        //start the control system
        trafficController.startTrafficControl();

        //handle emergency case later....

    }
}
