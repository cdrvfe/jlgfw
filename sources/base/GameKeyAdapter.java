import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap; 

class GameKeyAdapter extends KeyAdapter {
	private HashMap<String, Boolean> isPressed;

	public GameKeyAdapter() {
		isPressed = new HashMap<String, Boolean>();
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		isPressed.put(KeyEvent.getKeyText(code), true);
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		isPressed.put(KeyEvent.getKeyText(code), false);
	}

	public boolean isPressed(String key_text) {
		Boolean result = isPressed.get(key_text);
		if (result == null) isPressed.put(key_text, false);
		return result;
	}
}
