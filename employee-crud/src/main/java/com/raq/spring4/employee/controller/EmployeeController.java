package com.raq.spring4.employee.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.raq.spring4.employee.vo.EmployeeVO;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private static final String VIEW_EMPLOYEE = "viewEmployee";
	private static final String ADD_EMPLOYEE = "addEmployee";
	private static final String CREATE_EMPLOYEE = "employee";
	private static final String RETRIEVE_EMPLOYEE = "retrieveEmployee";
	private static final String UDPATE_EMPLOYEE = "updateEmployee";
	private static final String DELETE_EMPLOYEE = "employee";
	private static final String DEFAULT = "default";
	private static final String EMPLOYEES_IN_SESSION ="EmployeesInSession";


		//http://localhost:1975/employee-crud-jdbc/employee/viewEmployee
		@RequestMapping(value = {"/viewEmployee"}, method = RequestMethod.GET)
		public String viewEmployee(@ModelAttribute("employeevo")EmployeeVO employee, ModelMap model,HttpSession session) {
			model.addAttribute("employeeHeader", "Welcome to Employee Page");
			model.addAttribute("action", "viewEmployee");
			if(employee == null){
				employee = new EmployeeVO();
			}
			
			model.addAttribute("employeevo", employee);
			System.out.println("model.getAttribute(action) "
					+ model.get("action"));
			System.out.println("employee from session  "
					+ employee);
			return VIEW_EMPLOYEE;
		}
	
		//http://localhost:1975/employee-crud-jdbc/employee/addEmployee
		//will work only if the parameters are passed
		@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
		public String addEmployee(@ModelAttribute("employeevo")EmployeeVO employee,ModelMap model,HttpSession session) {
			model.addAttribute("action", "addEmployee");
			System.out.println("model.getAttribute(addEmployee) " 	+ model.get("addEmployee"));
		
			EmployeeVO newEmployee = new EmployeeVO();
			System.out.println("-- Add employee invoked" 		+ newEmployee);
			model.addAttribute("employeevo", newEmployee);
			return ADD_EMPLOYEE;
		}
		
		//http://localhost:1975/employee-crud-jdbc/employee/updateEmployeeForm?empId=11
		@RequestMapping(value = "/updateEmployeeForm", method = RequestMethod.GET)
		public String updateEmployeeForm(@ModelAttribute("employeevo")EmployeeVO employee,@RequestParam("empId") String empId,ModelMap model,HttpSession session) {
			model.addAttribute("action", "updateEmployee");
			System.out.println("model.getAttribute(addEmployee) " 	+ model.get("addEmployee"));
			EmployeeVO existingEmployee = getEmployeeById(empId,session);
			System.out.println("-- Add employee invoked" 		+ existingEmployee);
			model.addAttribute("employeevo", existingEmployee);
			return UDPATE_EMPLOYEE;
		}
		
		
		
		//http://localhost:1975/employee-crud-jdbc/employee/deleteEmployee?empId=11
		@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
		public String deleteEmployee(@ModelAttribute("employeevo")EmployeeVO employee,@RequestParam("empId") String empId,ModelMap model,HttpSession session) {
			model.addAttribute("action", "updateEmployee");
			System.out.println("model.getAttribute(addEmployee) " 	+ model.get("addEmployee"));
			removeEmployeeById(empId,session);
			model.addAttribute("employeevo", new EmployeeVO());
			
			String statusMessage = "Successfully deleted Employee id : " + empId;
			model.addAttribute("statusMessage", statusMessage);
	
			return VIEW_EMPLOYEE;
		}
		

		@RequestMapping(value = "/retrieveEmployeeForm", method = RequestMethod.GET)
		public String retrieveEmployeeForm(ModelMap model) {
			model.addAttribute("action", "retrieveEmployeeForm");
			System.out.println("model.getAttribute(action) "
					+ model.get("action"));
		
			return RETRIEVE_EMPLOYEE;
		}
		
		
		//http://localhost:1975/employee-crud-jdbc/employee/retrieveEmployee?empId=11
		@RequestMapping(value = "/retrieveEmployee", method = RequestMethod.GET)
		public String retrieveEmployee(@RequestParam("empId") String empId,ModelMap model,HttpSession session) {
			
			model.addAttribute("action", "retrieveEmployee");
			System.out.println("Input Employee Id" + empId );
			
			EmployeeVO employee = getEmployeeById(empId,session);
			
			model.addAttribute("employeevo", employee);
			System.out.println("model.getAttribute(action) "
					+ model.get("action"));
			System.out.println("employee from session  "
					+ employee);
			
			String statusMessage = "Employee Id retrieved " + empId;
			if(employee == null){
				statusMessage = "Unable to retrieve Employee Id " + empId;
			}
			model.addAttribute("statusMessage", statusMessage);
		
			return VIEW_EMPLOYEE;
		}
		
		

		@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
		public String createEmployee(@ModelAttribute("employeevo")EmployeeVO employee,ModelMap model,HttpSession session) {
			model.addAttribute("action", "parameters");
			System.out.println("model.getAttribute(addEmployee) "
					+ model.get("addEmployee"));
			System.out.println("-- Add employee invoked"
					+ employee);
			
			//save employee in session
			saveOrUpdateEmployee(employee, session);
			
			model.addAttribute("employeevo", employee);
			String statusMessage = "Employee created Success with Id " + employee.getId();
			model.addAttribute("statusMessage", statusMessage);
			
			return VIEW_EMPLOYEE;
		}

		@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
		public String updateEmployee(@ModelAttribute("employeevo")EmployeeVO employee,ModelMap model,HttpSession session) {
			model.addAttribute("action", "parameters");
			System.out.println("model.getAttribute(addEmployee) "
					+ model.get("addEmployee"));
			System.out.println("-- Add employee invoked"
					+ employee);
			
			//save employee in session
			saveOrUpdateEmployee(employee, session);
			
			model.addAttribute("employeevo", employee);
			String statusMessage = "Employee created Success with Id " + employee.getId();
			model.addAttribute("statusMessage", statusMessage);
			
			return VIEW_EMPLOYEE;
		}
		
		
		
		private void saveOrUpdateEmployee(EmployeeVO employee, HttpSession session){
			
			@SuppressWarnings("unchecked")
			Map<String,EmployeeVO> employeeMap = (Map<String,EmployeeVO>)session.getAttribute(EMPLOYEES_IN_SESSION);
			if(employeeMap == null){
				employeeMap = new HashMap<String,EmployeeVO>();
				employeeMap.put(Integer.toString(employee.getId()), employee);
				session.setAttribute(EMPLOYEES_IN_SESSION, employeeMap);
			}
			if(employeeMap != null){
				if(employeeMap.get(Integer.toString(employee.getId())) !=  null){
					//TBD : Modify this logic
					employeeMap.put(Integer.toString(employee.getId()), employee);
				}
				employeeMap.put(Integer.toString(employee.getId()), employee);
				session.setAttribute(EMPLOYEES_IN_SESSION, employeeMap);
			}
			System.out.println("Employee Keys in Save Employee" + employeeMap.keySet());
		}
		
		private EmployeeVO getEmployeeById(String id,HttpSession session){
			Map<String,EmployeeVO> employeeMap = (Map<String,EmployeeVO>)session.getAttribute(EMPLOYEES_IN_SESSION);
			
			if(employeeMap != null){
				System.out.println("Employee Keys in getEmployee" + employeeMap.keySet());
				EmployeeVO employee= employeeMap.get(id);
				return employee;
			}
			return null;
		}
		
		private void removeEmployeeById(String id,HttpSession session){

					Map<String,EmployeeVO> employeeMap = (Map<String,EmployeeVO>)session.getAttribute(EMPLOYEES_IN_SESSION);
					
					if(employeeMap != null){
						EmployeeVO employee= employeeMap.get(id);
						employeeMap.remove(id);
						System.out.println("Successfully Removed Employee by id " + id);
					}
				}
}
