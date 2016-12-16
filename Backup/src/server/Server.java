package server;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import common.Player;

public class Server {
	public static ArrayList<Player> regPlayers;
	public static ArrayList<ObjectOutputStream> openOutputStreams;
	public static final int PORT = 1234;
	public static int counter = 0;

	private ServerSocket serverSocket;

	public static void main(String[] args) throws Exception{
		new Server().runServer();
	}

	public void runServer() throws Exception {
		openOutputStreams = new ArrayList<ObjectOutputStream>();

		if(serverSocket == null){
			serverSocket = new ServerSocket (PORT);
		}
		//Singleton
//		if(regPlayers == null){
//			regPlayers = new ArrayList<Player>();
//		}
	
		regPlayers = new ArrayList<Player>();
		
		System.out.println("Starting Server...");
		System.out.println("Server started at: "+serverSocket.getInetAddress());
		while(true){
			Socket socket = serverSocket.accept();
			counter++;
			System.out.println("Connection from: "+socket.getRemoteSocketAddress());
			System.out.println("Client Nr : "+counter);
			ServerThread sThread = new ServerThread(socket);
			new Thread(sThread).start();	
		}
	}
}
