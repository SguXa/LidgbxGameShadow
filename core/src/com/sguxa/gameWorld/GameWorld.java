package com.sguxa.gameWorld;

import com.badlogic.gdx.Gdx;
import com.sguxa.GameObjects.Bird;
import java.awt.Rectangle;


/**
 * Created by r.gushin on 03.12.2014.
 */
public class GameWorld {

	private Bird bird;

	public GameWorld(int midPointY) {
		bird = new Bird(33, midPointY - 5, 17, 12);
	}

	public void update(float delta) {
		bird.update(delta);
	}

	public Bird getBird() {
		return bird;

	}
}
