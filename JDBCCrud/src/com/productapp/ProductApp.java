package com.productapp;

import java.util.List;
import java.util.Scanner;

import com.productapp.daoimpl.ProductDaoImpl;
import com.productapp.model.Product;

public class ProductApp {

//	public static void main(String[] args) {
//		
////		Product p = new Product(6,"Panel",6522);
////		
////		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
////		
////		int result = productDaoImpl.save(p);
////		System.out.println(result);
//		
////		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
////		
////		List<Product> productList = productDaoImpl.getAll();
////		
////		for(Product p : productList) {
////			System.out.println(p);
////		}
//		
////		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
////		
////		Product product = productDaoImpl.getById(2);
////		if(product != null) {
////			System.out.println(product);
////		}
////		else {
////			System.out.println("\"Product with given id not found !\"");	
////		}
//		
////		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
////		int result = productDaoImpl.remove(6);
////		System.out.println(result + " rows deleted");
//		
//		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
//		int result = productDaoImpl.update(2, new Product(2,"mouse",1000));
//		System.out.println(result);
//	}
		
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. View Product by ID");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. View Product by Name");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addProduct(scanner, productDaoImpl);
                    break;
                case 2:
                    viewAllProducts(productDaoImpl);
                    break;
                case 3:
                    viewProductById(scanner, productDaoImpl);
                    break;
                case 4:
                    updateProduct(scanner, productDaoImpl);
                    break;
                case 5:
                    deleteProduct(scanner, productDaoImpl);
                    break;
                case 6:
                    viewProductByName(scanner, productDaoImpl);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }

    private static void addProduct(Scanner scanner, ProductDaoImpl productDaoImpl) {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        float price = scanner.nextFloat();
        Product product = new Product(id, name, price);
        int result = productDaoImpl.save(product);
        if (result == 1) {
            System.out.println("Product added successfully!");
        } else {
            System.out.println("Failed to add product!");
        }
    }

    private static void viewAllProducts(ProductDaoImpl productDaoImpl) {
        List<Product> productList = productDaoImpl.getAll();
        if (productList.isEmpty()) {
            System.out.println("No products found!");
        } else {
            System.out.println("List of Products:");
            for (Product product : productList) {
                System.out.println(product);
            }
        }
    }

    private static void viewProductById(Scanner scanner, ProductDaoImpl productDaoImpl) {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        Product product = productDaoImpl.getById(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product with given ID not found!");
        }
    }
    
    private static void viewProductByName(Scanner scanner, ProductDaoImpl productDaoImpl) {
        System.out.print("Enter product Name: ");
        String name = scanner.next();
        Product product = productDaoImpl.getByName(name);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product with given name not found!");
        }
    }

    private static void updateProduct(Scanner scanner, ProductDaoImpl productDaoImpl) {
        System.out.print("Enter product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter new product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new product price: ");
        float price = scanner.nextFloat();
        Product product = new Product(id, name, price);
        int result = productDaoImpl.update(id, product);
        if (result == 1) {
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Failed to update product!");
        }
    }

    private static void deleteProduct(Scanner scanner, ProductDaoImpl productDaoImpl) {
        System.out.print("Enter product ID to delete: ");
        int id = scanner.nextInt();
        int result = productDaoImpl.remove(id);
        if (result == 1) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Failed to delete product!");
        }
    }
}

