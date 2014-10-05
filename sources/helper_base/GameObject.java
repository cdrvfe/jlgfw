import java.awt.Graphics2D;
import java.util.HashMap;

abstract class GameObject {
	protected double x, y;
	protected double vx, vy;
	protected double width, height;
	 
	private boolean is_active;

	public void activate(HashMap<String, Object> params) {
		is_active = true;
		processActivate(params);
	}
	public void inactivate() {
		is_active = false;
		processInactivate();
	}

	public void processActivate(HashMap<String, Object> params) {}
	public void processInactivate() {}
	 
	public boolean isActive() { return is_active; }

	public abstract void move();
	public abstract void draw(Graphics2D g);
}
