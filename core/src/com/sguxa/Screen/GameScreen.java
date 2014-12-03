package com.sguxa.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.sguxa.gameWorld.GameRenderer;
import com.sguxa.gameWorld.GameWorld;

/**
 * Created by r.gushin on 03.12.2014.
 */
public class GameScreen implements Screen {
    private GameWorld world;
    private GameRenderer renderer;



    public GameScreen(){
        Gdx.app.log("GameScreen!!","Attached");
        world=new GameWorld();
        renderer = new GameRenderer(world);
    }

    @Override
    public void render(float delta) {
        // Мы передаем delta в update метод, для того, чтобы мы могли сделать фреймо-зависимые вычисления
        world.update(delta);
        renderer.render();

    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen!!","resize");
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen!!","show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen!!","hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen!!","pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen!!","resume called");
    }

    @Override
    public void dispose() {

    }
}
