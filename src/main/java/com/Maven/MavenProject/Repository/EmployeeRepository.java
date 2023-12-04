package com.Maven.MavenProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Maven.MavenProject.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
