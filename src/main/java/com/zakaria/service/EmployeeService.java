package com.zakaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zakaria.model.Employee;
import com.zakaria.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	public Employee saveEmployee(Employee employee) {
		int save = repository.save(employee);
		return getEmpById(save);
	}

	public Employee getEmpById(int id) {
		Optional<Employee> byId = repository.findById(id);
		return byId.get();
	}

	public List<Employee> getAllEmployee() {
		List<Employee> all = repository.findAll();
		return all;
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

	public Employee updateEmp(int id, Employee employee) {
		employee.setId(id);
		repository.update(employee);
		return getEmpById(id);
	}

}