package com.raq.spring4.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.raq.spring4.employee.vo.EmployeeVO;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private JdbcTemplate jdbcTemplate;
	 
    public EmployeeDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
 

	@Override
	public void create(EmployeeVO employee) {
	        // insert
	        String sql = "INSERT INTO springworkshop.EMPLOYEE (id, name, age, salary)"
	                    + " VALUES (?,?, ?, ?)";
	        jdbcTemplate.update(sql,employee.getId(), employee.getName(), employee.getAge(),
	        		employee.getSalary());

	}
	
	@Override
	public void update(EmployeeVO employee) {
	
		if (employee.getId() > 0) {
	        // update
	        String sql = "UPDATE springworkshop.EMPLOYEE SET name=?, age=?, salary=? "
	                    + "WHERE id=?";
	        jdbcTemplate.update(sql, employee.getName(), employee.getAge(),
	        		employee.getSalary(),  employee.getId());
	    } 

	}
	

	@Override
	public void delete(int empId) {
		String sql = "DELETE FROM springworkshop.EMPLOYEE WHERE id=?";
	    jdbcTemplate.update(sql, empId);

	}
	
	@Override
	public void deleteAll() {
		String sql = "DELETE FROM springworkshop.EMPLOYEE";
	    jdbcTemplate.update(sql);
	}

	@Override
	public EmployeeVO get(int empId) {
	
		  String sql = "SELECT * FROM springworkshop.EMPLOYEE WHERE id=" + empId;
		    return jdbcTemplate.query(sql, new ResultSetExtractor<EmployeeVO>() {
		 
		        @Override
		        public EmployeeVO extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	EmployeeVO employee = new EmployeeVO();
		            	employee.setId(rs.getInt("id"));
		            	employee.setName(rs.getString("name"));
		            	employee.setAge(rs.getInt("age"));
		            	employee.setSalary(rs.getDouble("salary"));
		            	return employee;
		            }
		            return null;
		        }
		    });
		
	}

	@Override
	public List<EmployeeVO> list() {
		   String sql = "SELECT * FROM springworkshop.EMPLOYEE";
		    List<EmployeeVO> listEmployee = jdbcTemplate.query(sql, new RowMapper<EmployeeVO>() {
		 
		        @Override
		        public EmployeeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	EmployeeVO employee = new EmployeeVO();
	            	employee.setId(rs.getInt("id"));
	            	employee.setName(rs.getString("name"));
	            	employee.setAge(rs.getInt("age"));
	            	employee.setSalary(rs.getDouble("salary"));
	            	return employee;
		        }
		 
		    });
		 
		    return listEmployee;
		
	}

}
