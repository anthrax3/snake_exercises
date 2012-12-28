import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener {
	// Creates a timer which 'ticks' and will trigger
	// the actionPerformed method every X interval
	// This is how the game progresses, the snake moves in 
	// the specified direction every 'tick' of the timer.
	private Timer timer;

	public GamePanel() {
		timer = new Timer(150, this);
	}
	
	protected void startGame() {
		timer.start();
	}

	// Draws every time the component is painted
	// This contains the contents of the frame
	public void paintComponent(Graphics canvas) {	

	}

	// This fires for every 'tick' of the timer
	// which means every specified interval. When this fires,
	// we should move the game forward which means checking
	// conditions (apple hit or game over) and moving the snake.
	public void actionPerformed(ActionEvent e) {

	}

}
