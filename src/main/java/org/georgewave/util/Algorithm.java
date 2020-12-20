package org.georgewave.util;

import org.georgewave.model.SensorData;

import java.util.Collection;

public class Algorithm {

    public static boolean validateSensorData(Collection<SensorData> sensorDataList, long threshold){
        double  sum=0;

        for (SensorData sensorData:
                sensorDataList) {
            sum+=sensorData.getSensorValue();
        }

        double average = sum / sensorDataList.size();

        double deviationSum = 0;

        for (SensorData sensorData:
                sensorDataList) {
            deviationSum += Math.abs(sensorData.getSensorValue() - average);
        }

        return deviationSum > threshold;
    }
}
