package com.simplilearn.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.simplilearn.employee.Employee;

public class Employeeclient {
	

	public static void main(String[] args) {
		System.out.println("*****Start Employee Client*****");
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
	
		try {
		
			System.out.println("//create configuration obj");
			Configuration cfg=new Configuration();
			System.out.println("//call configure method");
			cfg=cfg.configure();
			//Through cfg obj call build session factory()
			factory=cfg.buildSessionFactory();
			
			//with factory obj open session
			session=factory.openSession();
			//with session obj call begintransaction
			tx=session.beginTransaction();
			//prepare business obj
			Employee e1=new Employee("rakesh","rakesh@gmail.com","3rd cross bangalore",100000,"Developer");
			//save the data
			session.save(e1);
			//commit into DB
			tx.commit();
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}
		factory.close();
		 session.close();
		 System.out.println("------------ 9. Close the Resourse------------");


		System.out.println("*********END-EmployeeClient*********");
		
	}
	
	
}
