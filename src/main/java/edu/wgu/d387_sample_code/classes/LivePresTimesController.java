package edu.wgu.d387_sample_code.classes;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@CrossOrigin
@RestController
public class LivePresTimesController {
    @GetMapping("/api/live-presentation-times")
    public Map<String, String> getPresentationTimes() {
        LivePresentationTimes retrieve_times = new LivePresentationTimes();
        Thread thread = new Thread(retrieve_times);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return retrieve_times.getTimesFormatted();
    }
}