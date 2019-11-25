package com.aselad.ide.postgresapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class PostgresappApplication {

    private static final Logger LOGGER = LogManager.getLogger(PostgresappApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PostgresappApplication.class, args);
    }

}
