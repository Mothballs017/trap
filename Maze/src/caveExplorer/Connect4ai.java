package caveExplorer;

public class Connect4ai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean hasWon() { 
		boolean status = false; 

		// check for a horizontal win 
		int[][] grid;
		for (int row=0; row<6; row++) { 
			for (int column=0; column<4; column++) { 
				if (grid[column][row]!= 0 && grid[column][row] == grid[column+1][row] && grid[column][row] == grid[column+2][row] && grid[column][row] == grid[column+3][row]) { 
					status = true; 
				}        
			}      
		}


		// check for a vertical win 
		for (int row=0; row<3; row++) { 
			for (int column=0; column<7; column++) { 
				if (grid[column][row] != 0 && 
						grid[column][row] == grid[column][row+1] && 
						grid[column][row] == grid[column][row+2] && 
						grid[column][row] == grid[column][row+3]) { 
					status = true; 
				}        
			}       }   

		// check for a diagonal win (positive slope) 
		for (int row=0; row<3; row++) { 
			for (int column=0; column<4; column++) { 
				if (grid[column][row] != 0 && 
						grid[column][row] == grid[column+1][row+1] && 
						grid[column][row] == grid[column+2][row+2] && 
						grid[column][row] == grid[column+3][row+3]) { 
					status = true; 
				}        
			}      
		}    

		// check for a diagonal win (negative slope) 
		for (int row=3; row<6; row++) { 
			for (int column=0; column<4; column++) { 
				if (grid[column][row] != 0 && 
						grid[column][row] == grid[column+1][row-1] && 
						grid[column][row] == grid[column+2][row-2] && 
						grid[column][row] == grid[column+3][row-3]) { 
					status = true; 
				}        
			}      
		}    
		return status; 
		//check for tie
		for(int y = 0; y<h; y++)for(int x=0;x<w;x++){
			if (p(y,x)==0){
			return 0; //winner 
			}
		return -1; // tie
	}

	// check where to drop the piece 
	int nextSpace(int x){
		for(int y = h-1; y>=0; y--){
			if (board[y] [x] == 0){
				return y;
		return -1; 	
			}

	}




}


