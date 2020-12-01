package org.georgewave.model;

import java.util.Objects;

public class SecurityEvent {

    private long time;
    private String eventType;
    private String eventMessage;
    private String eventIP;

    public SecurityEvent(long time, String eventType, String eventMessage, String eventIP) {
        this.time = time;
        this.eventType = eventType;
        this.eventMessage = eventMessage;
        this.eventIP = eventIP;
    }

    public SecurityEvent() {
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventMessage() {
        return eventMessage;
    }

    public void setEventMessage(String eventMessage) {
        this.eventMessage = eventMessage;
    }

    public String getEventIP() {
        return eventIP;
    }

    public void setEventIP(String eventIP) {
        this.eventIP = eventIP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityEvent event = (SecurityEvent) o;
        return time == event.time &&
                Objects.equals(eventType, event.eventType) &&
                Objects.equals(eventMessage, event.eventMessage) &&
                Objects.equals(eventIP, event.eventIP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, eventType, eventMessage, eventIP);
    }

    @Override
    public String toString() {
        return "SecurityEvent{" +
                "time=" + time +
                ", eventType='" + eventType + '\'' +
                ", eventMessage='" + eventMessage + '\'' +
                ", eventIP='" + eventIP + '\'' +
                '}';
    }
}
