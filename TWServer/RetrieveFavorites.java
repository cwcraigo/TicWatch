package Server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import Server.AppHandler;
import Server.FavBean;
import Server.HibernateUtilSingleton;
import Server.User;

public class RetrieveFavorites implements AppHandler {

    FavBean fbean;
    SessionFactory sessionFactory;
    Session ses;
    String uuid;
    Query singleUserQ;
    User user;
    Set<Favorite> favSet;
    Iterator<Favorite> iter;
    ArrayList<String> symbols = new ArrayList<String>();
    Favorite fav;
    String favString;
    
    public FavBean handleIt(FavBean bean) {
	
	fbean = bean;
	
	System.out.println("RETRIEVEFAVORITES: get -> " + fbean.toString());
	
	sessionFactory = HibernateUtilSingleton.getSessionFactory();
	ses = sessionFactory.getCurrentSession();
	ses.beginTransaction();

	uuid = fbean.getUuid();
	singleUserQ = ses.createQuery("select u from User as u where u.uuid='"+uuid+"'");
	
	user = (User) singleUserQ.uniqueResult();

	favSet = user.getFavorites();

	iter = favSet.iterator();
	
	while(iter.hasNext()){
	    fav = iter.next();
	    favString = fav.getFavorite();
	    symbols.add(favString);
	}

	fbean.setSymbols(symbols);
	fbean.setCommand("done");
	
	return fbean;
    }
}
