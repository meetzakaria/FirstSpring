package com.zakaria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zakaria.model.Employee;
import com.zakaria.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@PostMapping
	public Employee saveEmp(@RequestBody Employee employee) {
		Employee saveEmp = service.saveEmployee(employee);
		return saveEmp;
	}

	@GetMapping("/{id}")
	public Employee getEmpById(@PathVariable int id) {
		Employee savedEmp = service.getEmpById(id);
		return savedEmp;
	}

	@GetMapping
	public List<Employee> getAllEmployee() {
		List<Employee> getAllEmp = service.getAllEmployee();
		return getAllEmp;
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}

	@PutMapping("/{id}")
	public Employee updateEmp(@PathVariable int id, @RequestBody Employee employee) {
		Employee updated = service.updateEmp(id, employee);
		return updated;
	}

}
