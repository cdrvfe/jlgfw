import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

class GamePanel extends JPanel {
	private Drawable core;

	public GamePanel(Drawable core) {
		this.core = core;
	}

	public void paintComponent(Graphics g) {
		core.draw((Graphics2D)g);
	}
}
