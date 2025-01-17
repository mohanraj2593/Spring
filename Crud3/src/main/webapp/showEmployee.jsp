<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tap.acad.model.employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }
    h1 {
        text-align: center;
        padding: 20px 0;
        color: #333;
    }
    .card-container {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        padding: 20px;
        gap: 20px;
    }
    .card {
        flex: 0 1 calc(33.33% - 40px); /* Ensure 3 cards per row */
        border: 1px solid #ddd;
        border-radius: 8px;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        background-color: #fff;
        text-align: center;
    }
    .card h3 {
        margin: 0 0 10px;
        font-size: 18px;
        color: #333;
    }
    .card p {
        margin: 5px 0;
        font-size: 14px;
        color: #555;
    }
    @media (max-width: 900px) {
        .card {
            flex: 0 1 calc(50% - 40px); /* 2 cards per row for smaller screens */
        }
    }
    @media (max-width: 600px) {
        .card {
            flex: 0 1 calc(100% - 40px); /* 1 card per row for small screens */
        }
    }
</style>
</head>
<body>

<h1>Employee Details</h1>
<center>
<a href="addEmployee.jsp"><button>Add Employee</button></a>
</center>
<div class="card-container">
    <%!ArrayList<employee> empList; %>

    <%  
    empList = (ArrayList<employee>) session.getAttribute("empList");
    for (employee e : empList) { 
    %>
    <div class="card">
        <h3><%= e.getEmpname() %></h3>
        <p><strong>Employee ID:</strong> <%= e.getEmpid() %></p>
        <p><strong>Designation:</strong> <%= e.getDesig() %></p>
        <p><strong>Salary:</strong> <%= e.getSalary() %></p>
        <p><strong>Email:</strong> <%= e.getEmail() %></p>
        <p><strong>Password:</strong> <%= e.getPassword() %></p>
        <a href="editEmployee.jsp"><button>Edit</button></a>
    </div>
    <% } %>
</div>
</body>
</html>
