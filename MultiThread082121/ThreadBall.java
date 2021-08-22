package MultiThread082121;

import java.awt.Graphics;
import java.util.ArrayList;

public class ThreadBall extends Thread {
	private Graphics g;
	private ArrayList<Ball> listBall;

	public ThreadBall(Graphics g, ArrayList<Ball> listBall, UI myUI) {
		this.g = g;
		this.listBall = listBall;
		AddBallThread newBall = new AddBallThread(listBall);
		newBall.start();
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (int i = 0; i < listBall.size(); i++) {
				Ball ball = listBall.get(i);
				ball.drawBall(StarThread.starBufferedImage.getGraphics());
			}
		}
	}
}
