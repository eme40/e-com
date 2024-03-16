package com.example.taskeight.servlet;

import com.example.taskeight.connection.DbCon;
import com.example.taskeight.dao.AdminDao;
import com.example.taskeight.model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "admin", value = "/admin-signup")
public class AdminController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String adminToken = req.getParameter("adminToken");

        AdminDao adminDao = null;
        try {
            adminDao = new AdminDao(DbCon.getConnection());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (adminDao.emailExists(email)) {
            req.setAttribute("signupError", "This email is already in use. Please Log in.");
            req.getRequestDispatcher("/adminLogin.jsp").forward(req, resp);
        } else {
            Admin newAdmin = new Admin(fullName, email, password, adminToken);
            adminDao.addAdmin(newAdmin);
            resp.sendRedirect("admin-login-success.jsp");
        }
    }
}