package NikitaAndMathew;

import caveExplorer.CaveExplorer;
import caveExplorer.Event;

public class EventNikitaAndMathew implements Event {

	public static final String[] SEQ_1 = {
			"A spike-haired guy with orange pants flies up to you.",
			"Have you arrived to save us from the treacherous BUU?",
			"We need your help."};
	
	public static final String[] SEQ_2 = {
			"Great, I will be busy meditating on my super yellow version while you figure out where BUU is.",
			"Kaaaa, maaaaay..."};
	
	public static void PortalStartEvent() {
		// TODO Auto-generated constructor stub
	}

	public void play() {
		readSequence(SEQ_1);
		CaveExplorer.print("Will you help us?");
		while(CaveExplorer.in.nextLine().indexOf("yes")<0){
			CaveExplorer.print("Please say yes. I beg you!");
		}
		readSequence(SEQ_2);
		CaveExplorer.inventory.setMap(true);
	}

	public static void readSequence(String[] seq) {
		for(String s: seq){
			CaveExplorer.print(s);
			CaveExplorer.print(" - - - Press enter - - - ");
			CaveExplorer.in.nextLine();
		}
	}
}
