package com.example.cs202pz.controller;
import java.sql.*;

public class DatabaseLogic {

    private static String dbUsername = "root";
    private static String dbPassword = "";
    private static String dbURL = "jdbc:mysql://localhost/micropos_db";
    private static String query = "SELECT * FROM test_table";
    public DatabaseLogic() {

    }

    public static void initDB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver"); // this in a try-catch
        System.out.println("Driver initialized!");
        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        System.out.println("Database connected!"); // this in a try-catch
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()){
            String data = "";
            for (int i = 1; i <= 2; i++){
                data += result.getString(i) + ":";
            }
            System.out.printf(data);
        }
    }
}
