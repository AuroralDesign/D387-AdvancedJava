package edu.wgu.d387_sample_code.classes;

import lombok.Getter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimezoneMsg implements Runnable {
    private final String zone_label;
    // Suggested by IntelliJ to use lombok @Getter -> make sure this doesn't cause issues
    @Getter
    private final ZoneId zone_id;
    @Getter
    private String time;

    public TimezoneMsg(String zone_label, ZoneId zoneId) {
        this.zone_label = zone_label;
        this.zone_id = zoneId;
    }

    @Override
    public void run() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        ZonedDateTime now = ZonedDateTime.now(zone_id);
        this.time = now.format(formatter);
    }

    public String getZoneLabel() {
        return zone_label;
    }
}