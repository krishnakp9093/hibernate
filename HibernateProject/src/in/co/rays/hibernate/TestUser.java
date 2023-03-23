package in.co.rays.hibernate;


import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
;

public class TestUser {
	public static void main(String[] args) throws Exception {
		testAdd();
	//	testDelete();
	//	testUpdate();
	//	testGet();
		Authenticate("krish@gmail.com", "1234");
	//	testList();
		
	}

		 
		
	

	/*private static void testList() {
		 
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Query q =session.createQuery("from UserDTO ");
		
		List list = q.list();
		
		Iterator it = list.iterator();*/
		
		
		
		
	





	private static void Authenticate(String loginId, String password) throws Exception {
    
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Query q =session.createQuery("from UserDTO where LOGIN_ID=? and PASSWORD=?");
		 
		q.setString(0, loginId);
		q.setString(1, password);
		 
		List list = q.list();
		UserDTO pojo = null;
		
		 if(list.size()==1){
			 pojo = (UserDTO) list.get(0);	 
		 }else {
			 throw new Exception("invalid user login");
		 }
		
		/*
		 * List list = (List) q.list();
		 * 
		 * UserDTO pojo = null; if(list.size()list==1) { pojo = (UserDTOlist.get(0); }
		 */
		 
		 
		session.close();
		
         
		  
		}
		







	private static void testGet() {
		
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session s = sessionFactory.openSession();
		
		 
		UserDTO pojo = (UserDTO) s.get(UserDTO.class, 1);
		
		System.out.print(pojo.getId()+"\t");
		System.out.print(pojo.getName()+"\t");
		System.out.print(pojo.getEmail()+"\t");
		System.out.println(pojo.getPassword());
		
		s.close();
		
		
		 }

	private static void testUpdate() {
		
		UserDTO pojo = new UserDTO();
		
		pojo.setId(2);
		pojo.setName("Raj");
		pojo.setEmail("raj@gmail.com");
		pojo.setPassword("1234");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session s = sessionFactory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.update(pojo);
		
		tx.commit();
		s.close();
		
		
	 	
	}

	private static void testDelete() {
	 
		UserDTO pojo = new UserDTO();
		
		pojo.setId(0);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
		Session s = sessionFactory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.delete(pojo);
		
		tx.commit();
		s.close();
		
	}

	private static void testAdd() {
		UserDTO pojo = new UserDTO();
		
		pojo.setId(4);
		pojo.setName("Amit");
		pojo.setEmail("amit@gmail.com");
		pojo.setPassword("1234");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		
		
		s.save(pojo);
		
		tx.commit();
		s.close();
	 
		 
	}

}
