package edu.wgu.d387_sample_code.classes;

import java.util.Locale;
import java.util.ResourceBundle;

public class WelcomeMsg implements Runnable {
    private final Locale locale;
    private String translation;

    public WelcomeMsg(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void run() {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("translation", locale);
            translation = bundle.getString("welcome");
        } catch (Exception e) {
            translation = "Error loading message for locale " + locale;
        }
    }

    public String getMessage() {
        return "[" + locale.getDisplayLanguage() + "] " + translation;
    }
}