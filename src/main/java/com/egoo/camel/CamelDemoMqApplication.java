package com.egoo.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author mash
 */
@SpringBootApplication
public class CamelDemoMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamelDemoMqApplication.class, args);
    }

}
