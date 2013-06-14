import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	
	public static void main(String[] args){

		//ApplicationController ac = new ApplicationController();
		//ac.handleRequest("RetrieveFavorites", null);
		//ac.handleRequest("UpdateFavorites", null);
		
		ServerSocket aListeningSocket;
		try {
			aListeningSocket = new ServerSocket(9292);
			Socket toClient = aListeningSocket.accept();
			System.out.println("Waiting for Client...");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to Connect...");
		}
	}
}
