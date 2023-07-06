package com.example.labguide.dals;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return  DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_db", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}