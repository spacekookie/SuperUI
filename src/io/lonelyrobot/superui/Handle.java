package io.lonelyrobot.superui;

import java.util.HashMap;

import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class Handle {

	public static enum UI_TYPE {
		TEXT_BUTTON,
	}

	public static interface UI_BASE {
	}

	private HashMap<Class<?>, Object> units;
	protected Stage parent;

	public Stage getParent() {
		return this.parent;
	}

	{
		units = new HashMap<>();
	}

	/**
	 * A Handle can overwrite this function if you don't want to use the default
	 * variadic parameter parsing.
	 * 
	 * @param parent
	 * @param variadic
	 */
	public void initialise(Stage parent, Object... variadic) {
		this.parent = parent;

		int length = variadic.length;
		for (int i = 0; i < length; i++) {
			Object o = variadic[i];

			/** Register the class we get */
			register(o.getClass(), o);
		}
	}

	public void register(Class<?> clazz, Object unit) {
		units.put(clazz, unit);
	}

	public Object getContext(Class<?> clazz) {
		return units.get(clazz);
	}

	public void unregister(Class<?> clazz) {
		units.remove(clazz);
	}

}
