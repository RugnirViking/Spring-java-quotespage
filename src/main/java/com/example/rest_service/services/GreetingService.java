package com.example.rest_service.services;

import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;

public class GreetingService {
    private Clock _clock;
    private final ZoneId _timezone;
    public GreetingService(Clock clock, ZoneId timezone) {
        this._clock = clock;
        this._timezone  = timezone;
    }

    public String getGreeting() {

        LocalTime now = LocalTime.now(_clock.withZone(_timezone));
        // 6:00 - 12:00
        if (now.isBefore(LocalTime.NOON) && now.isAfter(LocalTime.of(6,0)))
            return "GOOD MORNING";
        else if (now.isBefore(LocalTime.of(17, 0)) && now.isAfter(LocalTime.of(6,0)))
            return "GOOD AFTERNOON";
        else if (now.isBefore(LocalTime.of(22, 0)) && now.isAfter(LocalTime.of(6,0)))
            return "GOOD EVENING";
        else
            return "GOOD NIGHT";

    }

    public String getSymbol() {
        LocalTime now = LocalTime.now(_clock.withZone(_timezone) );
        if (now.isAfter(LocalTime.of(6,0)) && now.isBefore(LocalTime.of(21,0)))
            return "sun";
        else
            return "moon";
    }
}
