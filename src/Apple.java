import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Apple {
	private int drawSize;
	private Point pos;
	
	public Apple(int size) {
		this.pos = new Point(150, 150);
		this.drawSize = size;
	}

	public int getPosX() {
		return pos.x;
	}	
	
	public int getPosY() {
		return pos.y;
	}	
	
	public void draw(Graphics canvas) {
		canvas.setColor(Color.RED);
		canvas.fillOval(getPosX(), getPosY(), drawSize, drawSize);
	}

	public void setPos(int x, int y) {
		pos = new Point(x, y);
	}
	
}
