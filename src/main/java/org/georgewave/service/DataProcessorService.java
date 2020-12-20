package org.georgewave.service;

import org.georgewave.model.SensorData;
import org.georgewave.util.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

    @Scheduled(fixedRate = 30000)
    public void processData() {

        for (String sensorName : signalService.getSensorNames()) {

            boolean processingResult = processSensorData(sensorName);

            if (processingResult){
                alertService.sendAlert("Intruder detected by sensor: " + sensorName);
            }
        }
    }

    public boolean processSensorData(String sensorName){
        signalService.getSensor(sensorName).cleanData(OFFSET);

        long threshold = signalService.getSensor(sensorName).getSignalStrengthThreshold();
        Collection<SensorData> sensorDataList = signalService.getSensorData(sensorName);

        return Algorithm.validateSensorData(sensorDataList, threshold);
    }
}
