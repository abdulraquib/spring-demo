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
<form:form action="/spring-crud-jdbc/employee/addEmployee" method="POST" modelAttribute="employeevo">      
<table><tbody>
<tr>        
<td><form:label path="Id">Employee Id:</form:label></td>      
<td><form:input path="id"></form:input></td>    
</tr>
<tr>
<td><form:label path="Name">EmployeeName:</form:label></td>
<td><form:input path="name"></form:input></td>    
</tr>
<tr>       
<td><form:label path="age">Employee Age:</form:label></td>       
<td><form:input path="age"></form:input></td>     
</tr>
<tr>      
<td><form:label path="salary">Employee Salary:</form:label></td>     
<td><form:input path="salary"></form:input></td>    
</tr>
<tr>         
<td colspan="2"><input type="submit" value="Submit">  </td>       </tr>
</tbody></table>
</form:form>

</body>
</html>



