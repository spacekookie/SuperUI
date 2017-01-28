package io.lonelyrobot.superui;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class Item {
	private Actor actor;
	private Runnable callback;

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Item(Actor actor, Runnable callback) {
		this.actor = actor;
		this.callback = callback;
	}

	public void setCallback(Runnable callback) {
		this.callback = callback;
	}

	public void runCallback() {
		if (callback != null)
			callback.run();
	}
}