package common;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

import server.Server;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5688167722333446422L;
	/**
	 * 
	 */

	private static Player[] players;
	private static ArrayList<Tile> startBoard = new ArrayList<Tile>();
	private static ArrayList<Card> cards = new ArrayList<Card>();
	private int numOfPlayers;
	private Scene scene;

	public Game (){
		
		players = new Player[2];
		
		Player player = new Player("di muetter");
		Player player2 = new Player("nanen");
		players[0] = player;
		players[1] = player2;
//		for (int i = 0; i<Server.regPlayers.size();i++){
//			players[i] = Server.regPlayers.get(i);
//		}


		//Game wird gestartet				
		try {
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("GameBoard.fxml"));
			Pane rootPane = (Pane) fxmlloader.load();
			scene = new Scene(rootPane);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Player[] getPlayers(){
		return players;
	}


	public static void setStartBoard(ArrayList<Tile> startBoard){
		Game.startBoard = startBoard;
	}

	public static void setCards(ArrayList<Card> cards){
		Game.cards = cards;
	}

	public  Scene getScene(){
		return this.scene;
	}


}
