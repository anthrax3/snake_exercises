import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class GameExercises extends GamePanel {
	// Implement the drawing here
	public void paintComponent(Graphics canvas) {	
		// Keep the apple we drew from exercise 1
		canvas.setColor(Color.RED);
	    canvas.fillOval(150, 150, 25, 25);
	    canvas.setColor(Color.BLUE);
	    Font f = new Font("Helvetica Nueue", Font.BOLD, 24);
		canvas.setFont(f);
	    canvas.drawString("Exercise 2", 50, 50);

	    // Simple graphic (draw the snake without loops)
	    // First, draw manually, repeating colors and width
	    /* 
	    canvas.setColor(Color.GREEN);
	    canvas.fillRect(300, 300, 25, 25);
	    canvas.fillRect(300, 326, 25, 25);
	    canvas.fillRect(300, 352, 25, 25);
	    */
	    
	    // Then, try to change the color and width of the snake
	    // Refactor code so that changing the color and width is easier
	    Color c = Color.GREEN;
	    int size = 25;
	    int xStart = 300;
	    int yStart = 300;
	    
	    /*
	    canvas.setColor(c);
	    canvas.fillRect(xStart, yStart, size, size);
	    canvas.fillRect(xStart, yStart + size + 1, size, size);
	    canvas.fillRect(xStart, yStart + (size * 2) + 2, size, size);
	    canvas.fillRect(xStart, yStart + (size * 3) + 3, size, size);
	    */
	    
	    // Add an array for snake positions (x and y)
	    int[] x = new int[] { xStart, xStart, xStart, xStart };
	    int[] y = new int[] { yStart, yStart + size + 1, 
	    		yStart + (size * 2) + 2, 
	    		yStart + (size * 3) + 3 };
	    
	    canvas.setColor(c);
	    canvas.fillRect(x[0], y[0], size, size);
	    canvas.fillRect(x[1], y[1], size, size);
	    canvas.fillRect(x[2], y[2], size, size);
	    canvas.fillRect(x[3], y[3], size, size);
	}
}
