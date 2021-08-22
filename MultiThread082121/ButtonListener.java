package MultiThread082121;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ButtonListener implements ActionListener {
	StarThread starThread;
	Graphics myGraphics;
	private static ArrayList<Ball> listBall = new ArrayList<>();
	private ThreadBall tb = null;
	static int frequency = 0;
	UI myUI;

	public ButtonListener(Graphics myGraphics, UI myUI, StarThread starThread) {
		this.myGraphics = myGraphics;
		this.myUI = myUI;
		this.starThread = starThread;
	}

	public ButtonListener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		if ("add frequency".equals(name)) {
			frequency += 2000;
		}
		if ("start".equals(name)) {
			if (tb == null) {
				tb = new ThreadBall(myGraphics, listBall, myUI);
				tb.start();
			}
		}

	}

}
