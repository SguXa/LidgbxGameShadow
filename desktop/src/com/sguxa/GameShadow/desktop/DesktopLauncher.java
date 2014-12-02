package com.sguxa.GameShadow.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sguxa.GameShadow.GameShadow;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title="GameShadol";
		config.width=480;
		config.height=320;
		new LwjglApplication(new GameShadow(), config);
	}
}


