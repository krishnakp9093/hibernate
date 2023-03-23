package in.co.rays.hqlqueries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Criteria {

public static void main(String[] args) {
	
	
	and();
 
}

private static void and() {
	
	 SessionFactory sf = new Configuration().configure().buildSessionFactory();
	  
	  Session s = sf.openSession();
	  
	  Transaction tx = s.beginTransaction();
	  
	  Marksheet ms = new Marksheet();
	  
 
	   
	
}
}