import java.awt.Graphics;
import java.awt.Point;

public abstract class Item {
	protected int drawSize;
	protected Point pos;
	
	public Item(int size) {
		this.drawSize = size;
	}

	public int getPosX() {
		return pos.x;
	}	
	
	public int getPosY() {
		return pos.y;
	}	

	public void setPos(int x, int y) {
		pos = new Point(x, y);
	}
	
	public abstract void draw(Graphics canvas);
}
