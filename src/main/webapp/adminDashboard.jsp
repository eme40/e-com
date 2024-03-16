
<%@ page import="java.util.List" %>
<%@ page import="com.example.taskeight.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/12/24
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="includes/head.jsp"%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Admin Dashboard - Electro</title>

</head>
<body>
<div class="container mt-5">
    <h2 style="padding-top: 50px">ADMIN DASHBOARD</h2>

    <!-- Add Product Form -->
    <div class="section mt-5">
        <h3>Add New Product(s)</h3>
        <form action="addProduct" method="post" class="form-horizontal">
            <div class="form-group">
                <label for="name" class="control-label col-sm-2">Name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter product name" required>
                </div>
            </div>
            <div class="form-group">
                <label for="category" class="control-label col-sm-2">Category:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="category" name="category" placeholder="Enter product category" required>
                </div>
            </div>
            <div class="form-group">
                <label for="price" class="control-label col-sm-2">Price:</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="price" name="price" placeholder="Enter product price" step="0.01" required>
                </div>
            </div>
            <div class="form-group">
                <label for="image" class="control-label col-sm-2">Image URL:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="image" name="image" placeholder="Enter product image URL" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Add Product</button>
                </div>
            </div>
        </form>
    </div>

    <!-- List Products (This section should be dynamically populated) -->
    <div class="section">
        <h3>Manage Products</h3>
        <!-- Example table structure. Populate dynamically with product data -->
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Category</th>
                <th>Price</th>
                <th>Image</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Product> productList = (List<Product>) request.getAttribute("products");
                if(productList != null) {
                    for(Product product : productList) {
            %>
            <tr>
                <td><%= product.getId() %></td>
                <td><%= product.getName() %></td>
                <td><%= product.getCategory() %></td>
                <td>$<%= product.getPrice() %></td>
                <td><img src="<%= request.getContextPath() %>/img/<%= product.getImage() %>" style="width: 50px; height: auto;"></td>
                <td>
                    <a href="deleteProduct?id=<%= product.getId() %>" class="btn btn-danger">Delete</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>

        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</body>
</html>
