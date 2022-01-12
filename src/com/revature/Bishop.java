package com.revature;

import java.util.Scanner;

public class Bishop {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String initialPos;
		String endPos;
		int moves;
		
		System.out.println("Please enter the starting position: ");
		initialPos = scan.nextLine();
		System.out.println("Please enter the ending position: ");
		endPos = scan.nextLine();
		System.out.println("Please enter the number of moves: ");
		moves = Integer.valueOf(scan.nextLine());
		scan.close();
		
		
		Position start = new Position(initialPos); //Starting position(a1-h8)
		Position end = new Position(endPos);	 //Ending position(a1-h8)					 //Total number of moves
		
		boolean outcome = checkBishop(start, end, moves);
		System.out.println(outcome);
	}
	
	
	public static boolean checkBishop(Position start, Position end, int moves) {
		if(start.equals(end)) { //Bishop is already on target tile
			return true;
		}
		if(!Position.compareSquare(start, end) || moves < 1) {	//Bishop is not on the same color tile, therefore is it impossible
			return false;										// Or Bishop does not have any moves
		}
		if(moves >=2) {	//Bishops can navigate to any same-color tile with 2 moves, assuming an empty board
			return true;
		}
		
		/*Check if the bishop can navigate within 1 move
		 *
		 * Basic idea is that 1 move will always result in
		 * equal changes in x and y absolute values.
		 * 
		 * Ex) A1 -> B2 can be represented as (1,1)
		 * 	   A1 -> C3 can be represented as (2,2)
		 * 	   A1 -> H8 can be represented as (7,7)
		 * Examples with negative values
		 * 		B2 -> A1 can be represented as (-1,-1)
		 * 		B2 -> A3 can be represented as (-1, 1)
		 * 		E5 -> B2 can be represented as (-3,-3)
		 */
		int xDiff = Math.abs(end.getX()-start.getX());
		int yDiff = Math.abs(end.getY()-start.getY());
		if( xDiff == yDiff) {
			return true;
		}
		return false;
	}

}
