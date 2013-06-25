package Server;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;


public class UpdateFavorites implements AppHandler{
    
	public FavBean handleIt(FavBean fbean){
	    
	    System.out.println("UPDATEFAVORITES: Updated -> "+fbean.toString());
	    
	    Session ses = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
	    Transaction trans = ses.beginTransaction();
	    
	    Query singleUserQ = ses.createQuery("select u from User as u where u.uuid='"+(String)fbean.getUuid()+"'");
	    User user = (User)singleUserQ.uniqueResult();
	    
	    System.out.println("UPDATEFAVORITES: User -> "+ user);
	    
	    if (user == null) {
		System.out.println("UPDATEFAVORITES: Creating new user with uuid of: "+fbean.getUuid());
		User newUser = new User();
		newUser.setUuid(fbean.getUuid());
		ses.save(newUser);
		trans.commit();
	    }
	    
	    
	    fbean.setCommand("done");
	    return fbean;
	    
	    
	    
		
	}
}