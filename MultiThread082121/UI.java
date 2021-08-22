package MultiThread082121;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UI extends JFrame {
	private Graphics frameGraphics;
	StarThread starThread;
	BufferThread bufferThread;

	public void init() {
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		JButton startButton = new JButton("start");
		JButton addButton = new JButton("add frequency");

		// set the background color
		this.getContentPane().setBackground(Color.BLACK);

		this.add(startButton);
		this.add(addButton);
		this.setVisible(true);
		frameGraphics = this.getGraphics();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// paint stars
		starThread = new StarThread(this, frameGraphics);
		starThread.start();

		// start the buffer thread
		bufferThread = new BufferThread(this, frameGraphics);
		bufferThread.start();

		ButtonListener buttonListener = new ButtonListener(frameGraphics, this, starThread);
		startButton.addActionListener(buttonListener);
		addButton.addActionListener(buttonListener);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		try {
			g.drawImage(starThread.getBufferedImage(), 0, 80, this.getWidth(), this.getHeight() - 80, null);

		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UI myUI = new UI();
		myUI.init();
	}

}
