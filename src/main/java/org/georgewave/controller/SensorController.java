package org.georgewave.controller;

import org.georgewave.model.SensorData;
import org.georgewave.service.SignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class SensorController {

	private final SignalService signalService;

	@Autowired
	public SensorController(SignalService signalService) {
		this.signalService = signalService;
	}

	@RequestMapping(value = "/addData/{sensorName}/{SensorValue}", method = RequestMethod.GET)
	public void addSensorData(@PathVariable String sensorName, @PathVariable long sensorValue){
		SensorData sensorData = new SensorData(sensorName, sensorValue);
		signalService.addMeasurement(sensorData);
	}

	@RequestMapping(value = "/sensorData/{sensorName}", method = RequestMethod.GET)
	public Collection<SensorData> getSensorData(@PathVariable String sensorName) {
		return signalService.getSensorData(sensorName);
	}

	@RequestMapping(value = "/sensors", method = RequestMethod.GET)
	public Collection<String> getSensorNames() {
		return signalService.getSensorNames();
	}

	@RequestMapping(value = "/sensorData", method = RequestMethod.POST)
	public void addMeasurement(@RequestBody SensorData sensorData) {
		signalService.addMeasurement(sensorData);
	}

}
