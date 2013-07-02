package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Server {
    
     public static void main(String[] args) {
	 
	
	Executor myEx;
	ServerSocket aListeningSocket;
	Socket clientSocket;
	ServerClientSession session;

	try {

	    // declare new controller
	    ApplicationController controller = new ApplicationController();

	    // declare new executor with thread pool
	    myEx = Executors.newCachedThreadPool();

	    // open new socket on port 9292
	    aListeningSocket = new ServerSocket(9292);

	    // SERVER: infinite waiting for connection from client.
	    while (true) {

		System.out.println("SERVER: waiting for client connection.");

		// accept connection and assign connection to socket object
		clientSocket = aListeningSocket.accept();

		System.out.println("SERVER: connected to client.");

		// create new session between Server and Client.
		// pass socket object and controller object.
		session = new ServerClientSession(clientSocket, controller);

		// execute session
		myEx.execute(session);

	    } // end server listening loop

	} catch (Exception e) {
	    e.printStackTrace();
	} // end try/catch

    } // end startServer()

} // end Server class
