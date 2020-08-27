import java.util.List;
import java.util.Scanner;

import com.impl.PersonImpl;
import com.pojo.Person;

public class DemoPerson {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int choice,pId,flag=0;
	String name;
	
	PersonImpl person=new PersonImpl();
	List<Person>persons=person.getPersons();
	while(true){
		System.out.println("MENU\n1.add Data\n2.update person\n3.find person\n4.Remove person\n5.Display all\n6.exit");
		System.out.print("Enter your choice:");
		choice=sc.nextInt();
		switch(choice){
		case 1:
			  System.out.print("Enter pId:");
			  pId=sc.nextInt();
			  System.out.print("Enter name:");
			  name=sc.next();
			  Person p=new Person(pId,name);
			  person.addPerson(persons, p);
			  break;
		case 2:
			System.out.println("Enter id:");
			pId=sc.nextInt();
			 System.out.println("Enter name:");
			 name=sc.next();
			 person.updatePerson(pId, persons, name);
			 break;
		case 3:
			System.out.println("Enter id:");
			pId=sc.nextInt();
			Person p1=person.findById(pId, persons);
			System.out.println(p1);
			break;
		case 4:
			System.out.println("Enter id:");
			pId=sc.nextInt();
			person.removePerson(pId, persons);
			break;
		case 5:
			person.displayPersons(persons);
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
