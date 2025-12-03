package edu.wgu.d387_sample_code.classes;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class LivePresentationTimes implements Runnable {
    private Map<String, String> time_formatted;

    public Map<String, String> getTimesFormatted() {
        return time_formatted;
    }

    @Override
    public void run() {
        time_formatted = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        time_formatted.put("ET", ZonedDateTime.now(ZoneId.of("America/New_York")).format(formatter));
        time_formatted.put("MT", ZonedDateTime.now(ZoneId.of("America/Denver")).format(formatter));
        time_formatted.put("UTC", ZonedDateTime.now(ZoneId.of("UTC")).format(formatter));
    }
}