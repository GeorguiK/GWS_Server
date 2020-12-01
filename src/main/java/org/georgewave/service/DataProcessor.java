package org.georgewave.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataProcessor {

    private final SignalService signalService;
    private final AlertService alertService;

    @Autowired
    public DataProcessor(SignalService signalService, AlertService alertService) {
        this.signalService = signalService;
        this.alertService = alertService;
    }

    public void processData() {
        //TODO read sensors
        //TODO call alert
        //TODO clean old data
    }
}
