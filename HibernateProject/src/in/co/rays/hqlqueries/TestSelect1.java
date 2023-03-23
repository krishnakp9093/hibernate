package in.co.rays.hqlqueries;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;



public class TestSelect1 {
	
	public static void main(String[] args) {
		
		//testAdd();
		//testSelect();
		//testWhere();
		//testColumn();
		//testOrderBy();
		// testLike();
		//testGroupBy();
		testCriteriaList();
		
		
		
		
		
	}

	private static void testCriteriaList() {

		 SessionFactory sf = new Configuration().configure().buildSessionFactory();
		  
		  Session s = sf.openSession();
		  
		  Transaction tx = s.beginTransaction();
		  
		  Marksheet ms = new Marksheet();
			
		  Query query = s.createQuery("from Marksheet where name like '%an' ");
		  
		  Criteria  crit= s.createCriteria(Marksheet.class);
		  
		 crit.add(Restrictions.like("name", "%n"));
		 crit.add(Restrictions.eq("id", 2));
		
	     List list = crit.list();
	     
	     Iterator it = list.iterator();
	     
	     while (it.hasNext()) {
	    	 ms = (Marksheet) it.next();
	    	 
	    	 System.out.println(ms.getId());
	    	 System.out.println(ms.getName());
	    	 System.out.println(ms.getPhysics());
	    	 System.out.println(ms.getChemistry());
	    	 System.out.println(ms.getMaths());
		    	
	     }
	}

	private static void testGroupBy() {
		
		 SessionFactory sf = new Configuration().configure().buildSessionFactory();
		  
		  Session s = sf.openSession();
		  
		  Transaction tx = s.beginTransaction();
		  
		  Marksheet ms = new Marksheet();
			
		  Query query = s.createQuery("select physics , count(*) from Marksheet m group by m.physics");
		
		  
        List list = query.list();
		  
		  Iterator it = list.iterator();
		  
		  while(it.hasNext()) {
			  
			  ms = (Marksheet) it.next();
			  
			  System.out.println(ms.getId()+" "+ms.getName()+" "+ms.getPhysics()+" "+ms.getChemistry()+" "+ms.getMaths());
				 
		  }
		
		tx.commit();
		  
		  s.close();
	  

	}

	private static void testLike() {
		
		
		 SessionFactory sf = new Configuration().configure().buildSessionFactory();
		  
		  Session s = sf.openSession();
		  
		  Transaction tx = s.beginTransaction();
		  
		  Marksheet ms = new Marksheet();
			
		  Query query = s.createQuery("from Marksheet where name like '%an' ");
		  
List list = query.list();
		  
		  Iterator it = list.iterator();
		  
		  while(it.hasNext()) {
			  
			  ms = (Marksheet) it.next();
			  
			  System.out.println(ms.getId()+" "+ms.getName()+" "+ms.getPhysics()+" "+ms.getChemistry()+" "+ms.getMaths());
				 
		  }
		
		tx.commit();
		  
		  s.close();
	  
		
		
	}

	private static void testOrderBy() {
		
		 SessionFactory sf = new Configuration().configure().buildSessionFactory();
		  
		  Session s = sf.openSession();
		  
		  Transaction tx = s.beginTransaction();
		  
		  Marksheet ms = new Marksheet();
			
		  Query query = s.createQuery("from Marksheet where physics >=90 and chemistry >=80 order by name");
		  
 List list = query.list();
		  
		  Iterator it = list.iterator();
		
		  while (it.hasNext()) {
			  
			  ms = (Marksheet) it.next();
			 
				System.out.println(ms.getId()+" "+ms.getName()+" "+ms.getPhysics()+" "+ms.getChemistry()+" "+ms.getMaths());
				
			  
		  }
		  tx.commit();
		  
		  s.close();
	  

	  
		  
	}

	private static void testColumn() {
		
		 SessionFactory sf = new Configuration().configure().buildSessionFactory();
		  
		  Session s = sf.openSession();
		  
		  Transaction tx = s.beginTransaction();
		  
		  Marksheet ms = new Marksheet();
			
		  
		  Query query = s.createQuery("select m.id , m.name from  Marksheet m");
		  
		  List rows = query.list();
		  
		  Iterator it = rows.iterator();
		  
		  Object [] columns;
		  
		  while(it.hasNext()) {
			  columns = (Object[]) it.next();
			  Integer id = (Integer) columns[0];
			  String name = (String) columns[1];
			  
			  System.out.println(id+" "+name);
		  }
		
		
	}

	private static void testWhere() {
		
  SessionFactory sf = new Configuration().configure().buildSessionFactory();
		  
		  Session s = sf.openSession();
		  
		  Transaction tx = s.beginTransaction();
		  
		  Marksheet ms = new Marksheet();
			
		  
		  Query query = s.createQuery(" from Marksheet where ID = 1");
		  
		  List list = query.list();
		  
			
			
			ms = (Marksheet) list.get(0);
			
			System.out.println(ms.getId()+" "+ms.getName()+" "+ms.getPhysics()+" "+ms.getChemistry()+" "+ms.getMaths());
			 
			 tx.commit();
			  
			  s.close();
		  

		  
		  

		
		
	}

	private static void testSelect() {
		
  SessionFactory sf = new Configuration().configure().buildSessionFactory();
		  
		  Session s = sf.openSession();
		  
		  Transaction tx = s.beginTransaction();
		  
			Marksheet ms = new Marksheet();
			
		  
		  Query query = s.createQuery(" from Marksheet");
		  
		  List list = query.list();
		  
		 
			ms = (Marksheet) list.get(2);
			
			System.out.println(ms.getId()+" "+ms.getName()+" "+ms.getPhysics()+" "+ms.getChemistry()+" "+ms.getMaths());
			 
			 tx.commit();
			  
			  s.close();
		  
		 
		
	}

	private static void testAdd() {
    
		Marksheet ms = new Marksheet();
		ms.setId(4);
		ms.setName("Sunil");
		ms.setPhysics(81);
		ms.setChemistry(85);
		ms.setMaths(82);
		
		  SessionFactory sf = new Configuration().configure().buildSessionFactory();
		  
		  Session s = sf.openSession();
		  
		  Transaction tx = s.beginTransaction();
		  
		  s.save(ms);
		  
		  tx.commit();
		  
		  s.close();
		  
	}

	
}
