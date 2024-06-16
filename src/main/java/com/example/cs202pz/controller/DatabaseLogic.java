package com.example.cs202pz.controller;
import com.example.cs202pz.view.LoginView;
import com.password4j.*;

import java.sql.*;

public class DatabaseLogic {

    private static DatabaseLogic databaseLogic_instance = null;
    private String dbUsername = "root";
    private String dbPassword = "";
    private String dbURL = "jdbc:mysql://localhost/micropos_db";
    private String query = "SELECT * FROM test_table";
    private Connection connection;
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
            while (result.next()){
                System.out.println("ID: " + result.getInt("id"));
                System.out.println("Name: " + result.getString("text_column"));
            }
            //
        }catch (SQLException e) {
            System.out.println("Couldn't connect to database!");
            LoginView.getInstance().dbInitErrorView("The application couldn't connect to the database.\nReason: " + e.getMessage());
        }
    }

    public boolean verifyAndLogin(String username, String password){
        String getUserSQL = "SELECT PasswordHash FROM usercredentials WHERE Username = ?";
        try{
            PreparedStatement getUserStmt = connection.prepareStatement(getUserSQL);
            getUserStmt.setString(1, username);
            try (ResultSet rs = getUserStmt.executeQuery()) {
                if (rs.next()) {
                    String storedHash = rs.getString("PasswordHash");
                    //Hash hash1 = Password.hash(storedHash).addRandomSalt().addPepper().withScrypt();
                    // Check if the provided password matches the stored hash
                    System.out.println(Password.check(password, storedHash).withScrypt());
                    return Password.check(password, storedHash).withScrypt();
                } else {
                    System.out.println("Username not found");
                    return false; // Username not found
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean createAccount(String username, String password){
        hash = Password.hash(password).addRandomSalt().addPepper().withScrypt();
        String checkUsernameSQL = "SELECT COUNT(*) AS user_count FROM usercredentials WHERE Username = ?";
        String insertUserSQL =
                "INSERT INTO usercredentials (Username, PasswordHash, CreatedAt) " +
                        "SELECT ?, ?, ? " +
                        "FROM (SELECT 1) AS dummy " +
                        "WHERE NOT EXISTS (SELECT 1 FROM usercredentials WHERE Username = ?)";
        try{
            PreparedStatement checkUsernameStmt = connection.prepareStatement(checkUsernameSQL);
            PreparedStatement insertUserStmt = connection.prepareStatement(insertUserSQL);
            // Check if the username already exists
            checkUsernameStmt.setString(1, username);
            try (ResultSet rs = checkUsernameStmt.executeQuery()) {
                if (rs.next() && rs.getInt("user_count") > 0) {
                    return false; // Username already exists
                }
            }
            insertUserStmt.setString(1, username);
            insertUserStmt.setString(2, hash.getResult());
            insertUserStmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            insertUserStmt.setString(4, username);

            int rowsAffected = insertUserStmt.executeUpdate();
            return rowsAffected > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public void login(String username, String password){

    }
    public void writeAccountToDB(String username, String password){
        hash = Password.hash(password).addRandomSalt().addPepper().withScrypt();
        System.out.println(hash.getResult());
    }
    public void checkHashTemp(String password){
        System.out.println(Password.check(password, hash));
    }
}
