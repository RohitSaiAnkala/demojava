import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.impl.EmpIOImpl;
import com.impl.EmployeeOperationsImpl;
import com.pojo.Employee;

public class TestEmployee {
public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<Employee>empList=new ArrayList<>();
		int choice,id,flag=0;
		String name;
		EmpIOImpl e1=new EmpIOImpl();
		EmployeeOperationsImpl e2=new EmployeeOperationsImpl();
		Employee e3=new Employee();
		while(true){
			System.out.println("MENU\n1.addEmployee\n2.update Employee\n3.findEmployeeById\n4.findAllEmployees\n5.deleteEmployee\n6.exit");
			System.out.print("Enter your choice:");
			choice=sc.nextInt();
			switch(choice){
			case 1:
				e3=e1.readFromUser();
				e2.addEmployee(e3);
				break;
			case 2:
				System.out.print("Enter id:");
				id=sc.nextInt();
				System.out.print("Enter name:");
				name=sc.next();
				e3=e2.updateEmployee(id, name);
				System.out.println(e3);
				break;
			case 3:
				System.out.print("Enter id:");
				id=sc.nextInt();
				e3=e2.findEmployeeById(id);
				System.out.println(e3);
				break;
			case 4:
				empList=e2.findAllEmployees();
				empList.forEach(System.out::println);
				break;
			case 5:
				System.out.print("Enter id:");
				id=sc.nextInt();
				e3=e2.deleteEmployee(id);
				System.out.println(e3);
				break;
			case 6:
				flag=1;
				break;
	}
			if(flag==1)
				break;
		}
}
}
