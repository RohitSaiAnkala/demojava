package com.io;

import java.util.List;

import com.pojo.Employee;

public interface EmpIO {
	void addToFile(List<Employee>employees);
	  List<Employee> readFromFile();
	  Employee readFromUser();
	  void displayToUser(Employee emp);
}
