package Server;

public class Test_Client_Server {

    public static void main(String[] args) {

//	// command and uuid
//	String command = "Update";
//	String uuid = "1234";
//	String[] symbols = {"yyyz","zzzy"};
//	
//	// bean to carry info to server
////	FavBean favorites = new FavBean(command,uuid,symbols);
//	HashMap<String,Object> favorites = new HashMap<String,Object>();
//	favorites.put("command", command);
//	favorites.put("uuid", uuid);
//	favorites.put("symbols", symbols);
//	
//	// prep data for client/server communication
//	Client client = new Client(favorites);
//	
//	// connect and send data to server
//	client.connectToServer();
	
	// -------------------------------------------------
	
	// command and uuid
	String command2 = "Retrieve";
	String uuid2 = "1234";
		
	// bean to carry info to server
	FavBean bean = new FavBean(command2,uuid2,null);
//	HashMap<String,Object> favorites2 = new HashMap<String,Object>();
//	favorites2.put("command", command2);
//	favorites2.put("uuid", uuid2);
//	favorites2.put("symbols", null);
		
	// prep data for client/server communication
	Client client2 = new Client(bean);
		
	// connect and send data to server
	client2.connectToServer();
	
    }

}
