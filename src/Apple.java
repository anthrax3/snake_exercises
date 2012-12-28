import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Apple {
	// This is the size of the apple to draw
	private int drawSize;
	// This is the coordinate position of the apple
	private Point pos;
	
	public Apple(int size) {
		this.pos = new Point(150, 150);
		this.drawSize = size;
	}
	
	// Returns the x coordinate position for the apple
	public int getPosX() {
		return pos.x;
	}	
	
	// Returns the y coordinate position for the apple
	public int getPosY() {
		return pos.y;
	}
	
	// Update the position for the apple given the x and y coordinates
	public void setPos(int x, int y) {
		pos = new Point(x, y);
	}
	
	// Given the canvas, draw the item on screen using coordinates
	public void draw(Graphics canvas) {
		canvas.setColor(Color.RED);
		canvas.fillOval(getPosX(), getPosY(), drawSize, drawSize);
	}
	
}
