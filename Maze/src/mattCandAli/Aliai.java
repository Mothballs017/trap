package mattCandAli;

public class Aliai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean hasWon() { 
		boolean status = false; 

		// check for a horizontal win 
		int[][] grid = null;
		for (int row=0; row<6; row++) { 
			for (int col=0; col<4; col++) { 
				if (grid[col][row]!= 0 && grid[col][row] == grid[col+1][row] && grid[col][row] == grid[col+2][row] && grid[col][row] == grid[col+3][row]) { 
					status = true; 
				}        
			}      
		}

		//as
		// check for a vertical win 
		for (int row=0; row<3; row++) { 
			for (int col=0; col<7; col++) { 
				if (grid[col][row] != 0 && 
						grid[col][row] == grid[col][row+1] && 
						grid[col][row] == grid[col][row+2] && 
						grid[col][row] == grid[col][row+3]) { 
					status = true; 
				}        
			}       }   

		// check for a diagonal win (positive slope) 
		for (int row=0; row<3; row++) { 
			for (int col=0; col<4; col++) { 
				if (grid[col][row] != 0 && 
						grid[col][row] == grid[col+1][row+1] && 
						grid[col][row] == grid[col+2][row+2] && 
						grid[col][row] == grid[col+3][row+3]) { 
					status = true; 
				}        
			}      
		}    

		// check for a diagonal win (negative slope) 
		for (int row=3; row<6; row++) { 
			for (int col=0; col<4; col++) { 
				if (grid[col][row] != 0 && 
						grid[col][row] == grid[col+1][row-1] && 
						grid[col][row] == grid[col+2][row-2] && 
						grid[col][row] == grid[col+3][row-3]) { 
					status = true; 
				}        
			}      
		}    
		return status; 
	}

	// check where to drop the piece 
	public int nextSpace(int x){
		for(int y = x-1; y>=0; y--){
			int[][] board = null;
			if (board[y] [x] == 0){
				return y;
			}

		}
		return -1; 
	}

}

