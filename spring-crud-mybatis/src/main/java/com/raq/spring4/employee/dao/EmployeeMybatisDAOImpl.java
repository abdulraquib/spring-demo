package com.raq.spring4.employee.dao;

import java.util.List;

import com.raq.spring4.employee.dao.mybatis.EmployeeMapper;
import com.raq.spring4.employee.vo.EmployeeVO;

public class EmployeeMybatisDAOImpl implements EmployeeDAO{

	
	private EmployeeMapper employeeMapper;

	public void setEmployeeMapper(EmployeeMapper employeeMapper) {
	  this.employeeMapper = employeeMapper;
	}
	
	@Override
	public void create(EmployeeVO employee) {
		employeeMapper.insert(employee);
		
	}

	@Override
	public void update(EmployeeVO employee) {
		if (employee.getId() > 0) {
		employeeMapper.update(employee);
		}
		
	}

	@Override
	public void delete(int empId) {
	  employeeMapper.delete(empId);
		
	}

	@Override
	public EmployeeVO get(int empId) {
		EmployeeVO employeeVO = employeeMapper.get(empId);
		System.out.println("employeeVO in MyBatis DAO " + employeeVO);
		return employeeVO;
	}

	@Override
	public List<EmployeeVO> list() {
		List<EmployeeVO> employeeVOList = employeeMapper.list();
		System.out.println("employeeVOList in MyBatis DAO " + employeeVOList);
		return employeeVOList;
	}

	@Override
	public void deleteAll() {
		employeeMapper.deleteAll();
		
	}

}
