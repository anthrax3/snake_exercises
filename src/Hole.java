import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Hole extends Item {
	public Hole(int drawSize) {
		super(drawSize);
		this.pos = new Point(400, 400);
	}
	
	public void draw(Graphics canvas) {
		canvas.setColor(Color.BLACK);
		canvas.fillOval(getPosX(), getPosY(), drawSize, drawSize);
	}
}