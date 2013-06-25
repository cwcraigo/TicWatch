package Server;

import java.util.HashMap;


public class ApplicationController {

    private HashMap<String, AppHandler> commMap;

    public ApplicationController() {
	commMap = new HashMap<String, AppHandler>();
	commMap.put("Update", new UpdateFavorites());
	commMap.put("Retrieve",new RetrieveFavorites());

    }

    public FavBean handleRequest(FavBean fbean) {
	AppHandler hand = commMap.get(fbean.getCommand());
	FavBean result = hand.handleIt(fbean);
	return result;
    }
}