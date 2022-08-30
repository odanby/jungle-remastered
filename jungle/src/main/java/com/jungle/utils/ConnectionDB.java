package com.jungle.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static Connection createConnection() {
        try {
            String dbURL = String.format(
                    "jdbc:postgresql://thejungle.cgg7cg1eomrq.us-east-1.rds.amazonaws.com:5432/TheJungle?user=postgres&password=password"
            );
            return DriverManager.getConnection(dbURL);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String args[]) {
            System.out.println(createConnection());
        }
}