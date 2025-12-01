package edu.wgu.d387_sample_code.classes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/api/welcome")

public class WelcomeMsgController {

    @GetMapping
    public Map<String, String> getWelcomeTranslations() throws InterruptedException {
        Map<String, String> translation = Collections.synchronizedMap(new HashMap<>());
        Thread enThread = new Thread(() -> {
            ResourceBundle res_bundle = ResourceBundle.getBundle("translation", Locale.ENGLISH);
            translation.put("_en_US", res_bundle.getString("welcome"));
        });

        Thread frThread = new Thread(() -> {
            ResourceBundle res_bundle = ResourceBundle.getBundle("translation", Locale.FRENCH);
            translation.put("_fr_CA", res_bundle.getString("welcome"));
        });

        enThread.start();
        frThread.start();

        enThread.join();
        frThread.join();

        return translation;
    }
}