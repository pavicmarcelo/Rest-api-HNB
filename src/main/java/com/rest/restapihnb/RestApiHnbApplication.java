package com.rest.restapihnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
public class RestApiHnbApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiHnbApplication.class, args);

    }


}
