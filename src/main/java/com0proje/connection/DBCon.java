package com0proje.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {



    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/proje02","root","alpwan2673");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void closeConnection(Connection connection ){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }



}
