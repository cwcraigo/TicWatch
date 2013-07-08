package com.example.ticwatch3;

import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import android.widget.TextView;

public class Client implements Runnable {

	// public FavBean bean;
	String uuid;

	Socket toServer;

	public Client(String uuid) {
		this.uuid = uuid;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void run() {

		try {

			toServer = new Socket("127.0.0.1", 9292);

			System.out.println("CLIENT: socket connected.");

			// create an input and output stream (channel) from client
			JSONOutputStream outToServer = new JSONOutputStream(
					toServer.getOutputStream());
			JSONInputStream inFromServer = new JSONInputStream(
					toServer.getInputStream());
			// send the bean
			outToServer.writeObject(this.uuid);

			boolean check = true;
			// int count = 0;
			while (check) {

				HashMap symbols = (HashMap) inFromServer.readObject();

				// String done = (String) result.get("cmd");
				//
				// if (done.equals("done")) {
				// toServer.close();
				// check = false;
				// } else {
				// System.out.println("CLIENT: not done.");
				// outToServer.writeObject(this.bean);
				// count++;
				// }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
