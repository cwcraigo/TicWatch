package Server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import org.quickconnect.json.JSONException;
import org.quickconnect.json.JSONInputStream;
import org.quickconnect.json.JSONOutputStream;

public class ServerClientSession implements Runnable {

    public Socket clientSocket;
    public ApplicationController controller;
    public JSONInputStream inFromClient;
    public JSONOutputStream outToClient;
    boolean check = true;

    public ServerClientSession(Socket socket, ApplicationController controller) {
	this.clientSocket = socket;
	this.controller = controller;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void run() {

	try {

	    InputStream instream = clientSocket.getInputStream();
	    OutputStream outstream = clientSocket.getOutputStream();
	    
	    inFromClient = new JSONInputStream(instream);
	    outToClient = new JSONOutputStream(outstream);
	    
	    HashMap input = (HashMap) inFromClient.readObject();
	    FavBean bean = new FavBean(input);

	    FavBean result = controller.handleRequest(bean);
	    
	    outToClient.writeObject(result);
	    
	    clientSocket.close();

	} catch (JSONException e) {
	    check = false;
	} catch (Exception e) {
	    e.printStackTrace();
	} // end try/catch

    } // end run()

} // end class
