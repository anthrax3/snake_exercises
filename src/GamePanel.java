import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public abstract class GamePanel extends JPanel implements ActionListener {
	int[] x;
	int[] y;
	int size = 25;
	int xStart = 300;
    int yStart = 300;
	
	// Creates a timer which 'ticks' and will trigger
	// the actionPerformed method every X interval
	// This is how the game progresses, the snake moves in 
	// the specified direction every 'tick' of the timer.
	private Timer timer;

	public GamePanel() {
	    x = new int[] { xStart, xStart, xStart, xStart };
	    y = new int[] { yStart, yStart + size + 1, 
	    		yStart + (size * 2) + 2, 
	    		yStart + (size * 3) + 3 };
		timer = new Timer(150, this);
		startGame();
	}
	
	protected void startGame() {
		timer.start();
	}
	
	protected void pauseGame() {
		timer.stop();
	}

	// Draws every time the component is painted
	// This contains the contents of the frame
	public void paintComponent(Graphics canvas) {	
		super.paintComponent(canvas);
		
		this.redrawCanvas(canvas);
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
}
