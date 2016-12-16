package common;

import java.io.Serializable;

import javafx.scene.image.Image;

public class Card implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7184891939583129249L;
	private String color;
	private Image img;
	
	public Card(String color, Image img){
		this.color = color;
		this.img = img;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public Image getImage(){
		return this.img;
	}
	
	public String toString(){
		System.out.println(color);
		return this.color;
	}	
}