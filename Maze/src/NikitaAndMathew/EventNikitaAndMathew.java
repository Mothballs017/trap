package NikitaAndMathew;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Event;

public class EventNikitaAndMathew implements Event {
	
	private static boolean hasPortalMap;
	private static String PortalMap;
	public static CaveRoom portals[][];
	public static CaveRoom currentPortalRoom;

	public static final String[] SEQ_1 = {
			"'Uhh, where am I?'",
			"'This place... Its so dark and-d-d cold-d-d.'",
			"'I see, these walls are made of carbon nanotubes. They absorb 99% of all the light around.'"};
	
	public static final String[] SEQ_2 = {
			"Great, I will be busy meditating on my super yellow version while you figure out where BUU is.",
			"Kaaaa, maaaaay..."};
	
	public static void PortalStartEvent() {
		// TODO Auto-generated constructor stub
	}

	public void play() {
		portals = new CaveRoom[5][10];
		readSequence(SEQ_1);
		PortalInventory();
		currentPortalRoom = portals[0][0];
		currentPortalRoom.enter();
		setPortalMap(true);
		System.out.println(getDescription());
		System.out.println(currentPortalRoom.getDescription());
	}
	
	public void PortalInventory(){
		hasPortalMap = true;
		updatePortalMap();
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
			return "";
		}
	}
	public void updatePortalMap() {
		PortalMap = " ";
		for(int i = 0; i < portals[0].length - 1; i++){
			PortalMap += "____";//4
		}
		PortalMap += "___\n";//3
		for(CaveRoom[] row: portals){
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
						text += "   ";//3
					}
					else if(i == 1){
						text += " "+cr.getContents()+" ";
					}
					else if(i == 2){
						if(cr.getDoor(CaveRoom.SOUTH) != null && cr.getDoor(CaveRoom.SOUTH).isOpen()){
							text += "   ";//3
						}
						else{
							text += "___";//3
						}
					}
				}//last cave room in the row
				text += "|";
				PortalMap += text+"\n";
			}//last of the 3 text lines
		}//last row
	}
}
