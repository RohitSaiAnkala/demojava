package com.demo;
import java.util.Scanner;
class Emp{
	private int empno;
	private String ename;
	private double salary;
	Emp(int empno,String ename,double salary){
		this.empno=empno;
		this.ename=ename;
		this.salary=salary;
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
public class Lab3 {
public static void main(String[] args) {
		Emp list[]=new Emp[5];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<5;i++) {
			Emp emp=new Emp(sc.nextInt(),sc.next(),sc.nextDouble());
		    list[i]=emp;
		}
		for(int i=0;i<5;i++) {
			System.out.println("Details of Employee "+(i+1));
			System.out.println("empno:"+list[i].getEmpno());
			System.out.println("empname:"+list[i].getEname());
			System.out.println("empsal:"+list[i].getSalary());
		}
	}
}
