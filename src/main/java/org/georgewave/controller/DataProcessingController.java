package org.georgewave.controller;

import org.georgewave.model.SensorData;
import org.georgewave.service.DataProcessorService;
import org.georgewave.service.SignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

@RestController
public class DataProcessingController {
    private final DataProcessorService dataProcessorService;
    private final SignalService signalService;

    @Autowired
    public DataProcessingController(DataProcessorService dataProcessorService, SignalService signalService) {
        this.dataProcessorService = dataProcessorService;
        this.signalService = signalService;
    }

    @RequestMapping(value = "/processSensorData/{sensorName}", method = RequestMethod.GET)
    public boolean processSensorData(@PathVariable String sensorName) {
        return dataProcessorService.processSensorData(sensorName);
    }

    @RequestMapping(value = "/processData", method = RequestMethod.GET)
    public void processData() {
        dataProcessorService.processData();
    }

}
