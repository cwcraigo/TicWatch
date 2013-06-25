package Server;

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

    @Override
    public void run() {

	try {
	    
	    // create an input and output stream (channel/thread?) from client
	    inFromClient = new JSONInputStream(clientSocket.getInputStream());
	    outToClient = new JSONOutputStream(clientSocket.getOutputStream());

	    // wait for message from input stream
	    while (check && clientSocket.isConnected()) {

		HashMap input = (HashMap)inFromClient.readObject();
		FavBean fbean = new FavBean(input);

		FavBean result = controller.handleRequest(fbean);
		
		outToClient.writeObject(result);

	    } // end wait for message
	    clientSocket.close();
	} catch (JSONException e) {
	    check = false;
	} catch (Exception e) {
	    e.printStackTrace();
	} // end try/catch
	
    } //end run()

} // end class
