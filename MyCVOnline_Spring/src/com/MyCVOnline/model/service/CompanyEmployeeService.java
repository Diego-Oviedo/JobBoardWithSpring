package com.MyCVOnline.model.service;

import java.util.ArrayList;
import com.MyCVOnline.model.*;

public interface CompanyEmployeeService {

	public void insertEmployee(CompanyEmployee employee);

	public void deleteEmployee(String username);

	public CompanyEmployee retreiveEmployee(String username);

	public void updateEmployee(CompanyEmployee employee);

	public ArrayList<CompanyEmployee> retreiveEmployees();

}
