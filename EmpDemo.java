package com.demo;

import java.util.Scanner;

class Employee{
	private int empno;
	private String ename;
	private double salary;
	Employee(int empno,String ename,double salary){
		this.empno=empno;
		this.ename=ename;
		this.salary=salary;
	}	
	Employee(){
		
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
class EmpManager {
	int count=100,current=0;
private Employee arr[]=new Employee[count];
public void create(Employee e) {
	arr[current]=e;
	current++;
}
public void update(int itemno,Employee e) {
arr[itemno-1]=e;
}

public void print() {
	System.out.println("---------------------------------------------------------");
	System.out.println("Emp No			Emp Name	    Salary");
	for(int j=0;j<current;j++) {
		System.out.println(arr[j].getEmpno()+"			"+arr[j].getEname()+"		    "+arr[j].getSalary());
	}
}
public void delete(int empno) {
	int i,flag=0;
	for(i=0;i<current;i++) {
		if(arr[i].getEmpno()==empno) {
			flag=1;
			break;
		}
	}
	if(flag==0) {
		System.out.println("No Record found with given empno");
		return;
	}
	for(int j=i+1;j<current;j++) {
		arr[j-1]=arr[j];
	}
	current--;
}

}
public class EmpDemo{
	public static void main(String[] args) {
		EmpManager emp=new EmpManager();
		Scanner sc=new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("---------------------------------------------------------");
			System.out.println("MENU");
			System.out.println("1.CREATE"+"\n"+"2.UPDATE"+"\n"+"3.DELETE"+"\n"+"4.DISPLAY"+"\n"+"5.EXIT");
			System.out.println("---------------------------------------------------------");
			System.out.print("Enter your choice:");
			choice=sc.nextInt();
			if(choice==5)
				break;
			switch(choice) {
			case 1: 
				System.out.print("Enter employee details:");
				Employee e=new Employee(sc.nextInt(),sc.next(),sc.nextDouble());
				emp.create(e);
				break;
			case 2:
				System.out.print("Enter itemno and employee details to be updated:");
				int itemno=sc.nextInt();
				Employee em=new Employee(sc.nextInt(),sc.next(),sc.nextDouble());
				emp.update(itemno, em);
				break;
			case 3:
				System.out.print("Enter employee number to be deleted:");
				int empno=sc.nextInt();
				emp.delete(empno);
				break;
			case 4:
				emp.print();
				break;
			default:
				break;				
			}
		}
		System.out.println("Exited Succesfully");
	}

}
