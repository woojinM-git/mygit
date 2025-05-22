package homework;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AppClose extends WindowAdapter {

	TalkApp t;
	
	public AppClose(TalkApp n) {
		t = n;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
	}
	
	
}
