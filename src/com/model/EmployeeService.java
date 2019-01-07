package com.model;

import java.util.List;

import com.dao.EmployeeDao;

public interface EmployeeService {

	EmployeeDao findbyId(int id);

	void saveEmployee(EmployeeDao emp);

	void updateEmployee(EmployeeDao emp);

	void deleteEmployee(EmployeeDao emp);

	List<EmployeeDao> findAllEmployee();

	EmployeeDao findEmployeeBySsn(EmployeeDao emp);

	boolean isEmployeeSsnUnique(int id, String ssn);
}
