package com.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ProductDAO;
import com.exceptions.ProductNotFoundException;
import com.pojo.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public int addProduct(Product product) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott1", "tiger1");
			String insertProduct="insert into product values(?,?,?,?,?)";
			PreparedStatement  ps=con.prepareStatement(insertProduct);
			ps.setInt(1, product.getpId());
			ps.setString(2,product.getpName());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getQuantity());
			ps.setString(5,product.getCategory());
			int inserted=ps.executeUpdate();
			if(inserted>0){
				System.out.println("Row Inserted");
				return 1;
			}
			else{
//				System.out.println("Row not Inserted");
				throw new ProductNotFoundException("Row Not Inserted");
			}
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public boolean updateProduct(int productId, double price) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott1", "tiger1");
			String updateProduct="update product set price=? where pId=?";
			PreparedStatement  ps=con.prepareStatement(updateProduct);
			ps.setDouble(1, price);
			ps.setInt(2, productId);
			int updated=ps.executeUpdate();
			if(updated>0){
				System.out.println("Row Updated");
				return true;
			}
			else{
				System.out.println("Row not Updated");
				throw new ProductNotFoundException("No product found .. cannot update");
			}
		}
		 catch (ClassNotFoundException|SQLException e) {
				e.printStackTrace();
			} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateProduct(int productId, int quantity) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott1", "tiger1");
			String updateProduct="update product set quantity=? where pId=?";
			PreparedStatement  ps=con.prepareStatement(updateProduct);
			ps.setInt(1, quantity);
			ps.setInt(2, productId);
			int updated=ps.executeUpdate();
			if(updated>0){
				System.out.println("Row Updated");
				return true;
			}
			else{
				//System.out.println("Row not Updated");
				throw new ProductNotFoundException("No product found .. cannot update");
			}
		}
		 catch (ClassNotFoundException|SQLException e) {
				e.printStackTrace();
			} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product findById(int productId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott1", "tiger1");
			String findProduct="select * from product where pId=?";
			PreparedStatement  ps=con.prepareStatement(findProduct);
			ps.setInt(1, productId);
			ResultSet set=ps.executeQuery();
			int pId,quantity;
			String pName,category;
			double price;
			Product p=new Product();
			while(set.next()){
				pId=set.getInt("pId");
				pName=set.getString("pName");
				price=set.getDouble("price");
				quantity=set.getInt("quantity");
				category=set.getString("category");
			p=new Product(pId,pName,price,quantity,category);
			}
			if(p.getpId()==0){
				try {
					throw new ProductNotFoundException("Product Not found for given id");
				} catch (ProductNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return p;
			
		}
		 catch (ClassNotFoundException|SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Product> findAll() {
		List<Product>products=new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott1", "tiger1");
			String findProduct="select * from product";
			PreparedStatement  ps=con.prepareStatement(findProduct);
            ResultSet set=ps.executeQuery();
			int pId,quantity;
			String pName,category;
			double price;
			Product p=new Product();
			while(set.next()){
				pId=set.getInt("pId");
				pName=set.getString("pName");
				price=set.getDouble("price");
				quantity=set.getInt("quantity");
				category=set.getString("category");
				p=new Product(pId,pName,price,quantity,category);
			products.add(p);
			}
		}
			catch (ClassNotFoundException|SQLException e) {
				e.printStackTrace();
			}
		return products;
	}

	@Override
	public List<Product> findAllByCategory(String category) {
		List<Product>products=new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott1", "tiger1");
			String findProduct="select * from product where category=?";
			PreparedStatement  ps=con.prepareStatement(findProduct);
			ps.setString(1,category);
            ResultSet set=ps.executeQuery();
			int pId,quantity;
			String pName;
			double price;
			Product p=new Product();
			while(set.next()){
				pId=set.getInt("pId");
				pName=set.getString("pName");
				price=set.getDouble("price");
				quantity=set.getInt("quantity");
				p=new Product(pId,pName,price,quantity,category);
			    products.add(p);
			}
		}
			catch (ClassNotFoundException|SQLException e) {
				e.printStackTrace();
			}
		if(products.size()==0){
			try {
				throw new ProductNotFoundException("No product found for given category");
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return products;
	}

	

}
