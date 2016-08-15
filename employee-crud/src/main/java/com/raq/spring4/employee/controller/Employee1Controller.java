package com.raq.spring4.employee.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.raq.spring4.employee.vo.EmployeeVO;

//All about spring controllers, request Mapping and redirection, Exception Handling
//http://howtodoinjava.com/spring/spring-core/how-to-use-spring-component-repository-service-and-controller-annotations/
//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-ann-arguments
//http://javapapers.com/spring/spring-annotation-based-controllers/
//https://dzone.com/tutorials/java/spring/spring-annotation-controller-1.html
//http://www.codeproject.com/Articles/272736/Understanding-Annotations-in-Java
//http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html
//https://dzone.com/articles/how-annotations-work-java
//http://viralpatel.net/blogs/spring-4-mvc-rest-example-json/
//http://www.concretepage.com/spring/spring-mvc/spring-mvc-sessionattributes-cookievalue-annotation-example

//TODO
//1. employee crud - jdbc template
//2. emmployee crud - jdbc error handling.
//3. Tiles, and Thymeleaf
//2. employee crud - mybattis mapper
//3. employee crud - rest service - json
//4. employee crud - spring security
//5. employee crud - spring jms oracle
//6. Angular JS,bootstrap
//7. Remote Debugging with JBOSS and Tomcat


@Controller
@RequestMapping("/employee1")
//@SessionAttributes(value = "employeevo", types = {EmployeeVO.class})
public class Employee1Controller {
	
	private static final String VIEW_EMPLOYEE = "employee";

	private static final String CREATE_EMPLOYEE = "employee";
	private static final String RETRIEVE_EMPLOYEE = VIEW_EMPLOYEE;
	private static final String UDPATE_EMPLOYEE = CREATE_EMPLOYEE;
	private static final String DELETE_EMPLOYEE = "employee";
	private static final String DEFAULT = "default";

	private final static org.slf4j.Logger logger = LoggerFactory
			.getLogger(Employee1Controller.class);

	
	


	//http://localhost:1975/employee-crud-jdbc/employee/viewEmployee
	@RequestMapping(value = {"/viewEmployee"}, method = RequestMethod.GET)
	public String viewEmployee(ModelMap model,HttpSession session) {
		model.addAttribute("employeeHeader", "Welcome to Employee Page");
		model.addAttribute("action", "viewEmployee");

		EmployeeVO employeeVO = (EmployeeVO)session.getAttribute("employeeVOInSession");
		if(employeeVO == null){
			employeeVO = new EmployeeVO();
		}
		model.addAttribute("employeevo", employeeVO);

		logger.debug("model.getAttribute(action) "
				+ model.get("action"));
		logger.debug("employee from session  "
				+ employeeVO);
		return "viewEmployee";
	}

	
	//http://localhost:1975/employee-crud-jdbc/employee/viewEmployee
	@RequestMapping(value = {"/viewEmployee1","/viewEmployee1/show"}, method = RequestMethod.GET)
	public String _viewEmployee(ModelMap model) {
		model.addAttribute("employeeHeader", "Welcome to Employee Page");
	
		model.addAttribute("action", "viewEmployee");
		model.addAttribute("employeevo", new EmployeeVO());
		
		logger.debug("model.getAttribute(action) "
				+ model.get("action"));
		return RETRIEVE_EMPLOYEE;
	}
	
	//http://localhost:1975/employee-crud-jdbc/employee/retrieveEmployee/11
	//http://localhost:1975/employee-crud-jdbc/employee/retrieveEmployee/12
	@RequestMapping(value = "/retrieveEmployee/{id}",method = RequestMethod.GET)
	public String retrieveEmployee(@PathVariable("id") int id, ModelMap model) {
	
		logger.debug("model.getAttribute(action) "
				+ model.get("action"));
		
		
		model.addAttribute("action", "retrieveEmployee id "+ id);

		
		logger.debug("model.getAttribute(action) "
				+ model.get("action"));
		return DEFAULT;
	}

	
	//http://localhost:1975/employee-crud-jdbc/employee/createEmployee?id=10&age=20
	//will work only if the parameters are passed
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employeevo")EmployeeVO employee,ModelMap model,HttpSession session) {
		model.addAttribute("action", "addEmployee");
		logger.debug("model.getAttribute(addEmployee) "
				+ model.get("addEmployee"));
		logger.debug("-- Add employee invoked"
				+ employee);
		
