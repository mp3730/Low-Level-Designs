package TrafficControlSystem.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TrafficLight {
    private int id;
    private Signal currentSignal;
    private int redTime;
    private int greenTime;
    private int yellowTime;

    public TrafficLight(int id, int redTime, int greenTime, int yellowTime) {
        this.id = id;
        this.redTime = redTime;
        this.greenTime = greenTime;
        this.yellowTime = yellowTime;
        this.currentSignal = Signal.RED;
    }

    public synchronized void changeCurrentSignal(Signal newSignal) {
        this.currentSignal = newSignal;
        notifyObservers();
    }

    public int getRedTime(){ return redTime; }
    public int getGreenTime(){ return greenTime; }
    public int getYellowTime(){ return yellowTime; }

    public void notifyObservers(){

    }
}
