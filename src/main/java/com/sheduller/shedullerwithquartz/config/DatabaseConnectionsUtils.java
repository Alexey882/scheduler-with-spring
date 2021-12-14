package com.sheduller.shedullerwithquartz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConnectionsUtils {

    public static Connection getConnection(Jobs.Job.DatabaseConfiguration databaseConfiguration) throws SQLException,
            ClassNotFoundException {
        Class.forName(databaseConfiguration.getDriver());
        String connectionURL = "jdbc:mysql://" + databaseConfiguration.getHost() +
                String.format(":%s/", databaseConfiguration.getPort()) + databaseConfiguration.getDatabaseName();
        return DriverManager.getConnection(connectionURL, databaseConfiguration.getUserName(),
                databaseConfiguration.getPassword());
    }
}