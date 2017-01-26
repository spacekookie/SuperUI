package io.lonelyrobot.superui;

import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

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

    public static CheckBox checkbox(String text) {
        checkSkin();

        return new CheckBox(text, skin);
    }
}
