import java.util.HashMap;

abstract class GamePoolObject extends GameObject {
	public void activate(HashMap<String, Object> params) {
		super.activate(params);
		ObjectPool.addToActiveList(getClass(), this);
	}

	public void inactivate() {
		super.inactivate();
		ObjectPool.removeFromActiveList(getClass(), this);
	}
}
