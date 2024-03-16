package com.example.taskeight.servlet;

import com.example.taskeight.connection.DbCon;
import com.example.taskeight.dao.ProductDao;
import com.example.taskeight.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("image");

        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        product.setImage(image);

        try (Connection con = DbCon.getConnection()) {
            ProductDao productDao = new ProductDao(con);
            boolean result = productDao.addProduct(product);
            if (result) {
                response.sendRedirect("adminDashboard.jsp?status=success");
            } else {
                response.sendRedirect("adminDashboard.jsp?status=fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("adminDashboard.jsp?status=error");
        }
    }
}