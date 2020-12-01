package org.georgewave.model;

import java.util.Objects;

public class SensorData {

    private Long id;
    private String sensorName;
    private Double sensorValue;

    public SensorData() {
    }

    public SensorData(String sensorName, Double sensorValue) {
        this.sensorName = sensorName;
        this.sensorValue = sensorValue;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public Double getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(Double sensorValue) {
        this.sensorValue = sensorValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorData that = (SensorData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(sensorName, that.sensorName) &&
                Objects.equals(sensorValue, that.sensorValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sensorName, sensorValue);
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "id=" + id +
                ", sensorName='" + sensorName + '\'' +
                ", sensorValue=" + sensorValue +
                '}';
    }
}
