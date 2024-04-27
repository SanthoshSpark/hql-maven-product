package com.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	
    public static void main( String[] args ){
    
    	SessionFactory sf = null;
    	Session s = null;
    	Transaction tx = null;
    	
    	try {
    		sf = new Configuration().configure().buildSessionFactory();
    		s  = sf.openSession();
    		tx = s.beginTransaction();
    		
    	/*	List<Product> products = new ArrayList<Product>();
    		
    		Product product1 = new Product("Pen", 1.99);
        	Product product2 = new Product("Notebook", 4.99);
        	Product product3 = new Product("Pencil", 0.99);
        	Product product4 = new Product("Eraser", 0.49);
        	Product product5 = new Product("Markers", 3.49);
        	
        	Product product6 = new Product("Scissors", 2.99);
        	Product product7 = new Product("Calculator", 9.99);
        	Product product8 = new Product("Stapler", 3.49);
        	Product product9 = new Product("Highlighter", 1.29);
        	Product product10 = new Product("Folders", 2.79);

        	Product product11 = new Product("Backpack", 19.99);
        	Product product12 = new Product("USB Drive", 6.49);
        	Product product13 = new Product("Coffee Mug", 4.99);
        	Product product14 = new Product("Mousepad", 2.49);
        	Product product15 = new Product("Headphones", 12.99);
        	Product product16 = new Product("Desk Lamp", 8.99);
        	Product product17 = new Product("Mouse", 7.49);
        	Product product18 = new Product("Water Bottle", 3.99);
        	Product product19 = new Product("Socks", 1.99);
        	Product product20 = new Product("Notepads", 5.49);
        	
        	products.add(product1);
        	products.add(product2);
        	products.add(product3);
        	products.add(product4);
        	products.add(product5);
        	products.add(product6);
        	products.add(product7);
        	products.add(product8);
        	products.add(product9);
        	products.add(product10);
        	products.add(product11);
        	products.add(product12);
        	products.add(product13);
        	products.add(product14);
        	products.add(product15);
        	products.add(product16);
        	products.add(product17);
        	products.add(product18);
        	products.add(product19);
        	products.add(product20);
        	
        	
        	for(Product product : products) {
        		s.save(product);
        	} */
        	
    		
    	/*	String hql = "FROM Product";
    		
    		Query query = s.createQuery(hql);
    		
    		List<Product> products = query.list();
    		
    		for(Product product : products) {
    			System.out.println("******************************");
    			System.out.println(product);
    		}  */
    		
    /*      String hql = "FROM Product WHERE name = :productName";
    		
    		Query query = s.createQuery(hql);
    		
    		query.setParameter("productName", "Pen");
    		
    		List<Product> products = query.list();
    		
    		if(products.size() > 0) {
    			for(Product product : products) {
    				System.out.println(product);
    			}
    		}
    		else {
    			System.out.println("*****************");
    			System.out.println("There is no product.");
    		}  */
    		
    /*	    String hql = "FROM Product WHERE price < :maxPrice";
      		
      		Query query = s.createQuery(hql);
      		
      		query.setParameter("maxPrice", 5.0);
      		
      		List<Product> products = query.list();
      		
      		if(products.size() > 0) {
      			for(Product product : products) {
      				System.out.println("*****************");
      				System.out.println(product);
      			}
      		}
      		else {
      			System.out.println("There is no product.");
      		}  */
    		
    		
   /*       String hql = "FROM Product ORDER BY price DESc";
      		
      		Query query = s.createQuery(hql);
      		
      		List<Product> products = query.list();
      		
      		if(products.size() > 0) {
      			for(Product product : products) {
      				System.out.println("*****************");
      				System.out.println(product);
      			}
      		}
      		else {
      			System.out.println("There is no product.");
      		} 
        	*/
    		
    	/*    String hql = "FROM Product WHERE price BETWEEN :minPrice AND :maxPrice";
       		
       		Query query = s.createQuery(hql);
       		
      		query.setParameter("minPrice", 5.0);

      		query.setParameter("maxPrice", 15.0);
       		
       		List<Product> products = query.list();
       		
       		if(products.size() > 0) {
       			for(Product product : products) {
       				System.out.println("*****************");
       				System.out.println(product);
       			}
       		}
       		else {
       			System.out.println("There is no product.");
       		}
       		*/
    		
    		String hql = "SELECT SUM(price) FROM Product";
    		Query query = s.createQuery(hql);
    		
    		Double total = (Double) query.uniqueResult();
    		
    		System.out.println("Total : "+total);
    		
    		
    	}
    	catch(HibernateException e) {
    		if(tx != null)
    			tx.rollback();
    		e.printStackTrace();
    	}
    	catch (Exception e) {
    		if(tx != null)
    			tx.rollback();
    		e.printStackTrace();
		}
        finally {
        	if(tx != null)
    			tx.commit();
        	if(s != null)
        		s.close();
        	if(sf != null)
        		sf.close();
		}
    	
    }
}
