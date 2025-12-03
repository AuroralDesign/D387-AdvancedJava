package edu.wgu.d387_sample_code.classes;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimezoneConverter {
    public static String convertTimezones(ZonedDateTime et_time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        ZonedDateTime mt_time = et_time.withZoneSameInstant(ZoneId.of("America/Denver"));
        ZonedDateTime utc_time = et_time.withZoneSameInstant(ZoneId.of("UTC"));

        String et_formatted = et_time.format(formatter);
        String mt_formatted = mt_time.format(formatter);
        String utc_formatted = utc_time.format(formatter);

        return "Live Presentation Times:\n" +
                "ET: " + et_formatted + "\n" +
                "MT: " + mt_formatted + "\n" +
                "UTC: " + utc_formatted;
    }
}