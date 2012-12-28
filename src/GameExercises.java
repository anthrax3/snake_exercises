import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class GameExercises extends FirstGamePanel {	
	
	// This method is called once a second to redraw the canvas,
	// so you can do things like animate the snake.
	public void redrawCanvas(Graphics canvas) {
		drawLabel(canvas);
		drawApple(canvas);
	    drawSnake(canvas, drawSize, x, y);
	}
	
	// This method is called once a second, and it is a good place to
	// do things like check if the snake has collided into the wall
	// or the apple.
	public void onTimer() {
		moveUp(x, y);
	}
	
	// This method is called whenever a keyboard button is pressed
	// within your game. The keyCode represents the key the actual key pushed.
	// You can check which keyCode using 'KeyEvent' constants.
	// i.e keyCode == KeyEvent.VK_G
	protected void onKeyPress(int keyCode) {
		
	}
	
	public void drawLabel(Graphics canvas) {
		canvas.setColor(Color.BLUE);
	    Font f = new Font("Helvetica Nueue", Font.BOLD, 24);
		canvas.setFont(f);
	    canvas.drawString("Exercise 3", 50, 50);
	}
	
	public void drawApple(Graphics canvas) {
		canvas.setColor(Color.RED);
	    canvas.fillOval(150, 150, 25, 25);
	}
	
	public void drawSnake(Graphics canvas, int drawSize, int[] x, int[] y) {
		Color c = Color.GREEN;
		canvas.setColor(c);
	    canvas.fillRect(x[0], y[0], drawSize, drawSize);
	    canvas.fillRect(x[1], y[1], drawSize, drawSize);
	    canvas.fillRect(x[2], y[2], drawSize, drawSize);
	    canvas.fillRect(x[3], y[3], drawSize, drawSize);
	}
	
	// Moves the coordinates for snake up
	public void moveUp(int[] x, int[] y) {
		y[3] = y[3] - drawSize;
		y[2] = y[2] - drawSize;
		y[1] = y[1] - drawSize;
		y[0] = y[0] - drawSize;
	}

}
