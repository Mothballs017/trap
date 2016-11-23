package caveExplorer;

import java.util.Scanner;
import NikitaAndMathew.EventNikitaAndMathew;
import mattCandAli.MatthewGrid;

public class CaveExplorer {

	public static CaveRoom caves[][];
	public static Scanner in;
	public static CaveRoom currentRoom;
	public static Inventory inventory;

	public static void main(String[] args){
		in = new Scanner(System.in);
		caves = new CaveRoom[3][3];
		for(int row = 0; row < caves.length; row++){
			for(int col = 0; col < caves[row].length; col++){
				caves[row][col] = new CaveRoom("This cave has coordinates "+row+","+col);
			}
		}
		currentRoom = caves[0][1];
		//caves[0][1] = new EventRoom("You wake up in a closed room. There is a portal in front of you.", new GameStartEvent());
		currentRoom.enter();
		//There is a door to the far end of the room, but there appear to be obstacles in your way."
		//caves[0][2] = new EventRoom("You fell into another dimension.", new EventNikitaAndMathew());
		//caves[1][2] = new EventRoom("Exiting the portal dimension, you find yourself pitted against Hanley, connect 4 master and the only obstacle between you and the far wall.", new MatthewGrid());
		caves[2][2] = new EventRoom("", new GameStartEvent());
		caves[0][1].setConnection(CaveRoom.EAST,caves[0][2],new Door());
		caves[0][2].setConnection(CaveRoom.SOUTH,caves[1][2],new Door());
		caves[1][2].setConnection(CaveRoom.SOUTH,caves[2][2],new Door());
		inventory = new Inventory();
		startExploring(); 
	}

	private static void startExploring() {
		while(true){
			System.out.println(inventory.getDescription());
			System.out.println(currentRoom.getDescription());
			System.out.println("What would you like to do?");
			String input = in.nextLine();
			currentRoom.interpretInput(input, true);
		}
	}

	public static void print(String string) {
		System.out.println(string);
	}
}
