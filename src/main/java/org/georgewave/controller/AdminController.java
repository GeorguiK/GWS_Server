package org.georgewave.controller;

import org.georgewave.model.SecurityEvent;
import org.georgewave.service.AlertService;
import org.georgewave.service.SecurityEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AdminController {

    private final AlertService alertService;
    private final SecurityEventsService securityEventsService;

    @Autowired
    public AdminController(AlertService alertService, SecurityEventsService securityEventsService) {
        this.alertService = alertService;
        this.securityEventsService = securityEventsService;
    }

    @RequestMapping(value = "/disable", method = RequestMethod.POST)
    public void disable() {
        alertService.disableAlarm(null); //TODO
    }

    @RequestMapping(value = "/enable", method = RequestMethod.POST)
    public void enable() {
        alertService.enableAlarm(null); //TODO
    }

    @RequestMapping(value = "/securitylog", method = RequestMethod.GET)
    public Collection<SecurityEvent> getLatestEvents() {
       return securityEventsService.getLatestEvents();
    }

}
