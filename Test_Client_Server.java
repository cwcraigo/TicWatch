package Server;

import java.util.ArrayList;

public class Test_Client_Server {

    public static void main(String[] args) {
	
	// command and uuid
	String command = "Update";
	String uuid = "1234";
	
	// update symbols
	ArrayList<String> symbols = new ArrayList<String>();
	symbols.add("xxx");
	symbols.add("yyy");
	
	// bean to carry info to server
	FavBean favorites = new FavBean(command,uuid,symbols);
	
	// prep data for client/server communication
	Client client = new Client(favorites);
	
	// connect and send data to server
	client.connectToServer();
	
	
	
	// command and uuid
	String command2 = "Retrieve";
	String uuid2 = "1234";
		
	// update symbols
	ArrayList<String> symbols2 = new ArrayList<String>();
		
	// bean to carry info to server
	FavBean favorites2 = new FavBean(command2,uuid2,symbols2);
		
	// prep data for client/server communication
	Client client2 = new Client(favorites2);
		
	// connect and send data to server
	client2.connectToServer();
	
    }

}
