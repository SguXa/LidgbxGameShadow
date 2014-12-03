package com.sguxa.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.sguxa.gameWorld.GameRenderer;
import com.sguxa.gameWorld.GameWorld;
import com.sguxa.zbhelpers.InputHandler;

/**
 * Created by r.gushin on 03.12.2014.
 */
public class GameScreen implements Screen {
    private GameWorld world;
    private GameRenderer renderer;



    public GameScreen(){
        float screenWidth=Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();	
        float gameWidth=136;
        float gameHeight=screenHeight/(screenWidth/gameWidth);
        
        int mindPointY=(int)(gameHeight/2);
        
        world=new GameWorld(mindPointY);
        renderer=new GameRenderer(world);
        
        Gdx.input.setInputProcessor(new InputHandler(world.getBird()));
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
