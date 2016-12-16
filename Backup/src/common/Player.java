package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import javafx.scene.paint.Color;
import common.SCircle;
import client.ClientThread;

public class Player extends SCircle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2853507843070301083L;
	private String userName;
	public ArrayList<Card> playerCards;
	private int score;
	private boolean alreadyLoggedIn = false;
	private ArrayList<SCircle> avatars;
	private SCircle avatar1 = new SCircle();
	private SCircle avatar2 = new SCircle();
	private SCircle avatar3 = new SCircle();
	private SCircle avatarColor = new SCircle();

	public Player(String userName){
		this.userName = userName;
		playerCards = new ArrayList<Card>();
		score = 0;
		avatars = new ArrayList<SCircle>();
		avatars.add(avatar1);
		avatars.add(avatar2);
		avatars.add(avatar3);
		for(int i = 0; i < avatars.size(); i++){
			avatars.get(i).setRadius(10);
			avatars.get(i).setStroke(Color.BLACK);
			avatars.get(i).toFront();
			avatars.get(i).setVisible(true);
		}
	}

	public void setScore(int score){
		this.score = score;
	}

	public int getScore(){
		return this.score;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public ArrayList<SCircle> getAvatar(){
		return this.avatars;
	}
	
	public void addToScore(int points){
		this.score += points;
	}
	
	public void subFromScore(int points){
		this.score -=points;
	}

	public String toString(){
		return "Name: "+this.userName;
	}
	
	public void setAvatarColor (Color avatarColor){
		this.avatarColor.setFill(avatarColor);
		this.avatarColor.setRadius(10);
		this.avatarColor.setStroke(Color.BLACK);
		this.avatarColor.setVisible(true);
	}
	
	public SCircle getAvatarColor(){
		return this.avatarColor;
	}

}
