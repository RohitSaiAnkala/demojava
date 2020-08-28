
package com.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.io.EmpIO;
import com.pojo.Address;
import com.pojo.Employee;


public class EmpIOImpl implements EmpIO {

	@Override
	public void addToFile(List<Employee> employees) {
		try(FileOutputStream fo=new FileOutputStream("mydata.txt");
				ObjectOutputStream oo=new ObjectOutputStream(fo);){
			oo.writeObject(employees);
//				for(Employee emp: employees){
//			      oo.writeObject(emp);
//		} 
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println("Add to file:"+employees);
		return;
	}

	@Override
	public List<Employee> readFromFile(){
		List<Employee>l=new ArrayList<>();
		try(FileInputStream fi=new FileInputStream("mydata.txt");){
			if(fi.available()==0)
				return l;
			ObjectInputStream oi=new ObjectInputStream(fi);
//			while(fi.available()!=0){
			Object o=oi.readObject();
			l=(List)o;
			//l.add((Employee) data);
			} catch (FileNotFoundException|ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		//System.out.println("list"+l);
		return l;
	}

	@Override
	public Employee readFromUser() {
		String city,state,pincode,empName;
		int empId;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter id:");
		empId=sc.nextInt();
		System.out.print("Enter name:");
		empName=sc.next();
		System.out.print("Enter city:");
		city=sc.next();
		System.out.print("Enter state:");
		state=sc.next();
		System.out.print("Enter pincode:");
		pincode=sc.next();
		Address address=new Address(city,state,pincode);
		Employee e=new Employee(empId,empName,address);
		return e;
	}

	@Override
	public void displayToUser(Employee emp) {
	System.out.println(emp);
	}

}
