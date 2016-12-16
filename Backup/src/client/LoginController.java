package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import server.Server;
import common.Game;
import common.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController implements Initializable{


	@FXML
	TextField tf_username;

	@FXML
	Label text_LoginAtlantis;

	@FXML
	Label text_Benutzername;

	@FXML
	Label text_Fehlermeldung;

	@FXML
	Button b_startGame;

	@FXML
	Button hostButton;

	@FXML
	TextField ipAdresse;

	
	private boolean setSocket = false;
	private static Game game;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void startGame(){
		if(!setSocket){ //besteht Verbindung zum Server?
			text_Fehlermeldung.setText("Bitte wählen Sie einen Host aus.");
		}
		game = new Game();
		ClientThread.sendToServer(game);
		Stage stage = (Stage) b_startGame.getScene().getWindow();
		stage.close();
	}

	//diese Methode schreibt die eigene IP-Adresse in das Textfeld im Login
	//die IP-Adresse im Textfeld wird benötigt um eine Verbindung mit dem Server herzustellen
	public void setSocket(){
		try {
			InetAddress ip = InetAddress.getLocalHost();
			ipAdresse.setText(ip.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//mit dieser Methode wird die Verbindung zwischen Client und Server hergestellt
	public void setServerSocket(){
		try{
			System.out.println("Connecting...");
			Socket socket = new Socket(ipAdresse.getText(), server.Server.PORT);
			System.out.println("Connection successful...");
			setSocket = true;
			String eingabeName = tf_username.getText();
			Player p = new Player(eingabeName);
//			Server.regPlayers.add(p);

			ClientThread cThread = new ClientThread(socket);
			new Thread(cThread).start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Game getGame(){
		return game;
	}
}
