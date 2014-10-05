import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

class DummyCore extends GameCore{
	private Color background_color = Color.BLACK;
	private Player player;

	private int dbg_time = 0;

	public DummyCore() {
		player = new Player();
		player.activate(PANEL_WIDTH/2, PANEL_HEIGHT/2);
	}

	private void updateObjects(String class_name) {
		ArrayList<GameObject> list = ObjectPool.getActiveList(class_name);

		for (int i = 0; i < list.size(); i++) {
			GameObject obj = (GameObject)(list.get(i));
			obj.move();
		}
	}

	private void drawObjects(String class_name, Graphics2D g) {
		ArrayList<GameObject> list = ObjectPool.getActiveList(class_name);

		for (int i = 0; i < list.size(); i++) {
			GameObject obj = (GameObject)(list.get(i));
			obj.draw(g);
		}
	}

	public void update() {
		dbg_time ++;
		if (dbg_time % 20 == 0) activateEnemy(Math.random()*800, -40);

		player.move(kadapter);
		updateObjects("Enemy");
	}

	public void draw(Graphics2D g) {
		g.setColor(background_color);
		g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

		player.draw(g);
		drawObjects("Enemy", g);
	}

	private Enemy activateEnemy(double x, double y) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("x", x);
		params.put("y", y);
		GameObject enemy = ObjectPool.prepareInstance("Enemy");
		enemy.activate(params);
		return (Enemy)enemy;
	}
}
