import java.awt.event.KeyAdapter;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JFrame;

abstract class GameCore implements Drawable{
	public static final int PANEL_WIDTH  = 800;
	public static final int PANEL_HEIGHT = 600;;

	protected GameKeyAdapter kadapter;
	protected JPanel draw_panel;

	protected void init() {
	}

	public void initFrame(JFrame frame) {
		frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
		frame.setVisible(true);

		kadapter = new GameKeyAdapter();
		frame.addKeyListener(kadapter);

		draw_panel = new GamePanel(this);
		draw_panel.setSize(PANEL_WIDTH, PANEL_HEIGHT);
		frame.getContentPane().add(draw_panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public int getPanelWidth() {
		return PANEL_WIDTH;
	}

	public int getPanelHeight() {
		return PANEL_HEIGHT;
	}

	public abstract void update();
}
