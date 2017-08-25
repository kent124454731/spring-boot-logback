package com.kent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory
            .getLogger(WebApplication.class);

    @PostConstruct
    public void logSomething() {
        logger.debug("Sample Debug Message");
        logger.error("Sample ERROR Message");
        logger.trace("Sample Trace Message");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

}

