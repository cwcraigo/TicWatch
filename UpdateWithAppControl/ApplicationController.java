import java.util.HashMap;


public class ApplicationController {
	private HashMap<String, Handler> commMap;
	
	public ApplicationController(){
		commMap = new HashMap<String, Handler>();
		commMap.put("RetrieveFavorites",new RetrieveFavorites());
		commMap.put("UpdateFavorites", new UpdateFavorites());
		
	}
	
	public void handleRequest(String command, HashMap data){
		Handler hand = commMap.get(command);
		hand.handleIt(data);
	}
}
