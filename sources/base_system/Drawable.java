//GamePanelとGameCoreが描写を相互参照していたので切り出し

import java.awt.Graphics2D;

interface Drawable {
	public void draw(Graphics2D g);
}
