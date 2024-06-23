package com.example.employeecrud;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.employeecrud.daoimpl.EmployeeDAOImpl;
import com.example.employeecrud.model.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args )
    {
//        Configuration cfg = new Configuration();
//        cfg.configure().addAnnotatedClass(Employee.class);
//        SessionFactory sf = cfg.buildSessionFactory();
//        Session session = sf.openSession();
//        Transaction txn = session.beginTransaction();
//        
//        Employee emp = new Employee();
//        emp.setName("sandesh");
//        emp.setPhone("8806306387");
//        emp.setSalary(45000);
//        
//        session.save(emp);
//        txn.commit();
//        session.close();
        
    	Scanner sc = new Scanner(System.in);
    	EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
    	
    	do {
			System.out.println("1. Add employee");
			System.out.println("2. Get all employees");
			System.out.println("3. Get by Id");
			System.out.println("4. Remove employee");
			System.out.println("5. Update employee");
			System.out.println("6. Exit");
			System.out.print("Enter choice : ");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				Employee employee = new Employee();
				System.out.print("Enter Name:  ");
				sc.nextLine();
				employee.setName(sc.nextLine());
				System.out.print("Enter Phone:  ");
				employee.setPhone(sc.nextLine());
				System.out.print("Enter Salary:  ");
				employee.setSalary(sc.nextFloat());
				int id = employeeDAOImpl.save(employee);
				System.out.println(id+" Inserted");
			}
			else if(choice == 2) {
				List<Employee> employees = employeeDAOImpl.getAll();
				if(employees.size() == 0) {
					System.out.println("No Employee Found");
				}
				else {
					Iterator<Employee> itr = employees.iterator();
					while(itr.hasNext()) {
						Employee emp = itr.next();
						System.out.println(emp);
					}
				}
			}
			else if(choice == 3) {
				System.out.print("Enter Id that you want to search :  ");
				int id = sc.nextInt();
				Employee employee = employeeDAOImpl.getById(id);
				if(employee != null) {
					System.out.println(employee);
				}
				else {
					System.out.println("Employee not found");
				}
			}
			else if(choice == 4) {
				System.out.print("Enter Id :  ");
				int id = sc.nextInt();
				int result = employeeDAOImpl.remove(id);
				if(result != -1) {
					System.out.println("Employee Removed");
				}
				else {
					System.out.println("Employee not found");
				}
			}
			else if(choice == 5) {
				 System.out.print("Enter Id of the employee to update:  ");
                 int Id = sc.nextInt();
                 System.out.print("Enter new Name:  ");
                 sc.nextLine(); // 
                 String name = sc.nextLine();
                 System.out.print("Enter new Phone:  ");
                 String phone = sc.nextLine();
                 System.out.print("Enter new Salary:  ");
                 float salary = sc.nextFloat();
                 int updateResult = employeeDAOImpl.update(Id, name, phone, salary);
                 if (updateResult != -1) {
                     System.out.println("Employee Updated");
                 } 
                 else {
                     System.out.println("Employee not found");
                 }
			}
			else if(choice == 6) {
				System.out.println("Thank You");
				System.exit(0);
			}
			else {
				System.out.println("Invalid choice");
			}
			
			
		} 
    	while (true);

    }
}
