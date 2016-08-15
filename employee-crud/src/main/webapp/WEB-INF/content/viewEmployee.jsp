<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<body>
<h1>Mavenized Spring MVC JDBC Template - Employee CRUD</h1>
<h2>EmployeeHeader from Controller : ${employeeHeader}</h2>
<p><b> Action invoked : ${action} </b></p>
<p><b> Status of Action : ${statusMessage} </b></p>


<h4><b>Employee Details for Id : ${employeevo.id}</b></h4>

<table>
  <tr>
    <td>EmployeeName:</td>
    <td>${employeevo.fName}</th>
  </tr>
  <tr>
    <td>Employee Age:</td>
    <td>${employeevo.age}</td>
  </tr>
  <tr>
    <td>Employee Salary:</td>
    <td>${employeevo.salary}</td>
  </tr>
</table>

<table>
  <tr>
    <td><a href="addEmployee"> Create Employee</a> </td>
    <td><a href="retrieveEmployeeForm"> Retrieve Employee</a> </th>
    <td><a href="updateEmployeeForm?empId=${employeevo.id}"> Update Employee</a> </th>
    <td><a href="deleteEmployee?empId=${employeevo.id}"> Delete Employee</a> </th>
  </tr>

</table>





</body>
</html>



