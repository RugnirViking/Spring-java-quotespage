package com.example.rest_service.service_tests;

import com.example.rest_service.services.GreetingService;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class GreetingServiceTests {

    private static final ZoneId CPH = ZoneId.of("Europe/Copenhagen");
    private static final LocalDate FIXED_DATE = LocalDate.of(2025, 7, 3);

    @Test
    void contextLoads() {
    }

    @Test
    void picksCorrectGreetingMorning(){
        LocalTime  lt   = LocalTime.parse("07:30");           // e.g. "07:30"
        Instant    ts   = FIXED_DATE.atTime(lt).atZone(CPH).toInstant();
        Clock      clk  = Clock.fixed(ts, CPH);            // deterministic!

        GreetingService testService = new GreetingService(clk, CPH);

        assertEquals("GOOD MORNING", testService.getGreeting());
        assertEquals("sun"         , testService.getSymbol());
    }
    @Test
    void picksCorrectGreetingAfternoon(){
        LocalTime  lt   = LocalTime.parse("12:30");           // e.g. "07:30"
        Instant    ts   = FIXED_DATE.atTime(lt).atZone(CPH).toInstant();
        Clock      clk  = Clock.fixed(ts, CPH);            // deterministic!

        GreetingService testService = new GreetingService(clk, CPH);

        assertEquals("GOOD AFTERNOON", testService.getGreeting());
        assertEquals("sun"         , testService.getSymbol());
    }

    @Test
    void picksCorrectGreetingEvening(){
        LocalTime  lt   = LocalTime.parse("21:30");           // e.g. "07:30"
        Instant    ts   = FIXED_DATE.atTime(lt).atZone(CPH).toInstant();
        Clock      clk  = Clock.fixed(ts, CPH);            // deterministic!

        GreetingService testService = new GreetingService(clk, CPH);

        assertEquals("GOOD EVENING", testService.getGreeting());
        assertEquals("moon"         , testService.getSymbol());
    }

    @Test
    void picksCorrectGreetingNight(){
        LocalTime  lt   = LocalTime.parse("02:30");           // e.g. "07:30"
        Instant    ts   = FIXED_DATE.atTime(lt).atZone(CPH).toInstant();
        Clock      clk  = Clock.fixed(ts, CPH);            // deterministic!

        GreetingService testService = new GreetingService(clk, CPH);

        assertEquals("GOOD NIGHT", testService.getGreeting());
        assertEquals("moon"         , testService.getSymbol());
    }
}
