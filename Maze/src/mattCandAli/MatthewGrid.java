package mattCandAli;

public class MatthewGrid {

//		create a grid 6 down and 7 across
//		4 in a row is winner
//		could set all open spaces to x, once used switch to o
//		randomly set who goes first. maybe 1-10, if >= 5, computer goes first
//		player/computer names the column, not row. 
//		next open slot is filled by an o
//		once placed, check win conditions. horizontal, if 4 in a row, vertical, if 4 in a row, if diagonal 4 in a row
//		keep looping until a player wins
	
	
	
	public static void main(String[] args){
		String[][] arr2D = new String[6][7];
		boolean[][] bool2D = new boolean[6][7];
		for(int row = 0; row < arr2D.length; row++){
			for(int col = 0; col < arr2D[row].length; col++){
				arr2D[row][col]=" x ";
			}
		}
		for(int row = 0;row < arr2D.length;row++){
			for(int col = 0;col < arr2D[row].length;col++){
				System.out.print(arr2D[row][col]);
			}
			System.out.println();
		}
	}
	

}
