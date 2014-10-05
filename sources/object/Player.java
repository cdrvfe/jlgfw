import java.awt.Graphics2D;
import java.awt.Color;
import java.util.HashMap;

class Player extends GameObject{
	private int WIDTH = 64;
	private double SPEED = 8;

	public void activate(HashMap<String, Object> params) {
		activate((int)params.get("x"), (int)params.get("y"));
	}
	public void activate(int x, int y) {
		super.activate(null);
	
		this.x = x - WIDTH / 2;
		this.y = y - WIDTH / 2;
	}

	public void move(){}
	public void move(GameKeyAdapter kadapter) {
		if (kadapter.isPressed("LEFT" )) x -= SPEED;
		if (kadapter.isPressed("UP"   )) y -= SPEED;
		if (kadapter.isPressed("RIGHT")) x += SPEED;
		if (kadapter.isPressed("DOWN" )) y += SPEED;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, WIDTH, WIDTH);
	}
}
