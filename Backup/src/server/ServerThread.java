package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import common.Game;
import common.Player;



public class ServerThread implements Serializable, Runnable{
	private static Socket socket = null;
	public static ObjectOutputStream objectOutputStream;
	public static ObjectInputStream objectInputStream;
	ServerThread(Socket socket){
		this.socket = socket;
	}

	public void run(){
		Game g;
		try{
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			Server.openOutputStreams.add(objectOutputStream);
			while(true){	
				while((g = (Game)objectInputStream.readObject()) != null){
					sendToAllClients(g);
//					socket.close();
//					objectInputStream.close();
//					objectOutputStream.close();
				}
			}
		}catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void sendToAllClients(Game g){
		for(ObjectOutputStream oos:Server.openOutputStreams){
			try {
				oos.writeObject(g);
				oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}



