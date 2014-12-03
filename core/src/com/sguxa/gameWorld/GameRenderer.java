package com.sguxa.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.Rectangle;

/**
 * Created by r.gushin on 03.12.2014.
 */
public class GameRenderer {

    private GameWorld myWorld;
    //добавим камеру
    private OrthographicCamera cam;
    // будет рисовать формы и линии
    private ShapeRenderer shapeRenderer;


    public GameRenderer(GameWorld world){
        myWorld=world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true,136,204);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }
    public void render(){
        Gdx.app.log("GameRenderer","render");

        //Рисуем Фон(цвет черный)
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Рисуем Квадрат
        // Говорим shapeRenderer начинать отрисовывать формы
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //Указывает цвет квадрата, не прозрачный
        shapeRenderer.setColor(87 /255.0f,109 /255.0f, 120/255.0f,1);
        // Отрисовываем квадрат из myWorld (Используем ShapeType.Filled)
        shapeRenderer.rect(myWorld.getRet().x,myWorld.getRet().y,myWorld.getRet().width,myWorld.getRet().height);
        // говорим shapeRenderer прекратить отрисовку
        // Мы ДОЛЖНЫ каждый раз это делать
        shapeRenderer.end();

        /*
         * 3. Мы отрисовываем рамку для квадрата
         */

        // Говорим shapeRenderer нарисовать рамку следующей формы
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        // Выбираем цвет RGB Color 255, 109, 120, не прозрачный
        shapeRenderer.setColor(255/255.0f,109/255.0f,120/255.0f,1);
        // Отрисовываем квадрат из myWorld (Using ShapeType.Line)
        shapeRenderer.rect(myWorld.getRet().x,myWorld.getRet().y,myWorld.getRet().width,myWorld.getRet().height);
        shapeRenderer.end();

    }



}
