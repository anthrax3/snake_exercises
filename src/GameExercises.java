import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class GameExercises extends GamePanel {
	// Implement the drawing here
	public void paintComponent(Graphics canvas) {	
		// We want to draw a red circle (apple), a green square (snake head)
		// and blue text which reads "Exercise 1"
		canvas.setColor(Color.RED);
	    canvas.fillOval(150, 150, 100, 100);
	    canvas.setColor(Color.GREEN);
	    canvas.fillRect(400, 350, 100, 100);
	    canvas.setColor(Color.BLUE);
	    canvas.drawString("Exercise 1", 30, 50);
	}
}
