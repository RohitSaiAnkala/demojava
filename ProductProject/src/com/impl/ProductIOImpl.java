package com.impl;

import java.util.Scanner;

import com.io.ProductIO;
import com.pojo.Product;

public class ProductIOImpl implements ProductIO {

	@Override
	public Product getProduct() {
		Scanner sc=new Scanner(System.in);
		int pId,quantity;
		String pName,category;
		double price;
		System.out.print("Enter product id:");
		pId=sc.nextInt();
		System.out.print("Enter product name:");
		pName=sc.next();
		System.out.print("Enter product price:");
		price=sc.nextDouble();
		System.out.print("Enter product quantity:");
		quantity=sc.nextInt();
		System.out.print("Enter product category:");
		category=sc.next();
		Product p=new Product(pId,pName,price,quantity,category);
		return p;
	}

	@Override
	public void displayProduct(Product product) {
		System.out.println(" productId:-"+product.getpId()+"  productName:-"+product.getpName()
		+"  productPrice:-"+product.getPrice()+"  productQuantity:-"+product.getQuantity()+" productCategory:-"+product.getCategory());
	}

}
