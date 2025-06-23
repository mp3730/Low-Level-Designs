package TrafficControlSystem.Model;

public class Road {
    private int roadId;
    private String roadName;
    private TrafficLight trafficLight;

    public Road(int roadId, String roadName) {
        this.roadId = roadId;
        this.roadName = roadName;
    }

    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public int getRoadId() {
        return roadId;
    }

    public String getRoadName() {
        return roadName;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }
}
