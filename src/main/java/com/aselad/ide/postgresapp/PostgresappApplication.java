package com.aselad.ide.postgresapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class PostgresappApplication implements CommandLineRunner {

    private static final Logger LOGGER = LogManager.getLogger(PostgresappApplication.class);

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(PostgresappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("DataSource : "+dataSource);
    }
}
