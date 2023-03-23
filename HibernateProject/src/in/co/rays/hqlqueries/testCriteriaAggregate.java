package in.co.rays.hqlqueries;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class testCriteriaAggregate {
	
	public static void main(String[] args) {
		
	
	
	 SessionFactory sf = new Configuration().configure().buildSessionFactory();
	  
	  Session s = sf.openSession();
	  
	  Transaction tx = s.beginTransaction();
	  
	  Marksheet ms = new Marksheet();
		
	  Query query = s.createQuery("select count(id) from Marksheet");
	  
	   
	  ProjectionList projList = Projections.projectionList();
	  
	  Criteria  crit= s.createCriteria(Marksheet.class);
	} 
	   
}
