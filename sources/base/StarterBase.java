import javax.swing.*;
import java.lang.reflect.Constructor;  
import java.lang.reflect.Method; 

class StarterBase {
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

	public static void main(String[] args) {
		StarterBase starter = new StarterBase(args[0]);
	}
}
