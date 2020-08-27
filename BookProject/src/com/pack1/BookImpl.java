package com.pack1;

import java.util.Scanner;

import com.pack2.BookException;
import com.pojo.Book;


public class BookImpl implements BookStore{
	@Override
	public Book[] getBooks() {
		Book[]books=new Book[3];
		long  isbn;
		String name,publication,author;
		 double price;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter details of  books");
		for(int i=0;i<3;i++){
			System.out.print("Enter isbn:");
			isbn=sc.nextLong();
			System.out.print("Enter name:");
			name=sc.next();
			System.out.print("Enter price:");
			price=sc.nextDouble();
			System.out.print("Enter publication:");
			publication=sc.next();
			System.out.print("Enter author:");
			author=sc.next();
			books[i]=new Book(isbn,name,price,publication,author);
		}
			
		return books;
	}
	@Override
	public Book findBookById(Book[] books, long ID) {
		
		for(Book book:books){
			if(book.getIsbn()==ID)
			return book;
		}
		try{
         throw new BookException("Book not found for given id");
	}
		catch(BookException b){
			b.printStackTrace();
		}
		return new Book();
	}
	@Override
	public Book findBookByName(Book[] books, String name)  {
		for(Book book:books){
			if(book.getName().equals(name))
			return book;
		}
		try{
	         throw new BookException("Book not found for given name");
		}
			catch(BookException b){
				b.printStackTrace();
			}
			return new Book();
	}
	@Override
	public Book updateBook(Book[] books, long ID, double price)  {
	
		for(Book book:books){
			if(book.getIsbn()==ID){
			book.setPrice(price);
			return book;
		}
		}
		try{
	         throw new BookException("Book not found for given id .. cannot update");
		}
			catch(BookException b){
				b.printStackTrace();
			}
			return new Book();
	}
	@Override
	public void displayBooks(Book[] books) {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("isbn"+"\t"+"name"+"\t\t"+"price"+"\t"+"publication"+"\t"+"author");
	for(Book book:books){
		System.out.println(book);
	}
	System.out.println("-----------------------------------------------------------------");
	}
}