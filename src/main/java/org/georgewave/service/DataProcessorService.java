package org.georgewave.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataProcessorService {

    private final SignalService signalService;
    private final AlertService alertService;
    private static final long OFFSET = 60*1000;//Window offset is 60 seconds

    @Autowired
    public DataProcessorService(SignalService signalService, AlertService alertService) {
        this.signalService = signalService;
        this.alertService = alertService;
    }

    //TODO add Spring scheduling (every 5 seconds)
    public void processData() {

        for (String sensorName : signalService.getSensorNames()) {
            boolean processingResult = processSensorData(sensorName);

            if (processingResult){
                alertService.sendAlert("Intruder detected by sensor: " + sensorName);
            }

            signalService.cleanData(OFFSET, sensorName);
        }

    }

    public boolean processSensorData(String sensorID){
        //TODO actually do it
        return false;
    }
}
