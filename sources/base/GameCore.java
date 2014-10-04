import java.awt.event.KeyAdapter;
import javax.swing.JPanel;
import javax.swing.JFrame;

class GameCore {
	public static final int PANEL_WIDTH  = 800;
	public static final int PANEL_HEIGHT = 600;;

	protected GameKeyAdapter kadapter;
	protected JPanel draw_panel;

	public void initFrame(JFrame frame) {
		frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
		frame.addKeyListener(kadapter);
		frame.getContentPane().add(draw_panel);
		frame.setVisible(true);
	}

	public int getPanelWidth() {
		return PANEL_WIDTH;
	}

	public int getPanelHeight() {
		return PANEL_HEIGHT;
	}

	public KeyAdapter getKeyAdapter() {
		return kadapter;
	}

	public JPanel getDrawPanel() {
		return draw_panel;
	}
}
