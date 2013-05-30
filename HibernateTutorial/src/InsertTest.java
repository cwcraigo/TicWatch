import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class InsertTest {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("Hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		TestTable test = new TestTable();
		test.setId(1);
		test.setName("Jackie");
		test.setMobile("1-555-555-5050");
		test.setEmail("asd@dsa.com");
		s.save(test);
		s.flush();
		tx.commit();
		s.close();
	}

}
