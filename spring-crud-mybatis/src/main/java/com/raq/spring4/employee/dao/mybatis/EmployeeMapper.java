package com.raq.spring4.employee.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.raq.spring4.employee.vo.EmployeeVO;

public interface EmployeeMapper {

	final String GET_EMPLOYEE_ID_SQL = "SELECT * FROM springworkshop.EMPLOYEE WHERE id=  #{empId}";
	final String GET_ALL_EMPLOYEES_SQL = "SELECT * FROM springworkshop.EMPLOYEE";
	final String DELETE_EMPLOYEE_SQL = "DELETE FROM springworkshop.EMPLOYEE WHERE id= #{empId}";
	final String INSERT_EMPLOYEE_SQL = "INSERT INTO springworkshop.EMPLOYEE (id, name, age, salary)"
			+ " VALUES (#{id},#{name}, #{age}, #{salary})";
	final String UPDATE_EMPLOYEE_SQL = "UPDATE springworkshop.EMPLOYEE SET name=#{name}, age=#{age}, salary=#{salary} "
			+ "WHERE id=#{id}";

	final String DELETE_ALL_EMPLOYEE_SQL = "DELETE FROM springworkshop.EMPLOYEE";

	

	@Select(GET_EMPLOYEE_ID_SQL)
	@Results(value = { @Result(property = "id", column = "ID", id = true),
			@Result(property = "name", column = "NAME"),
			@Result(property = "age", column = "AGE"),
			@Result(property = "salary", column = "SALARY")

	})
	public EmployeeVO get(@Param("empId") int empId);

	@Select(GET_ALL_EMPLOYEES_SQL)
	@Results(value = { @Result(property = "id", column = "ID", id = true),
			@Result(property = "name", column = "NAME"),
			@Result(property = "age", column = "AGE"),
			@Result(property = "salary", column = "SALARY") })
	public List<EmployeeVO> list();

	@Delete(DELETE_EMPLOYEE_SQL)
	public void delete(@Param("empId") int empId);

	@Insert(INSERT_EMPLOYEE_SQL)
	public void insert(EmployeeVO employee);

	@Update(UPDATE_EMPLOYEE_SQL)
	public void update(EmployeeVO employee);

	@Delete(DELETE_ALL_EMPLOYEE_SQL)
	public void deleteAll();

}
