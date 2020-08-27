package com.pack1;

import java.util.Scanner;

import com.pack2.BookException;
import com.pojo.Book;

public interface BookStore {
	Book[] getBooks();
	Book findBookById(Book []books , long ID) ;
	Book findBookByName(Book []books , String name) ; 
	Book updateBook(Book []books, long ID,double price);
	void displayBooks(Book[] books);	
}




