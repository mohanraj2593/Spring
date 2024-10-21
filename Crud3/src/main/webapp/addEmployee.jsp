<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Employee Details</title>
</head>
<body>
<form action="addEmployee">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td>Employee Name:</td>
            <td><input type="text" name="empname"></td>
        </tr>
        <tr>
            <td>Employee Designation:</td>
            <td><input type="text" name="desig"></td>
        </tr>
        <tr>
            <td>Employee Salary:</td>
            <td><input type="number" name="salary"></td>
        </tr>
        <tr>
            <td>Employee Email:</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>Employee Password:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center;">
                <input type="submit" value="Add Employee">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
