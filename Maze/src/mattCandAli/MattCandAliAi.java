package mattCandAli;

import java.util.Random;

public class MattCandAliAi {
	
	public static void computerSelect() {
		int counter = 1;
		int col = randInt(MatthewGrid.WIDTH-1,MatthewGrid.HEIGHT-1);
		boolean deciding = true;
		while(deciding){
			while(col > MatthewGrid.WIDTH || col < MatthewGrid.WIDTH-MatthewGrid.WIDTH){
				col = randInt(MatthewGrid.WIDTH-1,MatthewGrid.HEIGHT-1);
			}
			if(MatthewGrid.board[MatthewGrid.LASTROW][col] == '-'){
				System.out.println("Computer dropped a piece in column "+col+".");
				MatthewGrid.board[MatthewGrid.LASTROW][col] = 'x';
				deciding = false;
			}
			else if(MatthewGrid.board[MatthewGrid.LASTROW][col] == 'o' || MatthewGrid.board[MatthewGrid.LASTROW][col] == 'x'){ 
				if(MatthewGrid.board[MatthewGrid.LASTROW - counter+1][col] == '-'){ 
					System.out.println("Computer dropped a piece in column "+col+".");
					MatthewGrid.board[MatthewGrid.LASTROW - counter+1][col] = 'x';
					deciding = false;
				}
			}
			if(counter == MatthewGrid.WIDTH){ 
				deciding = false;
			}
			counter += 1; 
		}
	}
	public static int randInt(int min, int max) {
		Random gen = new Random();
		int randomNum = gen.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public static boolean checkComputerWin() {
		boolean[] compWin = {false, false, false, false};
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
			for(int row = 0; MatthewGrid.WIDTH > row; row += 1){
				for(int col = 0; MatthewGrid.HEIGHT > col; col += 1){
					if(MatthewGrid.board[row][col] == 'x'){
						ctr += 1;
					}else{
						ctr = 0; 
					}
					if(ctr >= 4){
						System.out.println("You lost..."); 
						compWin[0] = horizontal;
						horizontal = false;
					}
				}
			}
			break;
		}
		ctr = 0;
		while(vertical){
			for(int col = 0; MatthewGrid.HEIGHT > col; col += 1){
				for(int row = 0; MatthewGrid.WIDTH > row; row += 1){
					if(MatthewGrid.board[row][col] == 'x'){
						ctr += 1;
					}else{
						ctr = 0;
					}
					if(ctr >= 4){
						System.out.println("You lost...");
						compWin[1] = vertical;
						vertical = false;
					}
				}
			}
			break;
		}
		ctr = 0;
		while(diagonalRight){
			for(int row = 0; MatthewGrid.WIDTH > row; row += 1){
				for(int col = 0; MatthewGrid.HEIGHT > col; col += 1){
					if(MatthewGrid.board[row][col] == 'x'){
						ctr += 1;
						diagonalCheck = true;
						while(diagonalCheck){
							if(checkCol + row <= MatthewGrid.WIDTH - 1 && checkRow + col <= MatthewGrid.HEIGHT - 1){
								if(MatthewGrid.board[row + checkCol][col + checkRow] == 'o'){
									ctr += 1;
								}
							}
							checkCol += 1;
							checkRow += 1;
							if(checkCol == MatthewGrid.WIDTH -1 || checkRow == MatthewGrid.HEIGHT -1){
								diagonalCheck = false;
								break;
							}
							if(ctr >= 4){
								System.out.println("You lost...");
								compWin[2] = diagonalRight;
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
			for(int row = 0; MatthewGrid.WIDTH > row; row += 1){
				for(int col = 0; MatthewGrid.HEIGHT > col; col += 1){
					if(MatthewGrid.board[row][col] == 'x'){
						ctr += 1;
						diagonalCheck = true;
						while(diagonalCheck){
							if(row - checkCol >= 0 && col - checkRow >= 0){
								if(MatthewGrid.board[row - checkCol][col - checkRow] == 'x'){
									ctr += 1;
								}
							}
							checkCol += 1;
							checkRow += 1;
							if(checkCol == 0 || checkRow == MatthewGrid.HEIGHT -1){
								diagonalCheck = false;
								break;
							}
							if(ctr >= 4){
								System.out.println("You lost...");
								compWin[3] = diagonalLeft;
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
		for(int i = 0; i < compWin. length; i++){
			if(compWin[i] == true){
				win = true;
			}
		}
		return win;
	}
}
