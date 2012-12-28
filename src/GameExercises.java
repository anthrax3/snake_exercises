import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class GameExercises extends GamePanel {	

	// This method is called once a second to redraw the canvas,
	// so you can do things like animate the snake.
	public void redrawCanvas(Graphics canvas) {
		drawLabel(canvas);
		drawApple(canvas);
		drawSnake(canvas, size, x, y);
	}

	// This method is called once a second, and it is a good place to
	// do things like check if the snake has collided into the wall
	// or the apple.
	public void onTimer() {
		if (isGameRunning) {
			checkApple();
			checkBoundsCollision();
			moveSnake(x, y);
		}	
	}
	
	// This method is called whenever a keyboard button is pressed
	// within your game. The keyCode represents the key the actual key pushed.
	// You can check which keyCode using 'KeyEvent' constants.
	// i.e keyCode == KeyEvent.VK_G
	public void onKeyPress(int keyCode) {
		if ((keyCode == KeyEvent.VK_LEFT) && !(direction == "right")) {
			direction = "left";
		}
		else if ((keyCode == KeyEvent.VK_RIGHT) && !(direction == "left")) {
			direction = "right";
		}
		else if ((keyCode == KeyEvent.VK_UP) && !(direction == "down")) {
			direction = "up";
		}
		else if ((keyCode == KeyEvent.VK_DOWN) && !(direction == "up")) {
			direction = "down";
		} 
	}
	
	// Moves the coordinates for snake up
	public void moveSnake(int[] x, int[] y) {
		// First since a snake slides across the tiles,
		// move each tile (except the head) so that every tile is now equal
		// to the previous tile (to move all tiles).
		for (int ind = snakeLength; ind > 0; ind--) {
			x[ind] = x[ind - 1];
			y[ind] = y[ind - 1];
		}

		// Based on the current direction, we need to
		// move the head tile towards the next tile in that direction...
		if (direction == "left") {
			x[0] -= size;
		} else if (direction == "right") {
			x[0] += size;
		} else if (direction == "up") {
			y[0] -= size;
		} else if (direction == "down") {
			y[0] += size;
		}
	}
	
	private void checkBoundsCollision() {
		// Check if the snake ran into itself
		for (int ind = snakeLength; ind > 0; ind--) {
			if ((x[0] == x[ind]) && (y[0] == y[ind])) {
				isGameRunning = false;
			}
		}
		
		// Check if snake ran into the boundaries of the game board
		// Game is over if the snake head are outside board bounds
		if (x[0] < 0 || x[0] > getPanelWidth()) {
			isGameRunning = false;
		} else if (y[0] < 0 || y[0] > getPanelHeight()) {
			isGameRunning = false;
		}
	}

	private void checkApple() {
		// When snake head is directly on the apple tile,
		// apple is then consumed
		if ((x[0] == appleX) && (y[0] == appleY)) {
			snakeLength++;
			x = createArrayFromOldArrayWithSize(x, x.length + 1);
			y = createArrayFromOldArrayWithSize(y, y.length + 1);
			repositionApple();
		}		
	}

	private void repositionApple() {
		appleX = randomCoordForPanel(getPanelWidth());
		appleY = randomCoordForPanel(getPanelHeight());
	}

	public void drawLabel(Graphics canvas) {
		canvas.setColor(Color.BLUE);
		Font f = new Font("Helvetica Nueue", Font.BOLD, 24);
		canvas.setFont(f);
		canvas.drawString("Exercise 5", 50, 50);
	}

	public void drawApple(Graphics canvas) {
		canvas.setColor(Color.RED);
		canvas.fillOval(appleX, appleY, 25, 25);
	}

	public void drawSnake(Graphics canvas, int size, int[] x, int[] y) {
		Color c = Color.GREEN;
		canvas.setColor(c);
		for (int ind = 0; ind < x.length; ind++) {
			canvas.fillRect(x[ind], y[ind], size, size);
		}
	}

}
