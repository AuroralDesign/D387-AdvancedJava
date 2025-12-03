package edu.wgu.d387_sample_code.classes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TimezoneMsgController {
    @GetMapping("/api/presentation-times")
    public Map<String, String> getTimes() throws InterruptedException {
        Map<String, String> pres_times = Collections.synchronizedMap(new HashMap<>());

        TimezoneMsg ET = new TimezoneMsg("ET", ZoneId.of("America/New_York"));
        TimezoneMsg MT = new TimezoneMsg("MT", ZoneId.of("America/Denver"));
        TimezoneMsg UTC = new TimezoneMsg("UTC", ZoneId.of("UTC"));

        Thread et_thread = new Thread(ET);
        Thread mt_thread = new Thread(MT);
        Thread utc_thread = new Thread(UTC);

        et_thread.start();
        mt_thread.start();
        utc_thread.start();

        et_thread.join();
        mt_thread.join();
        utc_thread.join();

        pres_times.put(ET.getZoneLabel(), ET.getTime());
        pres_times.put(MT.getZoneLabel(), MT.getTime());
        pres_times.put(UTC.getZoneLabel(), UTC.getTime());

        return pres_times;
    }
}