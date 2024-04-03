package io.sdet.motorsportsmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MotorsportsManagerApplication {

    public static final Logger LOGGER = LoggerFactory.getLogger(MotorsportsManagerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MotorsportsManagerApplication.class, args);
        LOGGER.info("The Motorsports Manager App has started...");
    }
}

