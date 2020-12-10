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
        boolean result = true;
        long currentTime = System.currentTimeMillis();
        try{

            //populate S1
            String sensorOne = "S1";
            for(long i = 100; i >= 0; i--){
                signalService.addMeasurement(sensorOne,
                        100 - (int)(Math.random() * 25),
                        currentTime - (i*1000));
            }

            //populate S2
            String sensorTwo = "S2";
            for(long i = 100; i >= 0; i--){
                signalService.addMeasurement(sensorTwo,
                        100 - (int)(Math.random() * 100),
                        currentTime - (i*1000));
            }


            //S1 - no event triggered
            if (dataProcessorService.processSensorData("S1")) result = false;

            //S2 - event triggered
            if (!dataProcessorService.processSensorData("S2")) result = false;



        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        return result;
    }
}
