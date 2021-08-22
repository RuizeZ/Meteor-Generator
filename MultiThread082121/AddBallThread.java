package MultiThread082121;

import java.util.ArrayList;
import java.util.Random;

public class AddBallThread extends Thread {
	private ArrayList<Ball> listBall;

	public AddBallThread(ArrayList<Ball> listBall) {
		this.listBall = listBall;
	}

	public void run() {
		Random rand = new Random();
		int sleep;
		while (true) {
			try {
				sleep = rand.nextInt(5000 - ButtonListener.frequency) + 50;
			} catch (Exception e) {
				// TODO: handle exception
				sleep = 100;
			}

			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int startY = rand.nextInt(300);
			Ball ball = new Ball(0, startY);
			listBall.add(ball);
		}

	}

}
