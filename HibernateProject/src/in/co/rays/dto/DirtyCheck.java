package in.co.rays.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DirtyCheck {
public static void main(String[] args) {
	
String newDescription = "XYZ";


SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


Session session = sessionFactory.openSession();

Transaction tx = session.beginTransaction();

AuctionItem item = (AuctionItem)session.get(AuctionItem.class, 1);

item.setDescription(newDescription);
	
tx.commit();
session.close();
	
}
	
	
}
