package org.georgewave.service;

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

    private Map<String, LinkedList<SensorData>> data;

    @PostConstruct
    public void init() {
        data = new ConcurrentHashMap<>();



    }


    public void addMeasurement(SensorData sensorData) {

        //TODO - validate input data

        sensorData.setTimeStamp(System.currentTimeMillis()); //

        data.computeIfAbsent(sensorData.getSensorName(),
               key ->  new LinkedList<>());

        data.get(sensorData.getSensorName()).add(sensorData);

    }

    public Collection<SensorData> getSensorData(String sensorName) {
        return data.get(sensorName);
    }

    public Collection<String> getSensorNames() {
        return data.keySet();
    }


    public void cleanData(final long offset, String sensorName) {

        LinkedList<SensorData> dataSet = data.get(sensorName);

        if (dataSet == null || dataSet.isEmpty()) return;

        long currentTimestamp = System.currentTimeMillis();
        long dataTimeStamp = dataSet.getFirst().getTimeStamp();

        //check if element is older that current time - offset time
        while(dataTimeStamp < (currentTimestamp - offset)){

            dataSet.removeFirst();
            dataTimeStamp = dataSet.getFirst().getTimeStamp();
        }
    }
}
