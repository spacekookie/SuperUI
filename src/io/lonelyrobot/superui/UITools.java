package io.lonelyrobot.superui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class UITools {
	private static Skin skin;

	public static void registerSkin(Skin skin) {
		UITools.skin = skin;
	}

	private static void checkSkin() {
		if (skin == null)
			System.err.println("No skin registered");
	}

	public static TextButton button(String text) {
		checkSkin();
		return new TextButton(text, skin);
	}

	public static TextButton button(String text, Runnable r) {
		checkSkin();

		TextButton b = new TextButton(text, skin);
		b.addListener(new ClickListener() {

			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				if (b.isDisabled())
					return;
				r.run();
			}
		});

		return b;
	}

	public static CheckBox checkbox(String text) {
		checkSkin();

		return new CheckBox(text, skin);
	}
}
