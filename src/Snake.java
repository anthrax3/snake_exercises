import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Arrays;

public class Snake {
	// This is the size of the apple to draw
	private int drawSize;
	// The number of squares that make up this snake
	private int length;
	// The list of coordinates of the snake's body
	private Point[] pos;
	// The direction of the snake (left, right, up, down)
	private String direction;

	public Snake(int size) {
		this.direction = "up";
		this.length = 3;
		this.pos = new Point[this.length+1];
		this.drawSize = size;
		for (int ind = 0; ind <= length; ind++) {
			Point pind = pos[ind] = new Point();
			pind.x = 300;
			pind.y = 300 + (ind * drawSize);
		}
	}

	// Returns the x coordinate position of the snake's head
	public int getHeadPosX() {
		return pos[0].x;
	}

	// Returns the y coordinate position of the snake's head
	public int getHeadPosY() {
		return pos[0].y;
	}

	// Increases the length of the snake's tail by 1
	// Used to make the snake longer once an apple is eaten
	// Needs to increment length, and instantiate a new array of a larger size
	public void growTail() {
		length++;
		pos = Arrays.copyOf(pos, pos.length + 1);
		pos[pos.length - 1] = new Point();
	}

	// Returns the direction the snake is headed
	// Direction is up, down, left or right
	public String getDirection() {
		return direction;
	}

	// Updates the direction the snake is headed
	// Accepts up, down, left or right
	public void setDirection(String direction) {
		this.direction = direction;
	}

	// Returns true if the snake's head has hit the body
	// This is a game over condition when the head runs into any part of the body
	// We need to check for a collision
	public boolean hasHitTail() {
		for (int ind = length; ind > 0; ind--) {
			if ((pos[0].x == pos[ind].x) && (pos[0].y == pos[ind].y)) {
				return true;
			}
		}
		return false;
	}

	// Moves the snake in the direction he is moving.
	// Needs to move the tail in the direction and adjust the head.
	public void move() {
		// First since a snake slides across the tiles,
		// move each tile (except the head) so that every tile is now equal
		// to the previous tile (to move all tiles).
		for (int ind = length; ind > 0; ind--) {
			pos[ind].x = pos[ind - 1].x;
			pos[ind].y = pos[ind - 1].y;
		}

		// Based on the current direction, we need to
		// move the head tile towards the next tile in that direction...
		if (getDirection() == "left") {
			pos[0].x -= drawSize;
		} else if (getDirection() == "right") {
			pos[0].x += drawSize;
		} else if (getDirection() == "up") {
			pos[0].y -= drawSize;
		} else if (getDirection() == "down") {
			pos[0].y += drawSize;
		}
	}

	// Given the canvas, draw the snake on screen using known coordinates
	public void draw(Graphics canvas) {
		Color c = Color.GREEN;
		canvas.setColor(c);
		for (int ind = 0; ind < length; ind++) {
			canvas.fillRect(pos[ind].x, pos[ind].y, drawSize, drawSize);
		}
	}
}
