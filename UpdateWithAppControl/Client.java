import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONOutputStream;

public class Client {
	Socket toServer;
	OutputStream stream;
	
	JSONOutputStream jsonOut;
	byte[] b = new byte[100];
	
	String destinationIP = "127.0.0.1";
	int port;
	String send;
	

	public Client(){
		destinationIP = "127.0.0.1";
		port = 9292;
		send = "Great Day";
	}
	
	public Client(String message){
		this.send = message;
		destinationIP = "127.0.0.1";
		port = 9292;
	}
	
	public void transmit()
	{
		try {
			toServer = new Socket(destinationIP, port);
			jsonOut = new JSONOutputStream(toServer.getOutputStream());

			jsonOut.writeObject(send);
			toServer.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("Unknown Host");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception: Server Probably isn't listening");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("End of Client");
	}
}
