package com.revature;

public class Position {
	
	
	int x;//Represents Letter value
	int y;//Represents Number value
	String coordinates;	
	boolean oddSquare; //Determines tile color(Dark or Light)
	
	public Position(String location) {
		coordinates = location;
		x = location.charAt(0) - 96;
		y = Character.getNumericValue(location.charAt(1));
		if((x+y) % 2 == 1) {
			oddSquare = true;
		}
		else {
			oddSquare = false;
		}
	}
	
	public void printPosition() {
		System.out.println(x +" "+ y);
	}
	public boolean getOddSquare() {
		return oddSquare;
	}
	public static boolean compareSquare(Position a, Position b) {
		return (a.getOddSquare() == b.getOddSquare());
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
}
