package org.georgewave.controller;

import org.georgewave.model.GraphData;
import org.georgewave.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphController {

    private final GraphService graphService;

    @Autowired
    public GraphController(GraphService graphService) {
        this.graphService = graphService;
    }

    @RequestMapping(value = "/sensorGraph/{sensorName}", method = RequestMethod.GET)
    public GraphData getSensorGraph(@PathVariable String sensorName) {
        return graphService.getGraphData(sensorName);
    }

    @RequestMapping(value = "/graph", method = RequestMethod.GET)
    public GraphData getGraph() {
        return graphService.getGraphData();
    }
}
