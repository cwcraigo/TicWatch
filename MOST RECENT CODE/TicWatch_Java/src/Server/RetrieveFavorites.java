package Server;


import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.quickconnectfamily.json.JSONOutputStream;


public class RetrieveFavorites implements AppHandler {

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

    public void handleIt(FavBean bean, Socket clientSocket) {

	sessionFactory = HibernateUtilSingleton.getSessionFactory();
	ses = sessionFactory.getCurrentSession();
	ses.beginTransaction();

	uuid = bean.getUuid();
	singleUserQ = ses.createQuery("select u from User as u "
				    + "where u.uuid='" + uuid + "'");

	user = (User) singleUserQ.uniqueResult();

	ArrayList<String> favList = user.getFavorites();
	bean.setSymbols(favList);
	bean.setCommand("done");

	System.out.println("RETRIEVE: "+bean);
	
	try {

	    OutputStream outStream = clientSocket.getOutputStream();
	    JSONOutputStream outToClient = new JSONOutputStream(outStream);

	    outToClient.writeObject(bean);

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
