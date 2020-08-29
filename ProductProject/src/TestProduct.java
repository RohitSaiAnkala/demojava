import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.impl.ProductDAOImpl;
import com.impl.ProductIOImpl;
import com.pojo.Product;

public class TestProduct {
	public static void display(List<Product>products){
		for(Product product:products){
			System.out.println(product);
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice,flag=0,pId,quantity;
		double price;
		boolean check;
		String category,pName;
		Product product=new Product();
		List<Product>products=new ArrayList<>();
		ProductIOImpl productImpl=new ProductIOImpl();
		ProductDAOImpl productDAOImpl=new ProductDAOImpl();
		while(true){
			System.out.println("MENU\n1.add product\n2.update product by price\n"
					+ "3.update product by quantity\n4.find product by Id\n5.find all products by category"
					+ "\n6.find all products"+"\n7.exit");
			System.out.print("Enter your choice:");
			choice=sc.nextInt();
			switch(choice){
			case 1:
				product=productImpl.getProduct();
				productDAOImpl.addProduct(product);
				productImpl.displayProduct(product);
				break;
			case 2:
				System.out.print("Enter product id:");
				pId=sc.nextInt();
				System.out.print("Enter product price:");
				price=sc.nextDouble();
				check=productDAOImpl.updateProduct(pId, price);
				if(check==false)
					System.out.println("Cannot update.. no product id exists with given value");
				break;
			case 3:
				System.out.print("Enter product id:");
				pId=sc.nextInt();
				System.out.print("Enter product quantity:");
				quantity=sc.nextInt();
				check=productDAOImpl.updateProduct(pId, quantity);
				if(check==false)
					System.out.println("Cannot update.. no product id exists with given value");
				break;
			case 4:
				System.out.print("Enter product id:");
				pId=sc.nextInt();
				product=productDAOImpl.findById(pId);
				if(product.getpId()!=0)
			    productImpl.displayProduct(product);
			    break;
			case 5:
				System.out.print("Enter product category:");
				category=sc.next();
				products=productDAOImpl.findAllByCategory(category);
				if(products.size()>0)
				display(products);
				break;
			case 6:
				products=productDAOImpl.findAll();
				display(products);
				break;
			case 7:
					flag=1;
					break;
			}
			if(flag==1)
				break;
			}
	
		}

}
