package NikitaAndMathew;

import caveExplorer.CaveRoom;

public class MapNikita {
	
	public static final String[] SEQ_PORTAL = {
			"You: 'Alright, a portal, lets go through it!'"};
	
	public static final String[] SEQ_END = {
	"You: 'I did it! I found my way back!'"};
	
	private static int endRow;
	private static int endCol;

	public static boolean foundEnd;

	public static void darkenMap() {
		for(int i = 0; i < EventNikitaAndMathew.portals.length; i++){
			for(int j = 0; j < EventNikitaAndMathew.portals[0].length; j++){
				EventNikitaAndMathew.portals[i][j].setDefaultContents("/");
				EventNikitaAndMathew.portals[i][j].leave();
			}
		}
	}
	
	public static void uncoverMap() {
		for(int i = 0; i < EventNikitaAndMathew.portals.length; i++){
			for(int j = 0; j < EventNikitaAndMathew.portals[0].length; j++){
				EventNikitaAndMathew.portals[i][j].setDefaultContents(" ");
			}
		}
	}
	
	public static void checkForPortal(){
		if(PortalsMatthew.isPortalLocation()){
			EventNikitaAndMathew.currentPortalRoom.setDefaultContents("O");
			MapNikita.updatePortalMap();
			System.out.println(EventNikitaAndMathew.getDescription());
			EventNikitaAndMathew.readSequence(MapNikita.SEQ_PORTAL);
			EventNikitaAndMathew.currentPortalRoom.leave();
			PortalsMatthew.teleportToPortalLocation();
			EventNikitaAndMathew.currentPortalRoom.setDefaultContents("O");
			EventNikitaAndMathew.currentPortalRoom.enter();
		}
	}
	
	public static void checkForEnd(){
		endRow = 2;
		endCol = 0;
		
		if(EventNikitaAndMathew.currentPortalRoom == EventNikitaAndMathew.portals[endRow][endCol]){
			EventNikitaAndMathew.currentPortalRoom.setDefaultContents("O");
			MapNikita.updatePortalMap();
			System.out.println(EventNikitaAndMathew.getDescription());
			EventNikitaAndMathew.readSequence(MapNikita.SEQ_END);
			EventNikitaAndMathew.currentPortalRoom.leave();
			foundEnd = true;
		}
	}
	
	public static void updatePortalMap() {
		EventNikitaAndMathew.PortalMap = " ";
		for(int i = 0; i < EventNikitaAndMathew.portals[0].length - 1; i++){
			EventNikitaAndMathew.PortalMap += "____";
		}
		EventNikitaAndMathew.PortalMap += "___\n";
		for(CaveRoom[] row: EventNikitaAndMathew.portals){
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
						}
						else{
							if(cr.getContents() == "O"){
								text += " _ ";
							}else{
							text += cr.getContents()+cr.getContents()+cr.getContents();
							}
						}
					}
					else if(i == 1){
						if(cr.getContents() == "X"){
							text += " "+cr.getContents()+" ";
						}
						else{
							if(cr.getContents() == "O"){
								text += "("+cr.getContents()+")";
							}else{
							text += cr.getContents()+cr.getContents()+cr.getContents();
							}
						}
					}
					else if(i == 2){
						if(cr.getContents() == "X"){
							if(cr.getDoor(CaveRoom.SOUTH) != null && cr.getDoor(CaveRoom.SOUTH).isOpen()){
								text += "   ";
							}else{
								text += "___";
							}
						}else{
							text += "///";
						}
						
					}
				}
				if(cr.getContents() == "X"){
					text += "|";
				}else{
					text += "/";
				}
				
				EventNikitaAndMathew.PortalMap += text+"\n";
			}
		}
	}

}