		session.setAttribute("employeeVOInSession", employee);
		
		return VIEW_EMPLOYEE;
	}

	
	//http://localhost:1975/employee-crud-jdbc/employee/createEmployee?id=10&age=20
	//will work only if the parameters are passed
	@RequestMapping(value = "/createEmployee", method = RequestMethod.GET)
	public String createEmployee(@RequestParam("id") int id,@RequestParam("age") String age,ModelMap model) {
		
		model.addAttribute("action", "createEmployee");

		logger.debug("model.getAttribute(action) "
				+ model.get("action"));

		logger.debug("Param Id " + id + "Param age" + age);
	
		return CREATE_EMPLOYEE;
	}
	

	//http://localhost:1975/employee-crud-jdbc/employee/updateEmployee
	//http://localhost:1975/employee-crud-jdbc/employee/updateEmployee?id=10&name=abdul
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
	public String updateEmployee(@RequestParam Map<String,String> params,ModelMap model) {
		
		String id = params.get("id");
		String name = params.get("name");

		logger.debug("Request param id " + id +"name : " + name);
		model.addAttribute("action", "updateEmployee");
		logger.debug("model.getAttribute(action) "
				+ model.get("action"));
		return DEFAULT;
	}
	
	//http://localhost:1975/employee-crud-jdbc/employee/deleteEmployee
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public String deleteEmployee(ModelMap model) {
		model.addAttribute("action", "deleteEmployee");
		logger.debug("model.getAttribute(action) "
				+ model.get("action"));
		return DELETE_EMPLOYEE;
	}
	
	/*
	 * @RequestMapping(value = "/{name}", method = RequestMethod.GET) public
	 * String welcomeName(@PathVariable String name, ModelMap model) {
	 * 
	 * model.addAttribute("name", "Welcome " + name);
	 * logger.debug("model.getAttribute(message) " + model.get("name")); return
	 * VIEW_GREETING; }
	 */
	
	//http://localhost:1975/employee-crud-jdbc/employee
	@RequestMapping()
	@ResponseBody
	public String defaultMethod(){
		logger.debug("defualt Method invoked" );
		return RETRIEVE_EMPLOYEE;
	}
	
	//make sure we are catching all the client requests even though there are no matching handler methods
	//http://localhost:1975/employee-crud-jdbc/employee/address?name=10
	//http://localhost:1975/employee-crud-jdbc/employee/employee
	@RequestMapping("*")
	@ResponseBody 
	public String fallbackMethod(){
		logger.debug("fallbackMethod  invoked" );
		return RETRIEVE_EMPLOYEE;
	}
	
	//http://localhost:1975/employee-crud-jdbc/employee/testHttpRequest?id=10
	@RequestMapping(value="/testHttpRequest",method = RequestMethod.GET)
	@ResponseBody
	public String testHttpRequest(ModelAndView uiModel,HttpServletRequest request){
		String id = (String)request.getAttribute("id");
		
		String idParam = request.getParameter("id");
		
		logger.debug("testHttpRequest invoked idParam from HttpServletRequest"+ idParam );
		
		logger.debug("testHttpRequest invoked id from HttpServletRequest"+ id );
		return RETRIEVE_EMPLOYEE;
	}

	final static String COUNTER = "counter";
	
	//http://localhost:1975/employee-crud-jdbc/employee/testHttpSession
	@RequestMapping(value="/testHttpSession",method = RequestMethod.GET)
	@ResponseBody
	public String testHttpSession(HttpSession session){
		String counter = (String)session.getAttribute(COUNTER);
		if(counter == null){
			session.setAttribute(COUNTER, Integer.toString(1));
		}
		if(counter != null){
			int incrementedCounter = Integer.parseInt(counter)+1;
			session.setAttribute(COUNTER, Integer.toString(incrementedCounter));
		}
		logger.debug("testHttpSession invoked counter from HttpSession"+ counter );
		return RETRIEVE_EMPLOYEE;
	}

	
	
}
