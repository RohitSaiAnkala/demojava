package com.impl;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.io.EmployeeOperations;
import com.pojo.Employee;

public class EmployeeOperationsImpl implements EmployeeOperations {

	@Override
	public boolean addEmployee(Employee employee) {
		//System.out.println("Employee:"+employee);
		EmpIOImpl emp=new EmpIOImpl();
		List<Employee>empList=new ArrayList<>();
			empList=emp.readFromFile();
			//System.out.println("before"+empList);
			empList.add(employee);
		//System.out.println("emplist"+empList);
			emp.addToFile(empList);
			empList=emp.readFromFile();
		//	System.out.println("after"+empList);
		return true;
	}

	@Override
	public Employee updateEmployee(int id, String name) {
		EmpIOImpl emp=new EmpIOImpl();
		List<Employee>empList=emp.readFromFile();
		for(Employee e: empList){
			if(e.getEmpId()==id){
				e.setEmpName(name);
				emp.addToFile(empList);
				return e;
			}
		}
		return new Employee();
	}

	@Override
	public Employee deleteEmployee(int id) {
		EmpIOImpl emp=new EmpIOImpl();
		List<Employee>empList=emp.readFromFile();
		for(Employee e: empList){
			if(e.getEmpId()==id){
				empList.remove(e);
				emp.addToFile(empList);
				return e;
			}
		}
		
		return new Employee();
	}

	@Override
	public Employee findEmployeeById(int id) {
		EmpIOImpl emp=new EmpIOImpl();
		List<Employee>empList=emp.readFromFile();
		for(Employee e: empList){
			if(e.getEmpId()==id){
				return e;
			}
		}
			return new Employee();
	}

	@Override
	public List<Employee> findAllEmployees() {
		EmpIOImpl emp=new EmpIOImpl();
		List<Employee>empList=emp.readFromFile();
		return empList;
	}
}
