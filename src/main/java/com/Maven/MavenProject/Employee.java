package com.Maven.MavenProject;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToMany
	@JoinTable(name = "employeeaddress", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "addressid"))
	private Set<EmployeeAddress> authors = new HashSet<>();

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<EmployeeAddress> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<EmployeeAddress> authors) {
		this.authors = authors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
