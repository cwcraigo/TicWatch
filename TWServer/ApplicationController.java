package Server;

import java.util.HashMap;


public class ApplicationController {

    private HashMap<String, AppHandler> commMap;

    public ApplicationController() {
	commMap = new HashMap<String, AppHandler>();
	commMap.put("Update", new UpdateFavorites());
	commMap.put("Retrieve",new RetrieveFavorites());
    }

    public FavBean handleRequest(FavBean bean) {
	String cmd = bean.getCommand();
	AppHandler handler = commMap.get(cmd);
	return handler.handleIt(bean);
    }
}