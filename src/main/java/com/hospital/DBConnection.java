package com.hospital;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                // Load MySQL Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Connect to Database
                con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospitaldb",  
                    "root",                                   
                    "aditi"                                    
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
