import java.awt.Graphics2D;
import java.awt.Color;

class DummyCore extends GameCore{
	private Color background_color = Color.BLACK;
	private Player player;

	public DummyCore() {
		player = new Player();
		player.activate(PANEL_WIDTH/2, PANEL_HEIGHT/2);
	}


	public void update() {
		player.move(kadapter);
	}

	public void draw(Graphics2D g) {
		g.setColor(background_color);
		g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

		player.draw(g);
	}
}
