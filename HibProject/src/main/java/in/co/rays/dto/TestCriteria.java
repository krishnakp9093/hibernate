package in.co.rays.dto;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class TestCriteria {
	

	private static void testCriteria() {

		 SessionFactory sf = new Configuration().configure().buildSessionFactory();
		  
		  Session s = sf.openSession();
		  
		  Transaction tx = s.beginTransaction();
		  Person em = new Person();
			
		  Query query = s.createQuery("from Employee where name like '%an' ");
		  
		  Criteria  crit= s.createCriteria(Person.class);
		  
		 crit.add(Restrictions.like("name", "a%"));
		 crit.add(Restrictions.eq("id", 3));
		
	     List list = crit.list();
	     
	     Iterator it = list.iterator();
	     
	     while (it.hasNext()) {
	    	 em = (Person) it.next();
	    	 
	    	 System.out.println(em.getId());
	    	 System.out.println(em.getName());
	    	 System.out.println(em.getSalary());
	    	 
	     }
	}

}
