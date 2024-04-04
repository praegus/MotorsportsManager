package io.sdet.msm.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.sdet.msm")
public class MotorsportsManagerApplication {

    public static final Logger LOGGER = LoggerFactory.getLogger(MotorsportsManagerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MotorsportsManagerApplication.class, args);
        LOGGER.info("The Motorsports Manager App has started...");
    }
}

