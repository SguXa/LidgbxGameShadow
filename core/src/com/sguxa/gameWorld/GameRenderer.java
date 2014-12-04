package com.sguxa.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sguxa.GameObjects.Bird;
import com.sguxa.zbhelpers.AssetLoader;

/**
 * Created by r.gushin on 03.12.2014.
 */
public class GameRenderer {

	private GameWorld myWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;

    private SpriteBatch batch;

    private int mindPointY;
    private int gameHeight;



	public GameRenderer(GameWorld world, int gameHeight, int mindPointY) {
		myWorld = world;

        this.gameHeight= this.gameHeight;
        this.mindPointY=mindPointY;


		cam = new OrthographicCamera();
		cam.setToOrtho(true, 136, this.gameHeight);

        batch = new SpriteBatch();
        // привяжите batcher к камере
        batch.setProjectionMatrix(cam.combined);

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	}

	public void render(float runTime) {

        Bird bird=myWorld.getBird();

        // Заполним задний фон одним цветом
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Стартуем ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Отрисуем Background цвет
        shapeRenderer.setColor(55/255.0f,80/255.0f,100/255.0f,1);
        shapeRenderer.rect(0,0,136,mindPointY+65);

        // Отрисуем Grass
        shapeRenderer.setColor(111/255.0f,186/255.0f,45/255.0f,1);
        shapeRenderer.rect(0,mindPointY+65,136,11);

        // Отрисуем Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0,mindPointY+77,136,52);

        // Заканчиваем ShapeRenderer
        shapeRenderer.end();

        // Стартуем SpriteBatch
        batch.begin();

        // Отменим прозрачность
        // Это хорошо для производительности, когда отрисовываем картинки без прозрачности
        batch.disableBlending();
        batch.draw(AssetLoader.bg,0,mindPointY+23,136,43);

        // Птичке нужна прозрачность, поэтому включаем ее
        batch.enableBlending();

        // Отрисуем птичку на ее координатах. Получим Animation объект из AssetLoader
        // Передадим runTime переменную чтобы получить текущий кадр.
        batch.draw(AssetLoader.birdAnimation.getKeyFrame(runTime),bird.getX(),bird.getY(),bird.getWidth(),bird.getHeight());

        // Заканчиваем SpriteBatch
        batch.end();

	}


}
