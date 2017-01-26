package io.lonelyrobot.superui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import io.lonelyrobot.superui.Handle.UI_TYPE;

public class Item {
	private Actor actor;
	private UI_TYPE type;

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public UI_TYPE getType() {
		return type;
	}

	public void setType(UI_TYPE type) {
		this.type = type;
	}

	public Item(Actor a, Runnable r, UI_TYPE type) {
		this.actor = a;
		this.type = type;
	}
}