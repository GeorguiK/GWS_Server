package org.georgewave.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphDataSet {

    private String label;
    private String fillColor;
    private String strokeColor;
    private String pointColor;
    private String pointStrokeColor;
    private String pointHighlightFill;
    private String pointHighlightStroke;
    private List<Double> data = new ArrayList<>();

    public GraphDataSet() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public String getPointColor() {
        return pointColor;
    }

    public void setPointColor(String pointColor) {
        this.pointColor = pointColor;
    }

    public String getPointStrokeColor() {
        return pointStrokeColor;
    }

    public void setPointStrokeColor(String pointStrokeColor) {
        this.pointStrokeColor = pointStrokeColor;
    }

    public String getPointHighlightFill() {
        return pointHighlightFill;
    }

    public void setPointHighlightFill(String pointHighlightFill) {
        this.pointHighlightFill = pointHighlightFill;
    }

    public String getPointHighlightStroke() {
        return pointHighlightStroke;
    }

    public void setPointHighlightStroke(String pointHighlightStroke) {
        this.pointHighlightStroke = pointHighlightStroke;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphDataSet that = (GraphDataSet) o;
        return Objects.equals(label, that.label) &&
                Objects.equals(fillColor, that.fillColor) &&
                Objects.equals(strokeColor, that.strokeColor) &&
                Objects.equals(pointColor, that.pointColor) &&
                Objects.equals(pointStrokeColor, that.pointStrokeColor) &&
                Objects.equals(pointHighlightFill, that.pointHighlightFill) &&
                Objects.equals(pointHighlightStroke, that.pointHighlightStroke) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, fillColor, strokeColor, pointColor, pointStrokeColor, pointHighlightFill, pointHighlightStroke, data);
    }

    @Override
    public String toString() {
        return "GraphDataSet{" +
                "label='" + label + '\'' +
                ", fillColor='" + fillColor + '\'' +
                ", strokeColor='" + strokeColor + '\'' +
                ", pointColor='" + pointColor + '\'' +
                ", pointStrokeColor='" + pointStrokeColor + '\'' +
                ", pointHighlightFill='" + pointHighlightFill + '\'' +
                ", pointHighlightStroke='" + pointHighlightStroke + '\'' +
                ", data=" + data +
                '}';
    }
}
