package com.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao dao;

	@Override
	public EmployeeDao findbyId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void saveEmployee(EmployeeDao emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(EmployeeDao emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(EmployeeDao emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmployeeDao> findAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDao findEmployeeBySsn(EmployeeDao emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmployeeSsnUnique(int id, String ssn) {
		// TODO Auto-generated method stub
		return false;
	}

}
