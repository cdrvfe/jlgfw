import java.awt.Graphics2D;
import java.awt.Color;
import java.util.HashMap;

class Enemy extends GamePoolObject{
	private int WIDTH = 64;
	private double SPEED = 8;

	public void processActivate(HashMap<String, Object> params) {
		x = (double)(params.get("x"));
		y = (double)(params.get("y"));
	}

	public void move() {
		y += SPEED;
		if (y >= 600) inactivate();
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, WIDTH, WIDTH);
	}
}
