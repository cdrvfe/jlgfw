import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

class GameKeyAdapter extends KeyAdapter {
	//文字列とキーコードの対応
	private static HashMap<String, Integer> CODES; 

	//キーコードの押下判定
	private boolean[] isPressed;

	public GameKeyAdapter() {
		isPressed = new boolean[128];
		for (int i = 0; i<128; i++) isPressed[i] = false;

		initCodes();
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		isPressed[code] = true;
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		isPressed[code] = false;
	}

	public boolean isPressed(String key_text) {
		int code = CODES.get(key_text);
		return isPressed[code];
	}

	public boolean isPressed(int code) {
		return isPressed[code];
	}

	private void initCodes(){
		CODES = new HashMap<String, Integer>();

		//a-z
		for (int c = (int)'a'; c <= (int)'z'; c++) {
			CODES.put(String.valueOf((char)c), c);
		}

		//allow
		CODES.put("LEFT",  KeyEvent.VK_LEFT);
		CODES.put("UP",    KeyEvent.VK_UP);
		CODES.put("RIGHT", KeyEvent.VK_RIGHT);
		CODES.put("DOWN",  KeyEvent.VK_DOWN);

		//SHIFT,SPACE
		CODES.put("SHIFT", KeyEvent.VK_SHIFT);
		CODES.put("SPACE", KeyEvent.VK_SPACE);
	}
}
