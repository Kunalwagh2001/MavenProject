package com.Maven.MavenProject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Maven.MavenProject.Employee;
import com.Maven.MavenProject.EmployeeAddress;
import com.Maven.MavenProject.Exception.AddressNotFoundException;
import com.Maven.MavenProject.Exception.EmployeeNotFoundException;

@Service
public interface EmployeeService {

	List<Employee> getAllEmployee();

	Employee addEmployee(Employee emp);

	Employee modifyEmployee(Employee emp);

	void deleteEmployee(long id);

	EmployeeAddress getEmployeeAddress(long id) throws EmployeeNotFoundException, AddressNotFoundException ;

}
