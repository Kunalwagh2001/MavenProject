package com.Maven.MavenProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Maven.MavenProject.Employee;
import com.Maven.MavenProject.EmployeeAddress;
import com.Maven.MavenProject.Exception.AddressNotFoundException;
import com.Maven.MavenProject.Exception.EmployeeNotFoundException;
import com.Maven.MavenProject.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	public EmployeeService empSer;

	@GetMapping("/employee")
	List<Employee> getAllEmployee() {
		return empSer.getAllEmployee();
	}
	
	@GetMapping("/employeeaddress")
	public EmployeeAddress getEmployeeAddress(@PathVariable(value="id") long id) throws EmployeeNotFoundException, AddressNotFoundException {
		return empSer.getEmployeeAddress(id);
	}

	@PostMapping("/employee")
	public Employee addNewEmployee(@RequestBody Employee emp) {
		return empSer.addEmployee(emp);
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateExistingEmployee(@PathVariable(value = "id") long id,@RequestBody Employee emp) {
		return ResponseEntity.ok(empSer.modifyEmployee(emp));
	}

	@DeleteMapping("/{id}")
	public String DeleteExistingEmployee(@PathVariable(value = "id") long id) {
		empSer.deleteEmployee(id);
		return "Employee Deleted";
	}
}
