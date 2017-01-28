package io.lonelyrobot.superui;

import java.util.HashMap;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import io.lonelyrobot.superui.Handle.UI_BASE;

public abstract class Container {
	protected Table self;

	protected float width, height;
	protected float elementWidth, elementHeight;

	protected Handle parent;
	protected HashMap<UI_BASE, Item> elements;

	public Container(Handle parent) {
		this.parent = parent;
		elements = new HashMap<>();
	}

	public abstract void initialise(Stage parent);

	protected void store(UI_BASE field, Actor a) {
		this.store(field, a, null);
	}

	protected void store(UI_BASE field, Actor a, Runnable r) {
		if (a == null)
			return;

		elements.put(field, new Item(a, r));
	}

	public void row() {
		self.row();
	}

	public Actor getActor(UI_BASE field) {
		Item i = elements.get(field);
		if (i == null)
			return null;

		return i.getActor();
	}

	public void addToTable(UI_BASE field, float widthMul, float heightMul, int cols) {
		Item i = elements.get(field);
		if (i == null)
			return;

		final Actor a = i.getActor();
		if (a == null)
			return;

		/** Now we're sure we have all the objects */
		self.add(a).width(elementWidth * widthMul).height(elementHeight * heightMul).colspan(cols);
	}

	public void addFullWidth(UI_BASE field) {
		this.addToTable(field, 1f, 1f, 2);
	}

	public void addHalfWidth(UI_BASE field) {
		this.addToTable(field, 0.5f, 1f, 1);
	}
}