class DummyCore extends GameCore{

	public DummyCore() {
		kadapter = new GameKeyAdapter();
	}

	public int getPanelWidth() {
		return PANEL_WIDTH;	
	}

	public int getPanelHeight() {
		return PANEL_HEIGHT;
	}
}
