package org.georgewave.model;

import java.util.LinkedList;

public class Sensor {

    private String sensorName;
    private final LinkedList<SensorData> sensorDataList = new LinkedList<>();
    private long signalStrengthThreshold;

    public static final long DEFAULT_THRESHOLD = 10;

    public Sensor() {
    }

    public Sensor(String sensorName) {
        this.sensorName = sensorName;
        calculateSensorSignalThreshold();
    }

    //cleanData method ensures that linked list of sensorData does not exceed the offset (in milliseconds) time.
    public void cleanData(final long offset) {

        if (sensorDataList.isEmpty()) return;

        long currentTimestamp = System.currentTimeMillis();
        long dataTimeStamp = sensorDataList.getFirst().getTimeStamp();

        //check if element is older than current time - offset time
        while(dataTimeStamp < (currentTimestamp - offset)){

            sensorDataList.removeFirst();
            dataTimeStamp = sensorDataList.getFirst().getTimeStamp();
        }
    }

    public void calculateSensorSignalThreshold(){
        //TODO: Write algorithm that calculates an accurate signal threshold
         signalStrengthThreshold = DEFAULT_THRESHOLD;
    }

    public void addMeasurement(SensorData sensorData){
        sensorDataList.add(sensorData);
    }

    public String getSensorName() {
        return sensorName;
    }

    public LinkedList<SensorData> getSensorDataList() {
        return sensorDataList;
    }

    public long getSignalStrengthThreshold() {
        return signalStrengthThreshold;
    }

}
