package org.georgewave.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphData {

    private List<String> labels = new ArrayList<>();
    private List<GraphDataSet> datasets = new ArrayList<>();

    public GraphData() {
    }

    public GraphData(List<String> labels, List<GraphDataSet> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<GraphDataSet> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<GraphDataSet> datasets) {
        this.datasets = datasets;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphData graphData = (GraphData) o;
        return Objects.equals(labels, graphData.labels) &&
                Objects.equals(datasets, graphData.datasets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labels, datasets);
    }

    @Override
    public String toString() {
        return "GraphData{" +
                "labels=" + labels +
                ", datasets=" + datasets +
                '}';
    }
}
