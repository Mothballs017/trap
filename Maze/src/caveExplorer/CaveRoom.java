package caveExplorer;

import NikitaAndMathew.EventNikitaAndMathew;
import NikitaAndMathew.MapNikita;

public class CaveRoom {

	//	"final" never changes
	//	constants are public and ALL-CAPS
	//	example: Math.PI;
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;

	private String description;
	private String contents;
	private String defaultContents;
	private String directions;
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;

	public CaveRoom(String description){
		this.description = description;
				
		setDefaultContents(" ");
		contents = defaultContents;

		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		for(int i = 0 ; i < borderingRooms.length; i++){
			borderingRooms[i] = null;
			doors[i] = null;
		}
		setDirections();
	}

	protected void setDirections() {
		directions	= "";
		if(doors[NORTH] == null && 
				doors[EAST] == null &&
				doors[SOUTH] == null &&
				doors[WEST] == null){
			directions = "\n\nThis is a room with no exit.";		
		}else{
			for(int dir = 0; dir < doors.length; dir++){
				if(doors[dir] != null){
					directions += "\nThere is a "+doors[dir].getDescription()+" to "+toDirection(dir)+". "+doors[dir].getDetails();
				}
			}
		}

	}
	private String toDirection(int dir) {
		String[] directions = {"the North","the East","the South","the West"};
		return directions[dir];
	}
	public String getContents(){
		return contents;
	}
	public void enter(){
		contents = "X";
	}
	public void leave(){
		contents = defaultContents;
	}
	public void setDefaultContents(String symbol){
		defaultContents = symbol;
	}
	public void addRoom(int direction, CaveRoom anotherRoom, Door door){
		borderingRooms[direction] = anotherRoom;
		doors[direction] = door;
		setDirections();
	}
	/**
	 * Gives this room access to anotherRoom (and vice-versa) and
	 * sets a door between them, and updates the directions
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door){
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	/**
	 * 
	 * @param dir
	 * @return opposite direction of dir (NORTH returns SOUTH...)
	 */
	public static int oppositeDirection(int dir){
		return (dir+2)%4;
	}
	public String getDescription(){
		return description+directions;
	}
	public Door getDoor(int dir){
		return doors[dir];
	}
	public void setDescription(String string) {
		description = string;
	}
	public void interpretInput(String input, boolean cave) {
		while(!isValid(input)){
			System.out.println("You can only enter "+"'w','a','s', or 'd'.");
			input = CaveExplorer.in.nextLine();
		}
		String[] keys = {"w","d","s","a"};
		int indexFound = -1;
		for(int i = 0; i < keys.length; i++){
			if(input.equals(keys[i])){
				indexFound = i;
				break;
			}
		}
		if(cave){
			goToRoom(indexFound);
		}
		else{
			goToPortalRoom(indexFound);
		}
	}

	public void goToRoom(int direction){
		if(borderingRooms[direction] != null && doors[direction].isOpen()){
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
	}
	
	public void goToPortalRoom(int direction){
		if(borderingRooms[direction] != null && doors[direction].isOpen()){
			EventNikitaAndMathew.currentPortalRoom.leave();
			EventNikitaAndMathew.currentPortalRoom = borderingRooms[direction];
			EventNikitaAndMathew.currentPortalRoom.enter();
			MapNikita.checkForPortal();
			MapNikita.checkForEnd();
			MapNikita.updatePortalMap();
		}
	}
	
	private boolean isValid(String s) {
		String lc = s.toLowerCase();
		String[] keys = {"w","a","s","d"};
		for(String key:keys){
			if(key.equals(lc))return true;
		}
		return false;
	}

	public int getRow() {
		// TODO Auto-generated method stub
		return 0;
	}


}
