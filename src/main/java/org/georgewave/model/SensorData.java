package org.georgewave.model;

import java.util.Objects;

public class SensorData {

    private Long timeStamp;
    private String sensorName;
    private long sensorValue;

    public SensorData() {
    }

    public SensorData(String sensorName, long sensorValue) {
        this.sensorName = sensorName;
        this.sensorValue = sensorValue;
    }

    public SensorData(String sensorName, long sensorValue, Long timeStamp){
        this.sensorName = sensorName;
        this.sensorValue = sensorValue;
        this.timeStamp = timeStamp;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public long getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(long sensorValue) {
        this.sensorValue = sensorValue;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorData that = (SensorData) o;
        return Objects.equals(timeStamp, that.timeStamp) &&
                Objects.equals(sensorName, that.sensorName) &&
                Objects.equals(sensorValue, that.sensorValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeStamp, sensorName, sensorValue);
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "id=" + timeStamp +
                ", sensorName='" + sensorName + '\'' +
                ", sensorValue=" + sensorValue +
                '}';
    }
}
