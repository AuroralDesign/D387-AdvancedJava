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
    public Map<String, String> getWelcomeMessages() throws InterruptedException {
        Map<String, String> translation = Collections.synchronizedMap(new HashMap<>());

        Thread englishThread = new Thread(() -> {
            ResourceBundle bundle = ResourceBundle.getBundle("translation_en_US", Locale.ENGLISH);
            translation.put("English", bundle.getString("welcome"));
        });

        Thread frenchThread = new Thread(() -> {
            ResourceBundle bundle = ResourceBundle.getBundle("translation_fr_CA", Locale.FRENCH);
            translation.put("French", bundle.getString("welcome"));
        });

        englishThread.start();
        frenchThread.start();

        englishThread.join();
        frenchThread.join();

        return translation;
    }
}