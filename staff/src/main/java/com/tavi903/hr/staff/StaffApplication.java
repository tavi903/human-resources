package com.tavi903.hr.staff;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@SpringBootApplication
public class StaffApplication {
    public static void main(String[] args) {
        SpringApplication.run(StaffApplication.class, args);
    }

    @Profile({"dev"})
    @Bean(
            initMethod = "start",
            destroyMethod = "stop"
    )
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", System.getenv("H2_PORT"));
    }

}