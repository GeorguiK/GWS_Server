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

    @RequestMapping(value = "/populateAndProcessSensorData/{sensorName}", method = RequestMethod.GET)
    public boolean populateAndProcessSensorData(@PathVariable String sensorName) {
        try{
            signalService.addMeasurement( new SensorData(sensorName, 22.3));
            TimeUnit.SECONDS.sleep(1);
            signalService.addMeasurement( new SensorData(sensorName, 25.3));
            TimeUnit.SECONDS.sleep(1);
            signalService.addMeasurement( new SensorData(sensorName, 33.3));
            TimeUnit.SECONDS.sleep(1);
            signalService.addMeasurement( new SensorData(sensorName, 10.3));
            TimeUnit.SECONDS.sleep(1);
            signalService.addMeasurement( new SensorData(sensorName, 33.3));
            TimeUnit.SECONDS.sleep(1);
            signalService.addMeasurement( new SensorData(sensorName, 10.3));
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        return dataProcessorService.processSensorData(sensorName);
    }
}
