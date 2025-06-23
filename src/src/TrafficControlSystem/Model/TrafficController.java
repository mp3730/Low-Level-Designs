package TrafficControlSystem.Model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TrafficController {
    private static TrafficController instance;
    private Map<Integer, Road> roadMap;
    private Queue<Road> roadQueue;

    public TrafficController(){
        roadMap = new HashMap<>();
        roadQueue = new LinkedList<>();
    }

    //singleton
    public static TrafficController getInstance() {
        if (instance == null) {
            instance = new TrafficController();
        }
        return instance;
    }

    public void addRoad(Road road) {
        roadMap.put(road.getRoadId(), road);
        roadQueue.add(road);
    }

    public void removeRoad(int roadId) {
        Road removable = roadMap.get(roadId);
        roadMap.remove(roadId);
        roadQueue.remove(removable);
    }

    public void startTrafficControl(){
        //controlling the roads in circular way one by one
        //considering the system is made for one intersection

        new Thread(() -> {
            while(true){ //the system keeps on running indefinitely till stopped externally
                Road currentRoad = roadQueue.poll(); //get the road from queue
                if(currentRoad != null){
                    TrafficLight trafficLight = currentRoad.getTrafficLight();

                    try{
                        trafficLight.changeCurrentSignal(Signal.GREEN);
                        System.out.println("Road " + currentRoad.getRoadName() + " : GREEN");
                        Thread.sleep(trafficLight.getGreenTime());

                        trafficLight.changeCurrentSignal(Signal.YELLOW);
                        System.out.println("Road " + currentRoad.getRoadName() + " : YELLOW");
                        Thread.sleep(trafficLight.getYellowTime());

                        trafficLight.changeCurrentSignal(Signal.RED);
                        System.out.println("Road " + currentRoad.getRoadName() + " : RED");
                        Thread.sleep(trafficLight.getRedTime());

                        //after one road completed - add it back to queue
                        roadQueue.add(currentRoad);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }).start();
    }
}
