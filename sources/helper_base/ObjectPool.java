import java.util.HashMap;
import java.util.ArrayList;

class ObjectPool {
	private static HashMap<String, Class> classes = new HashMap<String, Class>();
	private static HashMap<String, ArrayList<GameObject>> instance_lists = new HashMap<String, ArrayList<GameObject>>();
	private static HashMap<Class, ArrayList<GameObject>> active_lists = new HashMap<Class, ArrayList<GameObject>>();

	public static GameObject getInstance(String class_name) {
		ArrayList<GameObject> instances = instance_lists.get(class_name);
		if (instances == null) addClass(class_name);

		for (int i = 0; i < instances.size(); i++) {
			GameObject instance = instances.get(i);
			if (instance.isActive() == false) return instance;
		}

		return addInstance(class_name);
	}
	 
	private static void addClass(String class_name) {
		Class object_class = null;
		try {
			object_class = Class.forName(class_name);
		} catch (Exception e) {
			System.out.println("クラス" + class_name + "が見つかりません。");
			e.printStackTrace();
		}
		classes.put(class_name, object_class);

		ArrayList<GameObject> list = new ArrayList<GameObject>();
		instance_lists.put(class_name, list);
	}

	private static GameObject addInstance(String class_name) {
		GameObject instance = null;
		try {
			Class object_class = Class.forName(class_name);
			instance = (GameObject)(object_class.newInstance());
		} catch (Exception e) {
			System.out.println("クラス" + class_name + "が見つかりません。");
			e.printStackTrace();
		}

		instance_lists.get(class_name).add(instance);
		return instance;
	}

	public static void addToActiveList(Class object_class, GameObject object) {
		getActiveList(object_class).add(object);
	}

	public static void removeFromActiveList(Class object_class, GameObject object) {
		getActiveList(object_class).add(object);
	}

	public static ArrayList<GameObject> getActiveList(Class object_class) {
		ArrayList<GameObject> actives = active_lists.get(object_class);
		if (actives == null) {
			actives = new ArrayList<GameObject>();
			active_lists.put(object_class, actives);
		}
		return actives;	
	}
}
