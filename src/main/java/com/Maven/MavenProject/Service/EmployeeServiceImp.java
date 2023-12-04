package com.Maven.MavenProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Maven.MavenProject.Employee;
import com.Maven.MavenProject.EmployeeAddress;
import com.Maven.MavenProject.Exception.AddressNotFoundException;
import com.Maven.MavenProject.Exception.EmployeeNotFoundException;
import com.Maven.MavenProject.Repository.EmployeeAddressRepository;
import com.Maven.MavenProject.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository empRep;
	
	@Autowired
	EmployeeAddressRepository addressRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return empRep.findAll();
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return empRep.save(emp);
	}

	@Override
	public Employee modifyEmployee(Employee emp) {
		Employee Existingemp = empRep.findById(emp.getId())
				.orElseThrow(() -> new NullPointerException("No Employee with This" + emp.getId() + " Id"));
		Existingemp.setEmail(emp.getEmail());
		return empRep.save(Existingemp);

	}

	@Override
	public void deleteEmployee(long id) {
		Employee Existingemp = empRep.findById(id)
				.orElseThrow(() -> new NullPointerException("No Employee with This" + id + " Id"));
		empRep.delete(Existingemp);

	}

	@Override
	public EmployeeAddress getEmployeeAddress(long id) throws EmployeeNotFoundException , AddressNotFoundException {
		
		Optional<Employee> emp = empRep.findById(id);
		
		if(!emp.isPresent()) {
			 throw new EmployeeNotFoundException("Employee Not exists");
		} else {
			Optional<EmployeeAddress> address = addressRepository.findById(id);
			if (!address.isPresent()) {
				 throw new AddressNotFoundException("Employee Not exists");
			}
			return address.get();
		}
	}
}
