package in.co.rays.oneone;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToOne {
	public static void main(String[] args) {
		
             
      Address address = new Address();
      
      address.setId(2);
      address.setCity("indore");
      address.setCountry("India");;
      
   Employee emp = new Employee();
      
      emp.setId(1);
      emp.setFirstName("Rahul");
      emp.setLastname("Patel");
      emp.setEmpAddress(address);
       

  	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
  	
  	Session session = sessionFactory.openSession();
  	
  	Transaction tx = session.beginTransaction();
  	
  	
  	session.save(emp);
  	tx.commit();
  	
  	session.close();

      
		
		
	}
	

}
