package mattCandAli;

import java.util.Arrays;
import java.util.Scanner;

public class MatthewGrid {

	//		create a grid 6 down and 7 across -done
	//		4 in a row is winner
	//		could set all open spaces to x, once used switch to o
	//		randomly set who goes first. maybe 1-10, if >= 5, computer goes first - done
	//		player/computer names the column, not row. 
	//		next open slot is filled by an o
	//		once placed, check win conditions. horizontal, if 4 in a row, vertical, if 4 in a row, if diagonal 4 in a row
	//		keep looping until a player wins
	public static String[][] arr2D;
	public static String[][] pic;
	public static int i;
	public static int j;
	public static Scanner in;

	public static void main(String[] args){
		pic = new String[6][7];
		for(int row = 0; row < pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				pic[row][col]=" x ";
			}
		}
		in = new Scanner(System.in);
		if(generateRandomNumberBetween(2,1) >= 2){
			pic[pic.length-1][generateRandomNumberBetween(pic.length,0)] = " o ";
		}
		printPic(pic);
	}

	private static int generateRandomNumberBetween(int max,int min){
		int randomNum = min + (int)(Math.random() * ((max - min) + 1));
		return randomNum;
	}

	public static void printPic(String[][] pic){
		for(int row = 0;row < pic.length;row++){
			for(int col = 0;col < pic[row].length;col++){
				System.out.print(pic[row][col]);
			}
			System.out.println();
		}
	}
}