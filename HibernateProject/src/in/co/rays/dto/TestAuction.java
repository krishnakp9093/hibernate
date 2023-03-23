package in.co.rays.dto;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestAuction {
public static void main(String[] args) {
	
	
	Bid bid1 = new Bid();
	
	bid1.setId(4);
	bid1.setAmount(100);
	bid1.setTimestamp("XXX");
  	
	AuctionItem item = new AuctionItem();
	
	item.setId(3);
	item.setDescription("Description 2");
	 

	Set bids = new HashSet();
	bids.add(bid1);
	
 
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	Session session = sessionFactory.openSession();
	
	Transaction tx = session.beginTransaction();
	
	session.save(item);
	
	tx.commit();
	
	session.close();

}
}
