package edu.wgu.d387_sample_code.classes;

import java.util.Locale;
import java.util.ResourceBundle;

public class WelcomeMsg implements Runnable{

    private Locale locale;
    private String message;

    public WelcomeMsg(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void run() {
        try {
            ResourceBundle res_bundle = ResourceBundle.getBundle("messages", locale);
            message = res_bundle.getString("welcome");
        } catch (Exception e) {
            message = "Couldn't retrieve WelcomeMsg.java: " + locale;
        }
    }

    public String getMessage() {
        return "[" + locale.getDisplayLanguage() + "] " + message;
    }
}