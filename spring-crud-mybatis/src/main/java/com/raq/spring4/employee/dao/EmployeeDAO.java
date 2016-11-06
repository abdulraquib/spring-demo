package com.raq.spring4.employee.dao;

import java.util.List;

import com.raq.spring4.employee.vo.EmployeeVO;

public interface EmployeeDAO {
	
	public void create(EmployeeVO employee);
	
	public void update(EmployeeVO employee);
    
    public void delete(int empId);
     
    public EmployeeVO get(int empId);
     
    public List<EmployeeVO> list();
    
    public void deleteAll();
}
