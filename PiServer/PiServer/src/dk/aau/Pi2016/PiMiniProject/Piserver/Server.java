package dk.aau.Pi2016.PiMiniProject.Piserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

		protected String serverTextMessage;
	
		protected boolean serverDataDisplayed;
		protected String serverLastIP;



	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String serverTextMessageReceived;
		try {
			serverSocket = new ServerSocket(50000);
			clientSocket = serverSocket.accept(); 
			//Creates a new socket automatically that will be used
			//to send data to the client.
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			while ((serverTextMessageReceived = in.readLine()) != null){
				out.println(clientSocket.getInetAddress() + " says: " + serverTextMessageReceived);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();




		
	}
}
