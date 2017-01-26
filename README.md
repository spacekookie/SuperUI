# SuperUI

A powerful UI toolkit for LibGDX, allowing you to write sleek, structured and modular UI code for your games in Java.

### Installation

This repo provides a gradle project that you can either build once and include as a `.jar` in your project or add as a subproject to your build/ test tree.

### Usage

SuperUI structures UI scenes into three elements:

 - Handle (Top level structure - wraps around a `Stage`)
 - Container (Organisational structure - wraps around `Table`)
 - Item (Represents an `Actor` with metadata)
 
By extending these abstract base classes you can write very efficient UI code that is well structured and allows you to deal with window state in a sane manner while also being able to divide your UI logic into different files. The initialise function takes a list of variadic parameters that you can use to provide all kinds of window state to the UI handle. This way you need to pass your context ONCE, not for every subsystem.

```java
class MyUIHandle extends Handle {

	/** Define all UI elements as labels of this handle */
	public static enum UI_LOBBY implements UI_BASE {
		BUTTON1, BUTTON2
	}
	
	/** Your Container implementations */
	public ListHandle list;
	public TreeHandle tree;

	@Override
	public void initialise(Stage parent, Object... objects) {
		super.initialise(parent, objects);

		/** Initialise all submodule you need */
		list = new ListHandle(this);
		list.initialise(parent);

		tree = new TreeHandle(this);
		tree.initialise(parent);
	}

```

The next thing you need to provide is a `Container` implementation. You should keep all your UI setup code in the `initialise(Stage parent)` function as that is called once after creation of the Container. UI initialisation follows the same principles as Scene2D.ui however with some modifications. As `Actor` classes are wrapped into `Item`'s for metadata matching and management the creation process is a little more...complex.

```java

	@Override
	public void initialise(Stage parent) {

		/** The same height for all elements */
		super.elementWidth = (Gdx.graphics.getWidth() / 4) - 5;
		super.elementHeight = 75f;

		self = new Table();
		self.setFillParent(true);
		self.right().bottom();

		/** Register an Actor to a label (we registered previously) */
		store(UI_LOBBY.DW_LOBBY_ADD_PLAYER, UITools.button(" Add Player "));

		/** You can provide trigger callbacks via Lambdas in Java 8+ */
		store(UI_LOBBY.DW_LOBBY_LAUNCH, UITools.button(" Launch Game "), () -> {
			// ...
		});
		
		/** Use utility functions to manage your layout easily */
		addToTable(UI_LOBBY.DW_LOBBY_ADD_PLAYER);
		addToTable(UI_LOBBY.DW_LOBBY_LAUNCH);
		row();

		parent.addActor(self);
```

The standard way to add something to table is to use the registered `super.elementWidth` and `super.elementHeight` but there are different functions where you can provide your own sizes. Generally layout structure is very close to Scene2D.ui while wrapping some code around it for easier handling.

### Disclaimer

This library isn't done yet. It was created from the need for a nice way to handle UI and has yet to be tested in larger scale applications. But I think that with this structure it should be possible to make some nice UI code that easily managable. If you have feedback about this project, don't hesitate to contact me.

The code base and API is still changing while being moved from the game source trunk to it's own project. This library is (as LibGDX) licensed under the Apache-2 Free Software license!


> Author: Katharina 'spacekookie' @ Lonely Robot
