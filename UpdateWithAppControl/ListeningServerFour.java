import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ListeningServerFour{
	public static void main(String[] args){
		//Sockets needed to talk with client
		ServerSocket serverSocket;
		Socket fromClientSocket;
		int port = 9292;

		//Strings and streams to message the client
		byte[] b;
		String inString;
		String outString;
		OutputStream outStream;
		InputStream inStream;

		Executor organizer = Executors.newCachedThreadPool();


		boolean listen = true;

		try {
			serverSocket = new ServerSocket(port);	//Creates a socket that is ready to listen on the port indicated
			System.out.println("Starting server on thread: " + Thread.currentThread().getName());
			while (listen){
				ServerClientInteraction session = new ServerClientInteraction(); //Creates the actual connection between client and server
				session.setSocket(serverSocket.accept());
				organizer.execute(session);
			}
			serverSocket.close();
			
		} catch(SocketException e){
			System.out.println("Socket Closed");
		} catch (IOException e) {
			System.out.println("Server: IOException");
			e.printStackTrace();
		}
		Thread.currentThread().interrupt();
	}
}


