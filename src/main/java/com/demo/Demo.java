package com.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.model.Employee;

public class Demo {

	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("setting.xml");

		config.addAnnotatedClass(Employee.class);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		Transaction t1 = session.beginTransaction();

		//1.Insert

		Employee e1 = new Employee(6,"Guna","SF",30000);

		session.persist(e1); //save( ) --> persist( ) 
		t1.commit();

		System.out.println("Row Inserted Sucessfully");

		System.out.println();
		
		//2. Get one Employee
		Employee e2 = session.get(Employee.class,2);
		System.out.println(e2);

		//3.Update Employee

		Employee e3=session.get(Employee.class,3);
		System.out.println("Before Updating");
		System.out.println(e3);
		e3=session.get(Employee.class,3);
		e3.setSalary(55000);
		session.merge(e3); //update( ) -->  merge( )
		System.out.println("After Updating");
		System.out.println(e3);
		System.out.println();
		
		//4.Delete Employee

		Transaction t2 = session.beginTransaction();

		Employee e4 = session.get(Employee.class,2);
		session.remove(e4);  //delete( ) -->  remove( )
		t2.commit();
		System.out.println("Employee Deleted");
		System.out.println();
		
		//5. Get All Employees

		//SQL --->   SELECT * FROM emoloyee;
		//HQL --->   From Employee e

		Query<Employee> q= session.createQuery("FROM Employee", Employee.class);		
		List<Employee> empList = q.getResultList();	

		System.out.println("Employee List");
		for(Employee e:empList)
		{
			System.out.println(e);
		}
		System.out.println();
		
		//6. Update particular rows

		//		SQL --->  UPDATE employee SET salary=salary+1000
		//				  WHERE salary>=50000;
		//		HQL --->  UPDATE Employee e SET e.salary = e.salary + 1000
		//		 		  WHERE e.salary>=50000;

		Transaction t3 = session.beginTransaction(); // New transaction

		String q2 = "UPDATE Employee e SET e.salary = e.salary + 1000 WHERE e.salary >= 50000";
		MutationQuery mq1 = session.createMutationQuery(q2);

		int i = mq1.executeUpdate();
		t3.commit(); // Commit the new transaction

		System.out.println(i + " Rows Affected");
		System.out.println();
		
		//7.Delete multiple rows based on condition

		//     SQL --->  DELETE employee WHERE dept="HR";
		//     HQL --->  DELETE Employee e WHERE e.dept="HR";

		Transaction t4 = session.beginTransaction(); // Another new transaction

		String q3 = "DELETE FROM Employee e WHERE e.dept = 'HR'";
		MutationQuery mq2 = session.createMutationQuery(q3);

		int j = mq2.executeUpdate();
		t4.commit();
		System.out.println(j + " Rows Affected");
	}
}