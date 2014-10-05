import java.awt.Graphics2D;
import java.awt.Color;

class Player {
	private double x,y;
	private int WIDTH = 64;
	private double SPEED = 8;

	public void activate(int x, int y) {
		this.x = x - WIDTH / 2;
		this.y = y - WIDTH / 2;
	}

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
