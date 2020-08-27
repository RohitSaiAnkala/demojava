import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.pack1.BookImpl;
import com.pojo.Book;

public class TestBook {
public static void main(String[] args) throws InterruptedException {
	int choice,id,flag=0;
	String name;
	double price;
	Scanner sc=new Scanner(System.in);
	BookImpl b=new BookImpl();
	Book[]books=b.getBooks();
	Book book;
	while(true){
	System.out.println("MENU\n1.findById\n2.findByName\n3.updatePrice\n4.DisplayBooks\n5.exit");
	System.out.print("Enter your choice:");
	choice=sc.nextInt();
	switch(choice){
	case 1:
		  System.out.print("Enter book id:");
		  id=sc.nextInt();
		  book=b.findBookById(books, id);
		  if(book.getIsbn()==0){
			  System.out.println("No book found for the given id");
					TimeUnit.SECONDS.sleep(1);
		  }
		  else{
			  System.out.println("-----------------------------------------------------------------");
			  System.out.println("isbn"+"\t"+"name"+"\t\t"+"price"+"\t"+"publication"+"\t"+"author");
		  System.out.println(book);
		  System.out.println("-----------------------------------------------------------------");
		  }
		  break;
	case 2:
		System.out.print("Enter book name:");
		  name=sc.next();
		  book=b.findBookByName(books, name);
		  if(book.getIsbn()==0){
			  System.out.println("No book found for the given name");
					TimeUnit.SECONDS.sleep(1);
		  }
		  else{
			  System.out.println("-----------------------------------------------------------------");
			  System.out.println("isbn"+"\t"+"name"+"\t\t"+"price"+"\t"+"publication"+"\t"+"author");
		  System.out.println(book);
		  System.out.println("-----------------------------------------------------------------");
		  }
		  break;
	case 3:
		System.out.print("Enter book id:");
		id=sc.nextInt();
		System.out.print("Enter book price:");
		price=sc.nextDouble();
		book=b.updateBook(books, id, price);
			  if(book.getIsbn()==0){
				  System.out.println("No book found for the given id.. cannot update");
						TimeUnit.SECONDS.sleep(1);
			  }
			  else{
				  System.out.println("-----------------------------------------------------------------");
			 System.out.println("isbn"+"\t"+"name"+"\t\t"+"price"+"\t"+"publication"+"\t"+"author");
			  System.out.println(book);
			  System.out.println("-----------------------------------------------------------------");
			  }
		break;
	case 4:
		b.displayBooks(books);
		break;
	case 5:
		flag=1;
		break;
	}
	if(flag==1)
		break;
	
	}
}
}
