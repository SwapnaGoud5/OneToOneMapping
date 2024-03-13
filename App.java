package example1To1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import oneToOneMapping.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
    	// Obtain a Hibernate SessionFactory
        SessionFactory factory = HibernateUtil.getSessionFactory();
        // Open a new session
        Session session = factory.openSession();
        // Begin a transaction
        Transaction t = session.beginTransaction();
        
     // Create user and address
        User user = new User();
        user.setName("karuna");

        Address address = new Address();
        address.setStreet("11-22 komp");
        address.setCity("komplaly");
        address.setZipCode("500884");

        user.setAddress(address);        
        session.persist(user);
        
        t.commit();
        session.close();
        factory.close();
    }
}
