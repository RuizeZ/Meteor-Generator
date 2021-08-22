package MultiThread082121;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class StarThread extends Thread {
	static BufferedImage starBufferedImage;
	static Graphics bufferGraphics;
	Graphics frameGraphics;
	static ArrayList<Integer[]> starArrayList = new ArrayList<>();
	UI myUI;
	Random rand = new Random();

	public StarThread(UI myUI, Graphics frameGraphics) {
		this.frameGraphics = frameGraphics;
		this.myUI = myUI;
	}

	@Override
	public void run() {
		starBufferedImage = new BufferedImage(myUI.getWidth(), myUI.getHeight(), BufferedImage.TYPE_INT_RGB);
		bufferGraphics = starBufferedImage.getGraphics();

		Random rand = new Random();
		int starX, starY, starSize;
		for (int i = 0; i < 100; i++) {
			starX = rand.nextInt(myUI.getWidth());
			starY = rand.nextInt(myUI.getHeight());
			starSize = rand.nextInt(8);
			starArrayList.add(new Integer[] { starX, starY, starSize, setBrightness() });
		}
		while (true) {
			int addOrRemoveStar = rand.nextInt(3);

			if (addOrRemoveStar > 0) {
				starX = rand.nextInt(myUI.getWidth());
				starY = rand.nextInt(myUI.getHeight());
				starSize = rand.nextInt(8);
				starArrayList.add(new Integer[] { starX, starY, starSize, setBrightness() });
			} else if (addOrRemoveStar == 0 && starArrayList.size() > 0) {
				int darkStarIndedx = rand.nextInt(starArrayList.size());
				starX = starArrayList.get(darkStarIndedx)[0];
				starY = starArrayList.get(darkStarIndedx)[1];
				starSize = starArrayList.get(darkStarIndedx)[2];
				bufferGraphics.setColor(Color.BLACK);
				bufferGraphics.fillOval(starX, starY, starSize, starSize);
				starArrayList.remove(darkStarIndedx);
			}
			for (int i = 0; i < StarThread.starArrayList.size(); i++) {
				if (StarThread.starArrayList.get(i)[3] == 0) {
					StarThread.bufferGraphics.setColor(Color.GRAY);

				} else if (StarThread.starArrayList.get(i)[3] == 1) {
					StarThread.bufferGraphics.setColor(Color.LIGHT_GRAY);

				} else {
					StarThread.bufferGraphics.setColor(Color.WHITE);
				}
				StarThread.bufferGraphics.fillOval(StarThread.starArrayList.get(i)[0],
						StarThread.starArrayList.get(i)[1], StarThread.starArrayList.get(i)[2],
						StarThread.starArrayList.get(i)[2]);
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private int setBrightness() {
		int brightness = rand.nextInt(3);
		if (brightness == 0) {
			return 0;

		} else if (brightness == 1) {
			return 1;

		} else {
			return 2;
		}
	}

	public BufferedImage getBufferedImage() {
		return starBufferedImage;
	}

}
