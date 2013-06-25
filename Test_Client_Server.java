package Server;

import java.util.HashSet;
import java.util.Set;

public class Test_Client_Server {

    public static void main(String[] args) {
	
	// command and uuid
	String command = "Update";
	String uuid = "1234";

	// update symbols
	Set<Favorite> symbols = new HashSet<Favorite>();
	Favorite f1 = new Favorite();
	f1.setFavorite("yyy");
	Favorite f2 = new Favorite();
	f2.setFavorite("zzz");
	symbols.add(f1);
	symbols.add(f2);
	
	// bean to carry info to server
	FavBean favorites = new FavBean(command,uuid,symbols);
	
	// prep data for client/server communication
	Client client = new Client(favorites);
	
	// connect and send data to server
	client.connectToServer();
	
	
	
	// command and uuid
	String command2 = "Retrieve";
	String uuid2 = "1234";
		
	// bean to carry info to server
	FavBean favorites2 = new FavBean(command2,uuid2,null);
		
	// prep data for client/server communication
	Client client2 = new Client(favorites2);
		
	// connect and send data to server
	client2.connectToServer();
	
    }

}
