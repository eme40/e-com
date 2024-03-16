package com.example.taskeight.dao;

import com.example.taskeight.connection.DbCon;
import com.example.taskeight.model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    private Connection connection;

    public AdminDao(Connection connection) {
        try {
            this.connection = DbCon.getConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean emailExists(String email) {
        boolean exists = false;
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT COUNT(*) FROM admin WHERE email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                exists = resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exists;
    }
    public void addAdmin(Admin admin) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into admin(fullName,email,password,adminToken) values (?,?,?,?)");
            preparedStatement.setString(1, admin.getFullName());
            preparedStatement.setString(2, admin.getEmail());
            preparedStatement.setString(3, admin.getPassword());
            preparedStatement.setString(4, admin.getAdminToken());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}