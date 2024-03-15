package com.example.taskeight.dao;

import com.example.taskeight.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private Connection con;

    public UserDao(Connection con) {
        this.con = con;
    }

    public void addUser(User user) {
        try {
            String query = "INSERT INTO users(firstName,lastName,dob,email,password) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getLastName());
            pst.setString(3, user.getDob());
            pst.setString(4, user.getEmail());
            pst.setString(5, user.getPassword());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isEmailTaken(String email) {
        try {
            String query = "SELECT COUNT(*) FROM users WHERE email=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User userLogin(String email, String password) {
        User user = null;
        try {
            String query = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                // Don't forget to set other attributes if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
