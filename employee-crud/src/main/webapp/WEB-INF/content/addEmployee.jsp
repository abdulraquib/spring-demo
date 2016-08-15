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
<form:form action="/employee-crud-jdbc/employee/createEmployee" method="POST" modelAttribute="employeevo">      
<table><tbody>
<tr>        
<td><form:label path="Id">Employee :</form:label></td>      
<td><form:input path="Id"></form:input></td>    
</tr>
<tr>
<td><form:label path="fName">EmployeeName:</form:label></td>
<td><form:input path="fName"></form:input></td>    
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
<td colspan="2"><input type="submit" value="AddEmployee">  </td>       </tr>
</tbody></table>
</form:form>

</body>
</html>



