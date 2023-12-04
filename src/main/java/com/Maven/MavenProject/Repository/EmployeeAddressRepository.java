package com.Maven.MavenProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Maven.MavenProject.EmployeeAddress;

public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, Long> {

}
