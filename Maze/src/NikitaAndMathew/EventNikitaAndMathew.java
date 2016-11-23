package NikitaAndMathew;

import java.util.Scanner;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Door;
import caveExplorer.Event;

public class EventNikitaAndMathew implements Event {
	
	private static boolean hasPortalMap;
	public static String PortalMap;
	public static CaveRoom portals[][];
	public static CaveRoom currentPortalRoom;
	public static Scanner in;

	public static final String[] SEQ_1 = {
			"You: 'Uhh, where am I?'",
			"You: 'This place... Its so dark and-d-d cold-d-d.'",
			"You: 'I see, these walls are made of carbon nanotubes. They absorb 99% of all the light around.'"};
	
	public static void PortalStartEvent() {
		// TODO Auto-generated constructor stub
	}

	public void play() {
		in = new Scanner(System.in);
		portals = new CaveRoom[5][10];
		for(int row = 0; row < portals.length; row++){
			for(int col = 0; col < portals[row].length; col++){
				portals[row][col] = new CaveRoom("Location: "+row+","+col);
			}
		}
		readSequence(SEQ_1);
		currentPortalRoom = portals[0][0];
		makeConnections();
		MapNikita.darkenMap();
		currentPortalRoom.enter();
		MapNikita.uncoverMap();
		PortalInventory(); //Makes portal map invisible by default and creates the map.
		setPortalMap(true); //Allows the portal map to become visible to the user.
		System.out.println("Cheat Code: 'SKIP'");
		makeMove(); //Asks for you to make your next move and shows the portal map.
	}
	
	private void makeConnections() {
		 //Room 1
		 portals[0][0].setConnection(CaveRoom.EAST,portals[0][1],new Door());
		 portals[0][0].setConnection(CaveRoom.SOUTH,portals[1][0],new Door());
		 portals[0][1].setConnection(CaveRoom.SOUTH,portals[1][1],new Door());
		 portals[1][0].setConnection(CaveRoom.EAST,portals[1][1],new Door());
		 portals[1][1].setConnection(CaveRoom.SOUTH,portals[2][1],new Door());
		 
		 //Room 2
		 portals[0][2].setConnection(CaveRoom.EAST,portals[0][3],new Door());
		 portals[0][2].setConnection(CaveRoom.SOUTH,portals[1][2],new Door());
		 portals[0][3].setConnection(CaveRoom.SOUTH,portals[1][3],new Door());
		 portals[1][3].setConnection(CaveRoom.SOUTH,portals[2][3],new Door());
		 portals[2][3].setConnection(CaveRoom.EAST,portals[2][4],new Door());
		 portals[2][2].setConnection(CaveRoom.EAST,portals[2][3],new Door());
		 
		 //Room 3
		 portals[0][4].setConnection(CaveRoom.SOUTH,portals[1][4],new Door());
		 portals[1][4].setConnection(CaveRoom.EAST,portals[1][5],new Door());
		 portals[0][5].setConnection(CaveRoom.SOUTH,portals[1][5],new Door());
		 portals[0][5].setConnection(CaveRoom.EAST,portals[0][6],new Door());
		 portals[1][5].setConnection(CaveRoom.EAST,portals[1][6],new Door());
		 portals[1][6].setConnection(CaveRoom.EAST,portals[1][7],new Door());
		 portals[0][7].setConnection(CaveRoom.SOUTH,portals[1][7],new Door());
		 portals[0][7].setConnection(CaveRoom.EAST,portals[0][8],new Door());
		 
		 //Room 4
		 portals[0][9].setConnection(CaveRoom.SOUTH,portals[1][9],new Door());
		 portals[1][9].setConnection(CaveRoom.SOUTH,portals[2][9],new Door());
		 portals[1][8].setConnection(CaveRoom.EAST,portals[1][9],new Door());
		 portals[2][8].setConnection(CaveRoom.EAST,portals[2][9],new Door());
		 portals[1][8].setConnection(CaveRoom.SOUTH,portals[2][8],new Door());
		 portals[2][7].setConnection(CaveRoom.EAST,portals[2][8],new Door());
		 
		 //Room 5
		 portals[3][9].setConnection(CaveRoom.SOUTH,portals[4][9],new Door());
		 portals[3][8].setConnection(CaveRoom.SOUTH,portals[4][8],new Door());
		 portals[3][8].setConnection(CaveRoom.EAST,portals[3][9],new Door());
		 portals[4][8].setConnection(CaveRoom.EAST,portals[4][9],new Door());
		 portals[4][6].setConnection(CaveRoom.EAST,portals[4][7],new Door());
		 portals[4][7].setConnection(CaveRoom.EAST,portals[4][8],new Door());
		 
		 //Room 6
		 portals[2][6].setConnection(CaveRoom.SOUTH,portals[3][6],new Door());
		 portals[2][5].setConnection(CaveRoom.EAST,portals[2][6],new Door());
		 portals[3][6].setConnection(CaveRoom.EAST,portals[3][7],new Door());
		 
		 //Room 7
		 portals[4][2].setConnection(CaveRoom.EAST,portals[4][3],new Door());
		 portals[3][3].setConnection(CaveRoom.SOUTH,portals[4][3],new Door());
		 portals[3][3].setConnection(CaveRoom.EAST,portals[3][4],new Door());
		 portals[3][4].setConnection(CaveRoom.EAST,portals[3][5],new Door());
		 portals[4][4].setConnection(CaveRoom.EAST,portals[4][5],new Door());
		 portals[3][4].setConnection(CaveRoom.SOUTH,portals[4][4],new Door());
		 portals[3][5].setConnection(CaveRoom.SOUTH,portals[4][5],new Door());
		 
		 //Room 8
		 portals[2][0].setConnection(CaveRoom.SOUTH,portals[3][0],new Door());
		 portals[3][0].setConnection(CaveRoom.SOUTH,portals[4][0],new Door());
		 portals[4][0].setConnection(CaveRoom.EAST,portals[4][1],new Door());
		 portals[3][1].setConnection(CaveRoom.EAST,portals[3][2],new Door());
		 portals[3][1].setConnection(CaveRoom.SOUTH,portals[4][1],new Door());
	}

