package com.example.cs202pz.controller;
import com.example.cs202pz.main.MainApp;
import com.example.cs202pz.view.LoginView;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.scene.text.Text;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;
import com.password4j.*;

import java.sql.*;

public class DatabaseLogic {

    private static DatabaseLogic databaseLogic_instance = null;
    private String dbUsername = "root";
    private String dbPassword = "";
    private String dbURL = "jdbc:mysql://localhost/micropos_db";
    private String query = "SELECT * FROM test_table";
    private Connection connection;
    private Statement statement;
    private static Hash hash;

    public static synchronized DatabaseLogic getInstance(){
        if (databaseLogic_instance == null) {
            databaseLogic_instance = new DatabaseLogic();
        }
        return databaseLogic_instance;
    }

    public void initDB(){
        try{ // Driver init
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("JDBC driver initialized!");
        }catch (ClassNotFoundException e){
            System.out.println("JDBC driver not initialized!");
        }
        try{ // Database init
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            System.out.println("Database connected!");
            //
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            //
        }catch (SQLException e) {
            System.out.println("Couldn't connect to database!");
            LoginView.getInstance().dbInitErrorView("The application couldn't connect to the database.\nReason: " + e.getMessage());
        }
    }

    public void initHibernateDB(){

    }

    public boolean verifyCredentials(String username, String password) throws SQLException {
        //Put in try catch
        ResultSet result = statement.executeQuery(query);
        // Not done, must execute complex sql query. Maybe use streams, file i/o or a lib.
        // Quite possibly a user wrapper class is needed, which will go into the model package
        // Use hibernate then to directly write User class object to sql database!
        return true;
    }
    public void writeAccountToDB(String username, String password){
        hash = Password.hash(password).addRandomSalt().addPepper().withScrypt();
        System.out.println(hash.getResult());
    }
    public void checkHashTemp(String password){
        System.out.println(Password.check(password, hash));
    }
}
