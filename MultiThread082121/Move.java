package MultiThread082121;

import java.util.Random;

public class Move {
	private int x, y, speedx, speedy, size = 5;

	public Move() {
	}

	// 初始化位置
	public Move(int x, int y) {
		this.x = x;
		this.y = y;
		Random rand = new Random();
		this.speedx = rand.nextInt(5)+1;
		this.speedy = rand.nextInt(5)+1;
	}

	public void move() {
		x += speedx;
		y += speedy;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeedx() {
		return speedx;
	}

	public void setSpeedx(int speedx) {
		this.speedx = speedx;
	}

	public int getSpeedy() {
		return speedy;
	}

	public void setSpeedy(int speedy) {
		this.speedy = speedy;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
