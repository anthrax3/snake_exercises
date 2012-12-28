import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class GameExercises extends GamePanel {	
	
	private Snake snake;
	private Apple apple;
	
	public GameExercises() {
		snake = new Snake(drawSize);
		apple = new Apple(drawSize);
	}

	// This method is called once a second to redraw the canvas,
	// so you can do things like animate the snake.
	public void redrawCanvas(Graphics canvas) {
		drawLabel(canvas);
		apple.draw(canvas);
		snake.draw(canvas);
	}

	// This method is called once a second, and it is a good place to
	// do things like check if the snake has collided into the wall
	// or the apple.
	public void onTimer() {
		if (isGameRunning) {
			checkApple();
			checkBoundsCollision();
			snake.move();
		}	
	}
	
	// This method is called whenever a keyboard button is pressed
	// within your game. The keyCode represents the key the actual key pushed.
	// You can check which keyCode using 'KeyEvent' constants.
	// i.e keyCode == KeyEvent.VK_G
	public void onKeyPress(int keyCode) {
		if ((keyCode == KeyEvent.VK_LEFT) && !(snake.getDirection() == "right")) {
			snake.setDirection("left");
		}
		else if ((keyCode == KeyEvent.VK_RIGHT) && !(snake.getDirection() == "left")) {
			snake.setDirection("right");
		}
		else if ((keyCode == KeyEvent.VK_UP) && !(snake.getDirection() == "down")) {
			snake.setDirection("up");
		}
		else if ((keyCode == KeyEvent.VK_DOWN) && !(snake.getDirection() == "up")) {
			snake.setDirection("down");
		} 
	}
	
	private void checkBoundsCollision() {
		// Check if the snake ran into itself
		if (snake.hasHitTail()) { 
			isGameRunning = false;
		}
		
		// Check if snake ran into the boundaries of the game board
		// Game is over if the snake head are outside board bounds
		if (snake.getHeadPosX() < 0 || snake.getHeadPosX() > getPanelWidth()) {
			isGameRunning = false;
		} else if (snake.getHeadPosY() < 0 || snake.getHeadPosY() > getPanelHeight()) {
			isGameRunning = false;
		}
	}

	private void checkApple() {
		// When snake head is directly on the apple tile,
		// apple is then consumed
		if ((snake.getHeadPosX() == apple.getPosX()) && 
				(snake.getHeadPosY() == apple.getPosY())) {
			snake.growTail();
			repositionApple();
		}		
	}

	private void repositionApple() {
		apple.setPos(randomCoordForPanel(getPanelWidth()), 
				randomCoordForPanel(getPanelHeight()));
	}

	public void drawLabel(Graphics canvas) {
		canvas.setColor(Color.BLUE);
		Font f = new Font("Helvetica Nueue", Font.BOLD, 24);
		canvas.setFont(f);
		canvas.drawString("Exercise 6", 50, 50);
	}

}
