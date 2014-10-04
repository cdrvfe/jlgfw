import java.awt.event.KeyAdapter;

class GameCore {
	public static final int PANEL_WIDTH  = 800;
	public static final int PANEL_HEIGHT = 600;;

	protected GameKeyAdapter kadapter;

	public int getPanelWidth() {
		return PANEL_WIDTH;
	}

	public int getPanelHeight() {
		return PANEL_HEIGHT;
	}

	public KeyAdapter getKeyAdapter() {
		return kadapter;
	}
}
