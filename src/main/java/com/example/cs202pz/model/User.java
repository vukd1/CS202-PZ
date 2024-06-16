package com.example.cs202pz.model;

import com.password4j.Hash;
import jakarta.persistence.*;
import org.hibernate.Hibernate;
import java.util.Date;

@Entity
@Table(name = "usercredentials")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String username;
    private Hash passwordHash;
    private Date accountCreationDate;
    private Date lastLogin;
    // These two are Strings because it's easier to fetch database values in a String format
    // and then convert them as needed (and vice-versa).


    public User() {
    }

    public User(int userID, String username, Hash passwordHash, Date accountCreationDate, Date lastLogin) {
        this.userID = userID;
        this.username = username;
        this.passwordHash = passwordHash;
        this.accountCreationDate = accountCreationDate;
        this.lastLogin = lastLogin;
    }

    public User(String username, Hash passwordHash, Date accountCreationDate) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.accountCreationDate = accountCreationDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Hash getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(Hash passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Date getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(Date accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", passwordHash=" + passwordHash +
                ", accountCreationDate=" + accountCreationDate +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
