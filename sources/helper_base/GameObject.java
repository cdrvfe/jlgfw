import java.awt.Graphics2D;
import java.util.HashMap;

abstract class GameObject {
	protected double x, y;
	protected double vx, vy;
	protected double width, height;
	protected boolean is_active;

	public void activate(HashMap<String, Object> params) {
		is_active = true;
	}
	public void inactivate() {
		is_active = false;
	}
	 
	public boolean isActive() { return is_active; }

	public abstract void move();
	public abstract void draw(Graphics2D g);
}
