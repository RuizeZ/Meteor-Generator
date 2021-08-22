package MultiThread082121;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Move {
	public Ball(int x, int y) {
		super(x, y);
	}

	public void drawBall(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(getX() - getSpeedx() * 50, getY() - getSpeedy() * 50, getSize(), getSize());
		move();
		g.setColor(Color.WHITE);
		g.fillRect(getX(), getY(), getSize(), getSize());
	}
}
