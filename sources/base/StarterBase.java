import java.lang.reflect.Constructor;  
import java.lang.reflect.Method;
import javax.swing.JFrame;
import javax.swing.JPanel;

class StarterBase implements Runnable{
    private JFrame frame;
	private GameCore core;

	private StarterBase(String core_name) {
		try {
			Class coreclass = Class.forName(core_name);
            Object coreinstance = coreclass.newInstance();
			core = (GameCore)coreinstance;
		} catch(Exception e) {
			System.out.println("コアクラス" + core_name + "が見つかりません。");
			e.printStackTrace();
			System.exit(0);
		}

		frame = new JFrame();
		core.initFrame(frame);
	}

	private void update() {
		core.update();
		frame.repaint();
	}

	public void startLoop() {
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {
		long error = 0;
		int fps = 60;
		long idealSleep = (1000 << 16) / fps;
		long oldTime;
		long newTime = System.currentTimeMillis() << 16;
		while (true) {
			oldTime = newTime;
			update(); // メイン処理
			newTime = System.currentTimeMillis() << 16;
			long sleepTime = idealSleep - (newTime - oldTime) - error; // 休止できる時間
			if (sleepTime < 0x20000) sleepTime = 0x20000; // 最低でも2msは休止
			oldTime = newTime;
			try {
				Thread.sleep(sleepTime >> 16); // 休止
			} catch(Exception e) {
				System.out.println("スレッドエラー");
				e.printStackTrace();
			}
			newTime = System.currentTimeMillis() << 16;
			error = newTime - oldTime - sleepTime; // 休止時間の誤差
		}
	}

	public static void main(String[] args) {
		StarterBase starter = new StarterBase(args[0]);
		starter.startLoop();
	}
}
