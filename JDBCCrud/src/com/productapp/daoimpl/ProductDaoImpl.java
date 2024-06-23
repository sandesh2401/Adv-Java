package com.productapp.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.productapp.dao.ProductDao;
import com.productapp.model.Product;
import com.productapp.utility.SqlUtil;

public class ProductDaoImpl implements ProductDao {

	@Override
	public int save(Product product) {
		int result = -1;
		try {
			SqlUtil.connectDb();
			String qry = "INSERT INTO product VALUES('"+product.getId()+"','"+product.getName()+"','"+product.getPrice()+"')";
			result = SqlUtil.insert(qry);
			SqlUtil.close();
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return result;
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = new ArrayList<Product>();
		try {
			SqlUtil.connectDb();
			String qry = "SELECT * FROM product";
			ResultSet rs = SqlUtil.fetch(qry);
			if(rs != null) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					float price = rs.getFloat("price");
					
					Product product = new Product(id, name, price);
					
					products.add(product);
				}
			}
			SqlUtil.close();
			
		} catch (Exception e) {
			System.out.println(e);
		} 
		
		return products;
	}

	@Override
	public Product getById(int id) {
		Product product = null;
		try {
			SqlUtil.connectDb();
			String qry = "SELECT * FROM product WHERE id="+id;
			ResultSet rs = SqlUtil.fetch(qry);
			if(rs != null) {
				if(rs.next()) {
				int productId = rs.getInt("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				
				product = new Product();
				product.setId(productId);
				product.setName(name);
				product.setPrice(price);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} 
		
		return product;
	}

	@Override
	public int remove(int id) {
		int result = -1;
		try {
			SqlUtil.connectDb();
			String qry = "DELETE FROM product WHERE id="+id;
			result = SqlUtil.delete(qry);
			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		} 
		return result;
	}

	@Override
	public int update(int id, Product product) {
		int result = -1;
		try {
			SqlUtil.connectDb();
			String qry = "UPDATE product SET id='"+product.getId()+"', name='"+product.getName()+"', price='"+product.getPrice()+"' WHERE id="+id;
			result = SqlUtil.update(qry);
			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		} 
		
		return result;
	}

	@Override
	public Product getByName(String name) {
		Product product = null;
		try {
			SqlUtil.connectDb();
			String qry = "SELECT * FROM product WHERE name='"+name+"'";
			ResultSet rs = SqlUtil.fetch(qry);
			if(rs != null) {
				if(rs.next()) {
				int id = rs.getInt("id");
				String pname = rs.getString("name");
				float price = rs.getFloat("price");
				
				product = new Product();
				product.setId(id);
				product.setName(pname);
				product.setPrice(price);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	

}
