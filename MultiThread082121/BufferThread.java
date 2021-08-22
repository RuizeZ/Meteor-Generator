package MultiThread082121;

import java.awt.Color;
import java.awt.Graphics;

public class BufferThread extends Thread {
	UI myUI;
	Graphics frameGraphics;

	public BufferThread(UI myUI, Graphics frameGraphics) {
		this.frameGraphics = frameGraphics;
		this.myUI = myUI;
	}

	@Override
	public void run() {

		while (true) {
			frameGraphics.drawImage(StarThread.starBufferedImage, 0, 80, myUI.getWidth(), myUI.getHeight() - 80, null);
		}
	}
}
