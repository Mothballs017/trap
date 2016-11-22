package NikitaAndMathew;

public class MapNikita {

	public static void darkenMap() {
		for(int i = 0; i < EventNikitaAndMathew.portals.length; i++){
			for(int j = 0; j < EventNikitaAndMathew.portals[0].length; j++){
				EventNikitaAndMathew.portals[i][j].setDefaultContents("#");
				EventNikitaAndMathew.portals[i][j].leave();
			}
		}
		for(int i = 0; i < EventNikitaAndMathew.portals.length; i++){
			for(int j = 0; j < EventNikitaAndMathew.portals[0].length; j++){
				EventNikitaAndMathew.portals[i][j].setDefaultContents(" ");
				EventNikitaAndMathew.portals[i][j].leave();
			}
		}
	}

}
