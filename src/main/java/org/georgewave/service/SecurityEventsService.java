package org.georgewave.service;

import org.georgewave.model.SecurityEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityEventsService {

    private List<SecurityEvent> securityEvents = new ArrayList<>(); //TODO

    public void add(SecurityEvent securityEvent) {
        securityEvents.add(securityEvent);
    }

    public List<SecurityEvent> getLatestEvents() {
        return securityEvents; //TODO
    }

}
