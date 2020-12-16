package org.georgewave.service;

import org.georgewave.model.Sensor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.georgewave.model.SensorData;

@Service
public class SignalService {

    private Map<String, Sensor> data;

    @PostConstruct
    public void init() {
        data = new ConcurrentHashMap<>();
    }


    public void addMeasurement(SensorData sensorData) {

        //TODO - validate input data

        sensorData.setTimeStamp(System.currentTimeMillis()); //

        data.computeIfAbsent(sensorData.getSensorName(),
               key ->  new Sensor(sensorData.getSensorName()));

        data.get(sensorData.getSensorName()).addMeasurement(sensorData);

    }

    public Sensor getSensor(String sensorName){
        return data.get(sensorName);
    }

    public Collection<SensorData> getSensorData(String sensorName) {
        return data.get(sensorName).getSensorDataList();
    }

    public Collection<String> getSensorNames() {
        return data.keySet();
    }



}
