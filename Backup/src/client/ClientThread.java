package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import common.Game;
import common.Player;

public class ClientThread implements Runnable{

	private static Socket socket;
	private static ObjectOutputStream objectOutputStream;
	private static ObjectInputStream objectInputStream;


	ClientThread(Socket socket){
		this.socket = socket;
	}

	public void run(){
		Game g;
		try{
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			while(true){
				while((g = (Game)objectInputStream.readObject()) != null){
					Scene scene = g.getScene();
					Stage stage = new Stage();
					stage.setScene(scene);
					stage.show();
				}
//				socket.close();
//				objectInputStream.close();
//				objectOutputStream.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//sendet Objekt an Server
	public static void sendToServer(Game g){
		try {
			ClientThread.objectOutputStream.writeObject(g);
			objectOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}





