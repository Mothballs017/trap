package NikitaAndMathew;

public class PortalsMatthew {
	
	public static int[][] portalLocationsSetOne = new int[9][2];
	public static int[][] portalLocationsSetTwo = new int[9][2];
		
		
	private static int yCoordinate = 0;
	private static int xCoordinate = 0;
	
	public static void teleportToPortalLocation(){
		//sends user to the teleported destination
		EventNikitaAndMathew.currentPortalRoom = EventNikitaAndMathew.portals[yCoordinate][xCoordinate];
	}
	
	public static boolean isPortalLocation() {
		setPortalLocations();//sets portal locations
		
		//checks if currentPortalRoom is a room with a portal
		//each array checks 1 of the 2 pairs of coordinates that have portals linked to each other
		for(int row = 0; row < portalLocationsSetOne.length; row++){
			if(EventNikitaAndMathew.currentPortalRoom == EventNikitaAndMathew.portals[portalLocationsSetOne[row][0]] [portalLocationsSetOne[row][1]]){
				//sets coordinates for where the user will be teleported
				yCoordinate = portalLocationsSetTwo[row][0];
				xCoordinate = portalLocationsSetTwo[row][1];
				return true;
			}
		}
		
		for(int row = 0; row < portalLocationsSetTwo.length; row++){
			if(EventNikitaAndMathew.currentPortalRoom == EventNikitaAndMathew.portals[portalLocationsSetTwo[row][0]] [portalLocationsSetTwo[row][1]]){
				//sets coordinates for where the user will be teleported
				yCoordinate = portalLocationsSetOne[row][0];
				xCoordinate = portalLocationsSetOne[row][1];
				return true;
			}
		}
		/*
		if(EventNikitaAndMathew.currentPortalRoom == EventNikitaAndMathew.portals[0][0]||EventNikitaAndMathew.currentPortalRoom == EventNikitaAndMathew.portals[1][1]){
			return true;
		}
		*/
		return false;
		
	}
	public static void setPortalLocations(){
		//sets all portal locations into 2 arrays
		//both arrays are parallel so for ex: set 1, portal 1 would send you to set 2, portal 1 and vice versa
		
		//set 1, portal 1
		portalLocationsSetOne[0][0] = 2;
		portalLocationsSetOne[0][1] = 1;
		//set 1, portal 2
		portalLocationsSetOne[1][0] = 0;
		portalLocationsSetOne[1][1] = 4;
		//set 1, portal 3
		portalLocationsSetOne[2][0] = 0;
		portalLocationsSetOne[2][1] = 6;
		//set 1, portal 4
		portalLocationsSetOne[3][0] = 0;
		portalLocationsSetOne[3][1] = 8;
		//set 1, portal 5
		portalLocationsSetOne[4][0] = 0;
		portalLocationsSetOne[4][1] = 9;
		//set 1, portal 6
		portalLocationsSetOne[5][0] = 2;
		portalLocationsSetOne[5][1] = 7;
		//set 1, portal 7
		portalLocationsSetOne[6][0] = 2;
		portalLocationsSetOne[6][1] = 4;
		//set 1, portal 8
		portalLocationsSetOne[7][0] = 1;
		portalLocationsSetOne[7][1] = 2;
		//set 1, portal 9
		portalLocationsSetOne[8][0] = 2;
		portalLocationsSetOne[8][1] = 2;
		

		//set 2, portal 1
		portalLocationsSetTwo[0][0] = 2;
		portalLocationsSetTwo[0][1] = 5;
		//set 2, portal 2
		portalLocationsSetTwo[1][0] = 3;
		portalLocationsSetTwo[1][1] = 7;
		//set 2, portal 3
		portalLocationsSetTwo[2][0] = 4;
		portalLocationsSetTwo[2][1] = 9;
		//set 2, portal 4
		portalLocationsSetTwo[3][0] = 2;
		portalLocationsSetTwo[3][1] = 9;
		//set 2, portal 5
		portalLocationsSetTwo[4][0] = 3;
		portalLocationsSetTwo[4][1] = 9;
		//set 2, portal 6
		portalLocationsSetTwo[5][0] = 4;
		portalLocationsSetTwo[5][1] = 5;
		//set 2, portal 7
		portalLocationsSetTwo[6][0] = 4;
		portalLocationsSetTwo[6][1] = 6;
		//set 2, portal 8
		portalLocationsSetTwo[7][0] = 4;
		portalLocationsSetTwo[7][1] = 2;
		//set 2, portal 9
		portalLocationsSetTwo[8][0] = 3;
		portalLocationsSetTwo[8][1] = 2;
	}
	
}
