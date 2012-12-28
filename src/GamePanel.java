import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public abstract class GamePanel extends JPanel implements ActionListener {
	// Sets the width and height of the canvas to 300x300
	private final int WIDTH = 600;
	private final int HEIGHT = 600;
	
	int[] x;
	int[] y;
	int size = 25;
	int xStart = 300;
	int yStart = 300;
	String direction;
	int snakeLength;
	int appleX;
	int appleY;
	boolean isGameRunning;

	// Creates a timer which 'ticks' and will trigger
	// the actionPerformed method every X interval
	// This is how the game progresses, the snake moves in 
	// the specified direction every 'tick' of the timer.
	private Timer timer;

	public GamePanel() {
		setFocusable(true);
		snakeLength = 3;
		direction = "up";
		x = new int[] { xStart, xStart, xStart, xStart };
		y = new int[] { yStart, yStart + size, 
				yStart + (size * 2), 
				yStart + (size * 3) };
		appleX = 150;
		appleY = 150;
		
		addKeyListener(new GameKeyListener());
		timer = new Timer(150, this);
		startGame();
	}

	protected void startGame() {
		isGameRunning = true;
		timer.start();
	}

	protected void pauseGame() {
		timer.stop();
	}
	
	protected int getPanelHeight() {
		return HEIGHT;
	}
	
	protected int getPanelWidth() {
		return WIDTH;
	}
	
	protected int randomCoordForPanel(int max) {
		int multiplier = max / size;
		int randomCoordinate = (int) (Math.random() * multiplier);
		return randomCoordinate * size;
	}
	
	protected boolean hasObjectCollision(int x1, int y1, int x2, int y2) {
		Rectangle rx1 = new Rectangle(x1, y1, size, size);
	    Rectangle rx2 = new Rectangle(x2, y2, size, size);
	    return rx1.intersects(rx2);
	}

	// Draws every time the component is painted
	// This contains the contents of the frame
	public void paintComponent(Graphics canvas) {	
		super.paintComponent(canvas);
		this.redrawCanvas(canvas);
		Toolkit.getDefaultToolkit().sync();
		canvas.dispose();
	}

	// This fires for every 'tick' of the timer
	// which means every specified interval. When this fires,
	// we should move the game forward which means checking
	// conditions (apple hit or game over) and moving the snake.
	public void actionPerformed(ActionEvent e) {
		onTimer();
		repaint();
	}

	protected abstract void onTimer();
	protected abstract void redrawCanvas(Graphics canvas);
	protected abstract void onKeyPress(int keyCode);

	// LISTENER
	private class GameKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			onKeyPress(e.getKeyCode());
		}
	}
	
	// Arrays
	// createArrayFromOldArrayWithSize(oldArray, 10);
	int[] createArrayFromOldArrayWithSize(int[] org, int size) {
	    int[] result = Arrays.copyOf(org, size);
	    return result;
	}
}
