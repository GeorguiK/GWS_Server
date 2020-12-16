package org.georgewave.service;

import org.georgewave.model.SensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class DataProcessorService {

    private final SignalService signalService;
    private final AlertService alertService;
    public static final long OFFSET = 60*1000;//Window offset is 60 seconds

    @Autowired
    public DataProcessorService(SignalService signalService, AlertService alertService) {
        this.signalService = signalService;
        this.alertService = alertService;
    }

    //TODO add Spring scheduling (every 5 seconds)
    public void processData() {

        for (String sensorName : signalService.getSensorNames()) {

            signalService.getSensor(sensorName).cleanData(OFFSET);

            boolean processingResult = processSensorData(sensorName);

            if (processingResult){
                alertService.sendAlert("Intruder detected by sensor: " + sensorName);
            }

        }

    }

    public boolean processSensorData(String sensorName){
        long threshold = signalService.getSensor(sensorName).getSignalStrengthThreshold();
        Collection<SensorData> sensorDataList = signalService.getSensorData(sensorName);

        for (SensorData sensorData:
             sensorDataList) {
            if (sensorData.getSensorValue() < threshold) return true;
        }
        
        return false;
    }
}
