package caveExplorer;

public class GameStartEvent implements Event {

	public static final String[] SEQ_1 = {
			"This is a room with no exit. You will die here. You thought you would actually escape.",
			"You slam on the walls in frustration.",
			"You: 'Isn't this supposed to be a dungeon of some sort? Where is the exit?'",
			"Hanley: 'You're stuck in here with me! Isn't this wonderful?'"};
	
	public static final String[] SEQ_2 = {
			"Oh, okay. I'll just...wait here for another thousand years until you change your mind then."};
	

	public void play() {
		CaveExplorer.currentRoom = CaveExplorer.caves[2][2];
		CaveExplorer.currentRoom.enter();
		readSequence(SEQ_1);
		CaveExplorer.print("Want to play another game?");
		while(CaveExplorer.in.nextLine().indexOf("no")<0){
			CaveExplorer.print("Please say yes!");
		}
		readSequence(SEQ_2);
		CaveExplorer.print("Hanley powers down leaving you in total darkness.");
	}

	public static void readSequence(String[] seq) {
		for(String s: seq){
			CaveExplorer.print(s);
			CaveExplorer.print(" - - - Press enter - - - ");
			CaveExplorer.in.nextLine();
		}
	}
}
