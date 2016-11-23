package NikitaAndMathew;

import caveExplorer.CaveRoom;

public class MapNikita {
	
	public static final String[] SEQ_PORTAL = {
			"You: 'Alright, a portal, lets go through it!'"};

	public static void darkenMap() {
		for(int i = 0; i < EventNikitaAndMathew.portals.length; i++){
			for(int j = 0; j < EventNikitaAndMathew.portals[0].length; j++){
				EventNikitaAndMathew.portals[i][j].setDefaultContents("#");
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
	
//	public static void checkForPortal(){
//		for(int i = 0; i < PortalsMatthew.portalLocationsSetOne.length - 1; i++){
//			if(EventNikitaAndMathew.currentPortalRoom.getRow() == PortalsMatthew.portalLocationsSetOne[i][0] && EventNikitaAndMathew.currentPortalRoom.col == PortalsMatthew.portalLocationsSetOne[i][1]){
//				EventNikitaAndMathew.currentPortalRoom.setDefaultContents(Integer.toString(i));
//				EventNikitaAndMathew.currentPortalRoom.enter();
//				updatePortalMap();
//				EventNikitaAndMathew.readSequence(SEQ_PORTAL);
//				EventNikitaAndMathew.currentPortalRoom = EventNikitaAndMathew.portals[PortalsMatthew.portalLocationsSetTwo[i][0]][PortalsMatthew.portalLocationsSetTwo[i][1]];
//				break;
//			}
//			if(EventNikitaAndMathew.currentPortalRoom.row == PortalsMatthew.portalLocationsSetTwo[i][0] && EventNikitaAndMathew.currentPortalRoom.col == PortalsMatthew.portalLocationsSetTwo[i][1]){
//				EventNikitaAndMathew.currentPortalRoom.setDefaultContents(Integer.toString(i));
//				EventNikitaAndMathew.currentPortalRoom.enter();
//				updatePortalMap();
//				EventNikitaAndMathew.readSequence(SEQ_PORTAL);
//				EventNikitaAndMathew.currentPortalRoom = EventNikitaAndMathew.portals[PortalsMatthew.portalLocationsSetOne[i][0]][PortalsMatthew.portalLocationsSetOne[i][1]];
//				break;
//			}
//		}
//	}
	
	public static void updatePortalMap() {
		EventNikitaAndMathew.PortalMap = " ";
		for(int i = 0; i < EventNikitaAndMathew.portals[0].length - 1; i++){
			EventNikitaAndMathew.PortalMap += "____";//4
		}
		EventNikitaAndMathew.PortalMap += "___\n";//3
		for(CaveRoom[] row: EventNikitaAndMathew.portals){
			//3 rows of text
			for(int i = 0; i < 3; i++){
				//a line of text for each room
				String text = "";
				for(CaveRoom cr: row){
					//text = "|";
					if(cr.getDoor(CaveRoom.WEST) != null && cr.getDoor(CaveRoom.WEST).isOpen()){
						text += " ";
					}
					else{
						text += "|";
					}
					if(i == 0){
						if(cr.getContents() == "X"){
							text += "   ";//3
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
								text += "   ";//3
							}else{
								text += cr.getContents()+cr.getContents()+cr.getContents();
							}
						}
						else{
							text += "___";//3
						}
					}
				}//last cave room in the row
				text += "|";
				EventNikitaAndMathew.PortalMap += text+"\n";
			}//last of the 3 text lines
		}//last row
	}

}
