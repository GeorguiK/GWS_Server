package org.georgewave.model;

import java.util.LinkedList;

public class Sensor {

    private String sensorName;
    private LinkedList<SensorData> sensorDataList = new LinkedList<>();
    private long signalStrengthThreshold;

    public Sensor() {
    }

    public Sensor(String sensorName) {
        this.sensorName = sensorName;
    }

    //cleanData method ensures that linked list of sensorData does not exceed the offset (in milliseconds) time.
    public void cleanData(final long offset) {

        if (sensorDataList == null || sensorDataList.isEmpty()) return;

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
         signalStrengthThreshold = 70;
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
