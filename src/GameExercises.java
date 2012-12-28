import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class GameExercises extends FirstGamePanel {
	// Implement the drawing here
	public void redrawCanvas(Graphics canvas) {	
		// We want to draw a red circle (apple), a green square (snake head)
		// and blue text which reads "Exercise 1"
		canvas.setColor(Color.RED);
	    canvas.fillOval(150, 150, 100, 100);
	    canvas.setColor(Color.GREEN);
	    canvas.fillRect(400, 350, 100, 100);
	    canvas.setColor(Color.BLUE);
	    canvas.drawString("Exercise 1", 30, 50);
	}
	
	// This method is called once a second, and it is a good place to
	// do things like check if the snake has collided into the wall
	// or the apple.
	public void onTimer() {

	}

	// This method is called whenever a keyboard button is pressed
	// within your game. The keyCode represents the key the actual key pushed.
	// You can check which keyCode using 'KeyEvent' constants.
	// i.e keyCode == KeyEvent.VK_G
	protected void onKeyPress(int keyCode) {

	}
}
