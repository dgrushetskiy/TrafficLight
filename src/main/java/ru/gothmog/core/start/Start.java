package ru.gothmog.core.start;

import ru.gothmog.core.interfaces.Light;
import ru.gothmog.core.interfaces.TrafficLight;
import ru.gothmog.core.model.TrafficLightImpl;

/**
 * @author gothmog on 14.07.2017.
 */
public class Start {
    public static void main(String[] args) {
//        TrafficLight trafficLight = new TrafficLightImpl();
//        trafficLight.drawColorByMinute();
        Light trafficLight = new TrafficLightImpl();
        trafficLight.drawColorByMinuteTwo();
    }
}
