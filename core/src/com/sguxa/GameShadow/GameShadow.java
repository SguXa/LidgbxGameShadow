package com.sguxa.GameShadow;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sguxa.Screen.GameScreen;
import com.sguxa.zbhelpers.AssetLoader;


public class GameShadow extends Game {

        @Override
        public void create() {
            Gdx.app.log("GameShadow","create");
            AssetLoader.load();
            setScreen(new GameScreen());
        }

        public void dispose(){
            super.dispose();
            AssetLoader.dispose();
        }


    }
