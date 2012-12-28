import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Apple extends Item {
	public Apple(int drawSize) {
		super(drawSize);
		this.pos = new Point(150, 150);
	}
	
	public void draw(Graphics canvas) {
		canvas.setColor(Color.RED);
		canvas.fillOval(getPosX(), getPosY(), drawSize, drawSize);
	}
}