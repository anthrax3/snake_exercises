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
	
	@Override
	protected void onKeyPress(int keyCode) {
		// TODO Auto-generated method stub
		
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
	
	public void drawSnake(Graphics canvas, int size, int[] x, int[] y) {
		Color c = Color.GREEN;
		canvas.setColor(c);
		for (int ind = 0; ind < x.length; ind++) {
	      canvas.fillRect(x[ind], y[ind], size, size);
		}
	}
	
	// Moves the coordinates for snake up
	public void moveUp(int[] x, int[] y) {
		for (int ind = 0; ind < x.length; ind++) {
			y[ind] = y[ind] - drawSize;
		}
	}
}
