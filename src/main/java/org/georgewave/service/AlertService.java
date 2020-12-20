package org.georgewave.service;

import org.georgewave.model.SecurityEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AlertService {

    private final SmsService smsService;
    private final SecurityEventsService securityEventsService;

    private boolean enabled = false;

    @PostConstruct
    public void init() {
        long time = System.currentTimeMillis();
        SecurityEvent event = new SecurityEvent(time, "admin", "Alarm was disabled on startup", null);
    }

    @Autowired
    public AlertService(SmsService smsService, SecurityEventsService securityEventsService) {
        this.smsService = smsService;
        this.securityEventsService = securityEventsService;
    }

    public void sendAlert(String alertString) {

        //TODO do not spam alerts
        if (enabled) {
            long time = System.currentTimeMillis();
            SecurityEvent event = new SecurityEvent(time, "alarm", alertString, null);
            securityEventsService.add(event);
            smsService.sendSMS("800-0000000", alertString);
        } else {
            long time = System.currentTimeMillis();
            SecurityEvent event = new SecurityEvent(time, "skipped", alertString, null);
            securityEventsService.add(event);
        }

    }

    public boolean getAlarmStatus(String IP) {
        //long time = System.currentTimeMillis();
        //SecurityEvent event = new SecurityEvent(time, "admin", "Alarm status was requested", IP);
        //securityEventsService.add(event);
        return enabled;
    }

    public void enableAlarm(String IP) {

        long time = System.currentTimeMillis();
        SecurityEvent event = new SecurityEvent(time, "admin", "Alarm was enabled", IP);
        securityEventsService.add(event);
        enabled = true;
    }

    public void disableAlarm(String IP) {
        long time = System.currentTimeMillis();
        SecurityEvent event = new SecurityEvent(time, "admin", "Alarm was disabled", IP);
        securityEventsService.add(event);
        enabled = false;
    }


}
