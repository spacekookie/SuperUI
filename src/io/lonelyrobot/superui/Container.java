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

	{
		elements = new HashMap<>();
	}

	public abstract void initialise(Stage parent);

	public void row() {
		self.row();
	}

	public void addToTable(UI_BASE field, float widthMul, float heightMul) {
		Actor a = elements.get(field).getActor();
		self.add(a).width(elementWidth * widthMul).height(elementHeight * heightMul);
	}

	public void addToTable(UI_BASE field) {
		this.addToTable(field, 1f, 1f);
	}
}