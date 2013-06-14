import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.apache.log4j.Logger;

public class Hibernate {
	final static Logger logger = Logger.getLogger(Hibernate.class);
	private List<User> users;
	
	public Hibernate(){
		
	}
	
	public static void main(String[] args){

		ApplicationController ac = new ApplicationController();
		ac.handleRequest("RetrieveFavorites", null);
		ac.handleRequest("UpdateFavorites", null);
		
		
	}
	
	public void addNewUsers(String uid){
		Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		User newUser = new User();
		newUser.setUuid(uid);
		
		session.save(newUser);
		trans.commit();
		
		
	}
	
	public void showAllUsers(){
		Session ses = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
		Transaction trans = ses.beginTransaction();
		
		Query allUsersQ = ses.createQuery("select u from User as u order by u.id");
		
		users = allUsersQ.list();
		System.out.println("num users: "+ users.size());
		
		Iterator<User> iter = users.iterator();
		while(iter.hasNext()){
			User element = iter.next();
			System.out.println(element.toString());
			System.out.println("num of phone numbers: " + element.getFavorites().size());
		}
		trans.commit();
	}
	
	public void modifyUser(String uid, String newUid){
		Session ses = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
		Transaction trans = ses.beginTransaction();
		Query singleUserQ = ses.createQuery("select u from User as u where u.uuid='" + uid + "'");
		
		User modUser = (User)singleUserQ.uniqueResult();
		modUser.setUuid(newUid);
		ses.merge(modUser);
		trans.commit();
		showAllUsers();
	}
	
	public void addSharedFavorite(String uid){
		Session ses = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
		Transaction trans = ses.beginTransaction();
	
		Query singleUserQ = ses.createQuery("select u from User as u where u.uuid='" + uid + "'");
		User user = (User)singleUserQ.uniqueResult();
		
		Favorite sharedFavorite = new Favorite();
		sharedFavorite.setFavorite("APPL");
		
		Set<Favorite> userFavorites = user.getFavorites();
		userFavorites.add(sharedFavorite);
		
		ses.save(sharedFavorite);
		ses.merge(user);
		trans.commit();
		showAllUsers();
	}
	
	public void deleteAllUser(){
		Session ses = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
		Transaction trans = ses.beginTransaction();
	
		int numUsers = users.size();
		for(int i = 2; i < numUsers; i++){
			System.out.println("deleteing user "+users.get(i).getUuid());
			User aUser = users.get(i);
			ses.delete(users.get(i));
		}
		trans.commit();
		users.remove(2);
		System.out.println(users);
	}
}
