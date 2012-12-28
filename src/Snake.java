import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Snake {
	private int drawSize;
	private int length;
	private ArrayList<Point> pos;
	private String direction;
	
	public Snake(int size) {
		this.direction = "up";
		this.length = 3;
		this.drawSize = size;
		this.pos = new ArrayList<Point>();
		for (int ind = 0; ind <= length; ind++) {
			this.pos.add(new Point());
			Point pind = pos.get(ind);
			pind.x = 300;
			pind.y = 300 + (ind * drawSize);
		}
	}
	
	public int getHeadPosX() {
		return pos.get(0).x;
	}
	
	public int getHeadPosY() {
		return pos.get(0).y;
	}
	
	public boolean hasHitTail() {
		for (int ind = length; ind > 0; ind--) {
			if ((pos.get(0).x == pos.get(ind).x) && (pos.get(0).y == pos.get(ind).y)) {
				return true;
			}
		}
		return false;
	}
	
	public void growTail() {
		length++;
		pos.add(new Point());
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
			pos.get(ind).x = pos.get(ind - 1).x;
			pos.get(ind).y = pos.get(ind - 1).y;
		}

		// Based on the current direction, we need to
		// move the head tile towards the next tile in that direction...
		if (getDirection() == "left") {
			pos.get(0).x -= drawSize;
		} else if (getDirection() == "right") {
			pos.get(0).x += drawSize;
		} else if (getDirection() == "up") {
			pos.get(0).y -= drawSize;
		} else if (getDirection() == "down") {
			pos.get(0).y += drawSize;
		}
	}
	
	public void draw(Graphics canvas) {
		Color c = Color.GREEN;
		canvas.setColor(c);
		for (int ind = 0; ind < length; ind++) {
			canvas.fillRect(pos.get(ind).x, pos.get(ind).y, drawSize, drawSize);
		}
	}
}