	private static void makeMove() {
		while(true){
			System.out.println(getDescription());
			if(MapNikita.foundEnd){
				break;
			}
			System.out.println(currentPortalRoom.getDescription());
			System.out.println("You: Where should I go?");
			String input = in.nextLine();
			if(input.equals("SKIP")){
				System.out.println("You just skipped the portal event!");
				break;
			}
			currentPortalRoom.interpretInput(input, false);
		}
	}
	
	
	
	public void PortalInventory(){
		hasPortalMap = false;
		createPortalMap();
	}

	public static void readSequence(String[] seq) {
		for(int i = 0; i < seq.length; i++){
			CaveExplorer.print(seq[i]);
			if(i == 0){
				CaveExplorer.print("Press Enter to Continue...");
			}
			if(i == 1){
				CaveExplorer.print("Press Enter to Walk...");
			}
			if(i == 2){
				CaveExplorer.print("Press Enter to Continue...");
			}
			
			CaveExplorer.in.nextLine();
		}
	}
	
	public void setPortalMap(boolean b) {
		hasPortalMap = b;
	}
	public static String getDescription() {
		if(hasPortalMap){
			return PortalMap;
		}else{
			return "Inventory: Empty";
		}
	}
	public static void createPortalMap() {
		PortalMap = " ";
		for(int i = 0; i < portals[0].length - 1; i++){
			PortalMap += "____";
		}
		PortalMap += "___\n";
		for(CaveRoom[] row: portals){
			for(int i = 0; i < 3; i++){
				String text = "";
				for(CaveRoom cr: row){
					if(cr.getDoor(CaveRoom.WEST) != null && cr.getDoor(CaveRoom.WEST).isOpen()){
						text += " ";
					}
					else{
						text += "|";
					}
					if(i == 0){
						if(cr.getContents() == "X"){
							text += "   ";
						}else{
							text += cr.getContents()+cr.getContents()+cr.getContents();
						}
					}
					else if(i == 1){
						if(cr.getContents() == "X"){
							text += " "+cr.getContents()+" ";
						}else{
							text += cr.getContents()+cr.getContents()+cr.getContents();
						}
					}		
					else if(i == 2){
						if(cr.getDoor(CaveRoom.SOUTH) != null && cr.getDoor(CaveRoom.SOUTH).isOpen()){
							if(cr.getContents() == "X"){
								text += "   ";
							}else{
								text += cr.getContents()+cr.getContents()+cr.getContents();
							}
						}
						else{
							text += "___";
						}
					}
				}
				text += "|";
				PortalMap += text+"\n";
			}
		}
	}
}
