package com.example.cs202pz.controller;
import com.example.cs202pz.main.MainApp;
import com.example.cs202pz.view.LoginView;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.scene.text.Text;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.sql.*;

public class DatabaseLogic {

    private static String dbUsername = "root";
    private static String dbPassword = "";
    private static String dbURL = "jdbc:mysql://localhost/micropos_db";
    private static String query = "SELECT * FROM test_table";
    public DatabaseLogic() {

    }

    public static void initDB() throws SQLException{
        try{ // Driver init
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("JDBC driver initialized!");
        }catch (ClassNotFoundException e){
            System.out.println("JDBC driver not initialized!");
        }
        try{ // Database init
            Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            System.out.println("Database connected!");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
//            while (result.next()){ // Test loop to read data out of the test_table
//                StringBuilder data = new StringBuilder();
//                for (int i = 1; i <= 2; i++){
//                    data.append(result.getString(i)).append(":");
//                }
//                System.out.printf(data.toString());
//            }
        }catch (SQLException e) {
            System.out.println("Couldn't connect to database!");
            LoginView.getInstance().dbInitErrorView("The application couldn't connect to the database.\nReason: " + e.getMessage());
        }
    }
    public static boolean verifyCredentials(String username, String password){
        if (username.equals("test1") && password.equals("test1")) {
            return true;
        }
        return false;
    }
}
