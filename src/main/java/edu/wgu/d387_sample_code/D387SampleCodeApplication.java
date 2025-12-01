package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.classes.WelcomeMsg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class D387SampleCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(D387SampleCodeApplication.class, args);

        Thread enThread = new Thread(new WelcomeMsg(Locale.ENGLISH));
        Thread frThread = new Thread(new WelcomeMsg(Locale.FRENCH));

        enThread.start();
        frThread.start();
    }
}
