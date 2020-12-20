package org.georgewave.service;

import org.georgewave.model.Sensor;
import org.georgewave.model.SensorData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class DataProcessorServiceTest {

    @MockBean
    private SignalService signalService;

    @MockBean
    private AlertService alertService;

    private Sensor sensor = Mockito.mock(Sensor.class);

    @Test
    public void testIsAlert() {

        DataProcessorService dataProcessorService
                = new DataProcessorService(signalService, alertService);

        String sensorName  = "s1";

        given(sensor.getSignalStrengthThreshold()).willReturn(10L);
        given(signalService.getSensor(sensorName)).willReturn(sensor);
        given(signalService.getSensorData(sensorName)).willReturn(getTestData(80, sensorName));

        boolean actual = dataProcessorService.processSensorData(sensorName);

        assertThat(actual).isEqualTo(true);
    }

    @Test
    public void testNoAlert() {

        DataProcessorService dataProcessorService
                = new DataProcessorService(signalService, alertService);

        String sensorName  = "s1";

        given(sensor.getSignalStrengthThreshold()).willReturn(10L);
        given(signalService.getSensor(sensorName)).willReturn(sensor);
        given(signalService.getSensorData(sensorName)).willReturn(getBaselineData(25, sensorName));

        boolean actual = dataProcessorService.processSensorData(sensorName);
        assertThat(actual).isEqualTo(false);
    }

    private Collection<SensorData> getTestData(int threshold, String sensorName) {

        long currentTime = System.currentTimeMillis();

        List<SensorData> result = new ArrayList<>();

        for (long i = 100; i >= 0; i--) {
            SensorData sensorData = new SensorData(sensorName,
                    -100 + (int) (Math.random() * threshold),
                    currentTime - (i * 1000));

            result.add(sensorData);
        }

        return result;
    }

    private Collection<SensorData> getBaselineData(int threshold, String sensorName) {
        long currentTime = System.currentTimeMillis();

        List<SensorData> result = new ArrayList<>();

        for (long i = 100; i >= 0; i--) {
            SensorData sensorData = new SensorData(sensorName,
                    -60,
                    currentTime - (i * 1000));

            result.add(sensorData);
        }

        return result;
    }
}
