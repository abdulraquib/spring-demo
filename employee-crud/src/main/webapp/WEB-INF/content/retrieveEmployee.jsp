<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<body>
<h1>Mavenized Spring MVC JDBC Template - Employee CRUD</h1>
<h2>EmployeeHeader from Controller : ${employeeHeader}</h2>
<p><b> Action invoked : ${action} </b></p>

<h2>
Employee Data Form</h2>


<form action="/employee-crud-jdbc/employee/retrieveEmployee" method="GET">
Input Employee Id: <input id="empId" type="text" name="empId"><br>
<input type="submit" value="Submit">
</form>


</body>
</html>



