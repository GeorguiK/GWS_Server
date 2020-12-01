package org.georgewave.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.georgewave.model.SensorData;

@Service
public class SignalService {

    private Map<String, List<SensorData>> data;

    @PostConstruct
    public void init() {
        data = new ConcurrentHashMap<>();

        addMeasurement( new SensorData("s1", 22.3));
        addMeasurement( new SensorData("s1", 25.3));
        addMeasurement( new SensorData("s1", 33.3));
        addMeasurement( new SensorData("s1", 10.3));
        addMeasurement( new SensorData("s2", 33.3));
        addMeasurement( new SensorData("s2", 10.3));

    }


    public void addMeasurement(SensorData sensorData) {

        //TODO - validate input data

        sensorData.setId(System.currentTimeMillis()); //

        data.computeIfAbsent(sensorData.getSensorName(),
               key ->  new ArrayList<>());

        data.get(sensorData.getSensorName()).add(sensorData);

    }

    public Collection<SensorData> getSensorData(String sensorName) {
        return data.get(sensorName);
    }

    public Collection<String> getSensorNames() {
        return data.keySet();
    }

    public void cleanData(final long offset, String sensorName) {
        //TODO
    }
}
