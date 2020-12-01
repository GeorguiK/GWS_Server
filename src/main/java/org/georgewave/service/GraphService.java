package org.georgewave.service;

import org.georgewave.model.GraphData;
import org.georgewave.model.GraphDataSet;
import org.georgewave.model.SensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class GraphService {

    private final SignalService signalService;

    @Autowired
    public GraphService(SignalService signalService) {
        this.signalService = signalService;
    }

    public GraphData getGraphData() {
        return new GraphData();
    }

    public GraphData getGraphData(String sensorName) {

        Collection<SensorData> sensorData = signalService.getSensorData(sensorName);

        if (sensorData == null || sensorData.isEmpty()) return new GraphData();

        List<String> labels = getLabels(sensorData);
        GraphDataSet graphDataSet = of(sensorData);

        List<GraphDataSet> graphDataSetList = new ArrayList<>();
        graphDataSetList.add(graphDataSet);

        return new GraphData(labels, graphDataSetList);

    }

    private List<String> getLabels(Collection<SensorData> sensorDataCollection) {

        List<String> result = new ArrayList<>();
        sensorDataCollection.forEach(e ->  result.add("")); //TODO - merge data
        return result;

    }

    private GraphDataSet of(Collection<SensorData> sensorDataCollection) {

        if (sensorDataCollection.isEmpty()) return new GraphDataSet();

        /*

        {
                label: "My First dataset",
                fillColor : "rgba(220,220,220,0.2)",
                strokeColor : "rgba(220,220,220,1)",
                pointColor : "rgba(220,220,220,1)",
                pointStrokeColor : "#fff",
                pointHighlightFill : "#fff",
                pointHighlightStroke : "rgba(220,220,220,1)",
                data : [...]
            },

         */

        GraphDataSet graphDataSet = new GraphDataSet();
        graphDataSet.setLabel(sensorDataCollection.stream().findFirst().get().getSensorName());
        graphDataSet.setFillColor("rgba(220,220,220,0.2)");
        graphDataSet.setStrokeColor("rgba(220,220,220,1)");
        graphDataSet.setPointColor("rgba(220,220,220,1)");
        graphDataSet.setPointStrokeColor("#fff");
        graphDataSet.setPointHighlightFill("#fff");
        graphDataSet.setPointHighlightStroke("rgba(220,220,220,1)");

        List<Double> data = new ArrayList<>();

        sensorDataCollection.stream().forEach(e -> data.add(e.getSensorValue()) );

        graphDataSet.setData(data);

        return graphDataSet;

    }

}
