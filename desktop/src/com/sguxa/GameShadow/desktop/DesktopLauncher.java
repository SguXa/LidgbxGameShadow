package com.sguxa.GameShadow.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sguxa.GameShadow.GameShadow;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "ZombieBird";
		cfg.disableAudio  = false;
		cfg.width = 272;
		cfg.height = 408;
		
		new LwjglApplication(new GameShadow(), cfg);
	}
}


