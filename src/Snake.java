import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Arrays;

public class Snake {
	private int drawSize;
	private int length;
	private Point[] pos;
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
	
	public int getHeadPosX() {
		return pos[0].x;
	}
	
	public int getHeadPosY() {
		return pos[0].y;
	}
	
	public boolean hasHitTail() {
		for (int ind = length; ind > 0; ind--) {
			if ((pos[0].x == pos[ind].x) && (pos[0].y == pos[ind].y)) {
				return true;
			}
		}
		return false;
	}
	
	public void growTail() {
		length++;
		pos = Arrays.copyOf(pos, pos.length + 1);
		pos[pos.length - 1] = new Point();
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
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
	
	public void draw(Graphics canvas) {
		Color c = Color.GREEN;
		canvas.setColor(c);
		for (int ind = 0; ind < length; ind++) {
			canvas.fillRect(pos[ind].x, pos[ind].y, drawSize, drawSize);
		}
	}
}
