package com.MyCVOnline.model.service.Implementation;

import java.util.ArrayList;

import com.MyCVOnline.model.CompanyEmployee;
import com.MyCVOnline.model.dao.CompanyEmployeeDAO;
import com.MyCVOnline.model.service.CompanyEmployeeService;

public class CompanyEmployeeServiceImpl implements CompanyEmployeeService {

	CompanyEmployeeDAO dao;

	@Override
	public void insertEmployee(CompanyEmployee employee) {
		// TODO Auto-generated method stub
		dao.insertEmployee(employee);
	}

	@Override
	public void deleteEmployee(String username) {
		// TODO Auto-generated method stub
		dao.deleteEmployee(username);
	}

	@Override
	public CompanyEmployee retreiveEmployee(String username) {
		// TODO Auto-generated method stub
		return dao.retreiveEmployee(username);
	}

	@Override
	public void updateEmployee(CompanyEmployee employee) {
		// TODO Auto-generated method stub

		CompanyEmployee entity = dao.retreiveEmployee(employee.getUsername());

		if (entity != null) {

			entity.setCompany(employee.getCompany());
			entity.setFullName(employee.getFullName());
			entity.setUsername(employee.getUsername());
			entity.setPassword(employee.getPassword());

			dao.updateEmployee(employee);

		}

	}

	@Override
	public ArrayList<CompanyEmployee> retreiveEmployees() {
		// TODO Auto-generated method stub
		return dao.retreiveEmployees();
	}

}
