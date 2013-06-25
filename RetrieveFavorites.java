package Server;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import Server.AppHandler;
import Server.FavBean;
import Server.HibernateUtilSingleton;
import Server.User;

public class RetrieveFavorites implements AppHandler {
    Set<Favorite> list;
    public FavBean handleIt(FavBean fbean) {

	System.out.println("RETRIEVEFAVORITES: get -> " + fbean.toString());

	Session ses = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
	ses.beginTransaction();

	Query singleUserQ = ses.createQuery("select u from User as u where u.uuid='"+ (String) fbean.getUuid() + "'");
	User user = (User) singleUserQ.uniqueResult();

	System.out.println("RETRIEVEFAVORITES: User favorites -> " + user.getFavorites());

	list = user.getFavorites();
	
	Iterator<Favorite> iter = list.iterator();
	Set<Favorite> symbols = new HashSet<Favorite>();
	while(iter.hasNext()){
	    symbols.add(iter.next());
	}

	System.out.println("RETRIEVEFAVORITES: symbols = "+symbols);
	fbean.setSymbols(symbols);
	
	fbean.setCommand("done");
	
	return fbean;

    }
}
