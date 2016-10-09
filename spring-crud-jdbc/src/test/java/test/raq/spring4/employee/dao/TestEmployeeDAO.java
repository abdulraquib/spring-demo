package test.raq.spring4.employee.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.raq.spring4.employee.dao.EmployeeDAO;
import com.raq.spring4.employee.vo.EmployeeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-spring-datasource.xml" })
public class TestEmployeeDAO {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	private static EmployeeVO testEmployee1,testEmployee2,testEmployee3;
	
	
	@Before
    public void before() {
        System.out.println("@Before method will execute before every JUnit4 test");

		testEmployee1 = new EmployeeVO(10, "AbdulRaquib",40, 5000.20d);
		testEmployee2 = new EmployeeVO(11, "AbdulRaafay",10, 4000.21d);
		testEmployee3 = new EmployeeVO(12, "ShyanRifaz",1, 3000.55d);
		
    }
 
    @After
    public void after() {
        System.out.println("@After method will execute after every JUnit4 test");
    }

	@BeforeClass 
    public static void setUp() {
		
        System.out.println("@BeforeClass method will before the execution of the Junit4 tests");
    }
 
    @AfterClass 
    public static  void tearDown() {
        System.out.println("@AfterClass method will after the execution of the Junit4 tests");
    }


	@Test
	public void addEmployee() {
		try{
		employeeDAO.deleteAll();	
		employeeDAO.create(testEmployee1);
		employeeDAO.create(testEmployee2);
		employeeDAO.create(testEmployee3);

		
		}catch(Exception ex){
			fail("Unable to add employee "+ ex.toString());
			ex.printStackTrace();
		}
	}

	

	@Test
	public void updateEmployee() {
		try{
			testEmployee1.setName("testEmployee");	
			employeeDAO.update(testEmployee1);
		}catch(Exception ex){
			fail("Unable to add employee "+ ex.toString());
			ex.printStackTrace();
		}
	}

	
	
	@Test
	public void getEmployee() {
		int empId = testEmployee1.getId();
		try{
		EmployeeVO employee = employeeDAO.get(empId);
		assertNotNull(employee);
		assertEquals(empId, employee.getId());
		}catch(Exception ex){
			fail("Unable to get empId "+ empId);
			ex.printStackTrace();
		}
	}
	
	

	@Test
	public void listEmployees() {

		try{
		List<EmployeeVO> employeeList = employeeDAO.list();
		assertNotNull(employeeList);
		assertTrue(employeeList.size() > 0);
		System.out.println(employeeList.toString());

		}catch(Exception ex){
			fail("Unable to get list of Employee");
			ex.printStackTrace();
		}
	}
	
	@Test
	public void deleteEmployee() {
		int empId = testEmployee1.getId();
		try{
		employeeDAO.delete(empId);
		}catch(Exception ex){
			fail("Unable to delete empId "+ empId);
			ex.printStackTrace();
		}
	}
	
}
