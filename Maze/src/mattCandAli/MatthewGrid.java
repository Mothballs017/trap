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
	final static int WIDTH = 7;
	final static int HEIGHT = 6;
	final static int LASTROW = WIDTH -1;
	public static char[][] board = new char[WIDTH][HEIGHT];;
	public static String[] columnKey = {"1","2","3","4","5","6","7"};
	public static boolean gameLoop = true;
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){
		generatePlayingField();
		System.out.println("Beat this game of Connect 4 to pass! Your piece will be an Select a column by choosing its corresponding index.\n 01234567");
		printBoard(board);
		System.out.println("You can skip this game by entering the passphrase: HANLEY");
		if(scanner.nextLine().equals("HANLEY")){
			gameLoop = false;
		}
		while(gameLoop = true){
			playerSelect();
			if(!checkPlayerWin()){
	              gameLoop = false; //sets flag to false so loop is not repeated if player 1 won
	              break; //break to skip player 2s turn if won
	          }
		}
	}
	
	private static boolean checkPlayerWin() {
		//check: HORIZONTAL ___
		//		VERTICAL ___
		//		DIAGONAL ___
		
		return false;
	}

	private static void playerSelect(){
		int counter = 1;
		System.out.println("Player's turn. Please select a valid column.");
//		String column = scanner.getInput();
//		for(int i = 0; i < columnKey.length; i++){
//			if(column.equals(columnKey[i])){
//				int col = i;
//			}
//		}
		int col = scanner.nextInt();
		boolean deciding = true;
		while(deciding){
			if(col > WIDTH){
				System.out.println("That's not a valid column");
				deciding = false;;
			}
			if(board[LASTROW][col] == '-'){ 
				board[LASTROW][col] = 'o';
				deciding = false;;
			}
			else if(board[LASTROW][col] == 'x' || board[LASTROW][col] == 'o'){ 
				if(board[LASTROW - counter][col] == '-'){ 
					board[LASTROW - counter][col] = 'o';
					deciding = false;
				}
			}
			if(counter == WIDTH){ 
				System.out.println("Can't drop a piece here.");
				deciding = false;;
			}
			counter += 1; 
		}  
	}


	private static void generatePlayingField() {
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				board[row][col]='-';
			}
		}
	}



	private static int generateRandomNumberBetween(int max,int min){
		int randomNum = min + (int)(Math.random() * ((max - min) + 1));
		return randomNum;
	}

	public static void printBoard(char[][] board2){
		for(int row = 0;row < board2.length;row++){
			for(int col = 0;col < board2[row].length;col++){
				System.out.print(board2[row][col]);
			}
			System.out.println();
		}
	}
}