import javax.swing.JPanel;

class DummyCore extends GameCore{

	public DummyCore() {
		kadapter = new GameKeyAdapter();
		draw_panel = new JPanel();
		draw_panel.setSize(PANEL_WIDTH, PANEL_HEIGHT);
	}

	public int getPanelWidth() {
		return PANEL_WIDTH;	
	}

	public int getPanelHeight() {
		return PANEL_HEIGHT;
	}
}
