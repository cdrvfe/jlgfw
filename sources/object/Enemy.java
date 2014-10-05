import java.awt.Graphics2D;
import java.awt.Color;
import java.util.HashMap;

class Enemy extends GameObject{
	private int WIDTH = 64;
	private double SPEED = 8;

	public void activate(HashMap<String, Object> params) {
		activate((int)params.get("x"), (int)params.get("y"));
	}
	public void activate(int x, int y) {
		is_active = true;
	
		this.x = x - WIDTH / 2;
		this.y = y - WIDTH / 2;
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
