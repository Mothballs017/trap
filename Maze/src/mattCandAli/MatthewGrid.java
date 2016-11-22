package mattCandAli;

import java.util.Scanner;

public class MatthewGrid {

	//		create a grid 6 down and 7 across -done
	//		4 in a row is winner 
	//		could set all open spaces to -, once used switch to o for player and o for ai
	//		player always goes first - done
	//		player/computer names the column, not row. -done (used LASTROW final) 
	//		neot open slot is filled by an o,o - done
	//		once placed, check win conditions. horizontal, if 4 in a row, vertical, if 4 in a row, if diagonal 4 in a row
	//		keep looping until a player wins - done
	//		NOTES: - Apparently, using a String array clashed with int col = scanner.neotInt();
	//				- Also, switching to a char array seems to require apostrophes instead of quotes
	//				- the win condition measures horizontal, vertical, and diagonals left and right, any one condition satisfied guarantees win
	final static int WIDTH = 6;
	final static int HEIGHT = 7;
	final static int LASTROW = WIDTH -1;
	public static char[][] board = new char[WIDTH][HEIGHT];
	public static boolean gameLoop = true;
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){
		generateBoard();
		System.out.println("Beat this game of Connect 4 to pass! Your piece will be an Select a column by choosing its corresponding indeo.\n 0123456");
		printBoard(board);
		System.out.println("You can skip this game by entering the passphrase: HANLEY");
		if(scanner.nextLine().equals("HANLEY")){
			gameLoop = false;
		}
		while(gameLoop){
			playerSelect();
			printBoard(board);
			if(checkPlayerWin()==true){
				gameLoop = false;
				break; //skip computer if win
			}
			MattCandAliAi.computerSelect();
			printBoard(board);
			if(MattCandAliAi.checkComputerWin() == true){
	              gameLoop = false;
	              break;
	        }
		}
	}
	private static void generateBoard() {
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				board[row][col]='-';
			}
		}
	}
	private static void printBoard(char[][] board2){
		for(int row = 0;row < board2.length;row++){
			for(int col = 0;col < board2[row].length;col++){
				System.out.print(board2[row][col]);
			}
			System.out.println();
		}
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
			while(col > WIDTH || col < WIDTH - WIDTH){
				System.out.println("That's not a valid column, enter numbers between 0-6");
				col = scanner.nextInt();
			}
			if(board[LASTROW][col] == '-'){ 
				board[LASTROW][col] = 'o';
				deciding = false;
			}
			else if(board[LASTROW][col] == 'o' || board[LASTROW][col] == 'x'){ 
				if(board[LASTROW - counter+1][col] == '-'){ 
					board[LASTROW - counter+1][col] = 'o';
					deciding = false;
				}
			}
			if(counter == WIDTH){ 
				System.out.println("Can't drop a piece here.");
			}
			counter += 1; 
			
		}  
		
	}

	private static boolean checkPlayerWin() {
		//check: HORIZONTAL done
		//		VERTICAL done
		//		DIAGONAL right,left
		boolean[] playerWin = {false, false, false, false};
		boolean win = false;
		boolean diagonalCheck = false;
		boolean horizontal = true;
		boolean vertical = true;
		boolean diagonalRight = true;
		boolean diagonalLeft = true;
		int checkCol = 1;
		int checkRow = 1;
		int ctr = 0;
		while(horizontal){
			for(int row = 0; WIDTH > row; row += 1){
				for(int col = 0; HEIGHT > col; col += 1){
					if(board[row][col] == 'o'){
						ctr += 1;
					}else{
						ctr = 0; 
					}
					if(ctr >= 4){
						System.out.println("You won!"); 
						playerWin[0] = horizontal;
						horizontal = false;
					}
				}
			}
			break;
		}
		ctr = 0;
		while(vertical){//checks vertical combo
			for(int col = 0; HEIGHT > col; col += 1){
				for(int row = 0; WIDTH > row; row += 1){
					if(board[row][col] == 'o'){ 
						ctr += 1;
					}else{
						ctr = 0; 
					}
					if(ctr >= 4){
						System.out.println("You won!"); 
						playerWin[1] = vertical;
						vertical = false;
					}
				}
			}
			break;
		}
		ctr = 0;
		while(diagonalRight){
			for(int row = 0; WIDTH > row; row += 1){
				for(int col = 0; HEIGHT > col; col += 1){
					if(board[row][col] == 'o'){
						ctr += 1;
						diagonalCheck = true;
						while(diagonalCheck){
							if(checkCol + row <= WIDTH - 1 && checkRow + col <= HEIGHT - 1){
								if(board[row + checkCol][col + checkRow] == 'o'){
									ctr += 1;
								}
							}
							checkCol += 1;
							checkRow += 1;
							if(checkCol == WIDTH -1 || checkRow == HEIGHT -1){//no overflow
								diagonalCheck = false;
								break;
							}
							if(ctr >= 4){
								System.out.println("You won!");
								playerWin[2] = diagonalRight;
								diagonalCheck = false;
								diagonalRight = false;
								break;
							}
						}
					}
					if(ctr >= 4){
						diagonalRight = false;
						break;
					}
					ctr = 0;
					checkCol = 1;
					checkRow = 1;
				}
			}
			break;
		}
		checkCol = 1; 
		checkRow = 1;
		diagonalCheck = false;
		while(diagonalLeft){
			for(int row = 0; WIDTH > row; row += 1){
				for(int col = 0; HEIGHT > col; col += 1){
					if(board[row][col] == 'o'){
						ctr += 1;
						diagonalCheck = true;
						while(diagonalCheck){ 
							if(row - checkCol >= 0 && col - checkRow >= 0){
								if(board[row - checkCol][col - checkRow] == 'o'){
									ctr += 1; 
								}
							}
							checkCol += 1;
							checkRow += 1;
							if(checkCol == 0 || checkRow == HEIGHT -1){
								diagonalCheck = false;
								break;
							}
							if(ctr >= 4){
								System.out.println("You won!");
								playerWin[3] = diagonalLeft;
								diagonalCheck = false;
								diagonalLeft = false;
								break;
							}
						}
					}
					if(ctr >= 4){
						diagonalLeft = false;
						break;
					}
					ctr = 0;
					checkCol = 1;
					checkRow = 1;
				}
			}
			break;
		}
		for(int i = 0; i < playerWin. length; i++){
			if(playerWin[i] == true){
				win = true;
			}
		}
		return win;
	}
}