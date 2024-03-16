package com.example.taskeight.servlet;

import com.example.taskeight.connection.DbCon;
import com.example.taskeight.dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection con = DbCon.getConnection()) {
            ProductDao productDao = new ProductDao(con);
            boolean result = productDao.deleteProduct(id);
            if (result) {
                response.sendRedirect("adminDashboard.jsp?status=deleted");
            } else {
                response.sendRedirect("adminDashboard.jsp?status=fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("adminDashboard.jsp?status=error");
        }
    }
}
