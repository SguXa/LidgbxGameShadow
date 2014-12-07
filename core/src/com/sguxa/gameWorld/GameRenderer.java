package com.sguxa.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.sguxa.GameObjects.Bird;
import com.sguxa.zbhelpers.AssetLoader;

/**
 * Created by r.gushin on 03.12.2014.
 */
public class GameRenderer {
	
	private GameWorld myWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;

	private SpriteBatch batcher;

	private int midPointY;
	private int gameHeight;
	
	// Объеты игры
	private Bird bird;
	
	// Assets игры
	private TextureRegion bg,grass;
	private Animation birdAnimation;
	private TextureRegion birdMid, birdDown, birdUp;
	private TextureRegion skullUp,skullDown,bar;
	

	public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
		myWorld = world;

		// The word "this" refers to this instance.
		// We are setting the instance variables' values to be that of the
		// parameters passed in from GameScreen.
		this.gameHeight = gameHeight;
		this.midPointY = midPointY;

		cam = new OrthographicCamera();
		cam.setToOrtho(true, 136, gameHeight);

		batcher = new SpriteBatch();
        // привяжите batcher к камере
		batcher.setProjectionMatrix(cam.combined);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);

		// Вызовем вспомогательные методы, чтобы проиницилизировать переменные класса
		initGameObjects();
        initAssets();
	}

	public void render(float runTime) {

		// Заполним задний фон одним цветом
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Стартуем ShapeRenderer
		shapeRenderer.begin(ShapeType.Filled);

        // Отрисуем Background цвет
		shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
		shapeRenderer.rect(0, 0, 136, midPointY + 66);

        // Отрисуем Grass
		shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
		shapeRenderer.rect(0, midPointY + 66, 136, 11);

		// Отрисуем Dirt
		shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
		shapeRenderer.rect(0, midPointY + 77, 136, 52);
		
		// Заканчиваем ShapeRenderer
		shapeRenderer.end();

        // Стартуем SpriteBatch
		batcher.begin();
        // Отменим прозрачность
        // Это хорошо для производительности, когда отрисовываем картинки без прозрачности
		batcher.disableBlending();
		batcher.draw(AssetLoader.bg, 0, midPointY + 23, 136, 43);

        // Птичке нужна прозрачность, поэтому включаем ее
		batcher.enableBlending();

        
		if(bird.shouldntFlap()){
			batcher.draw(birdMid, bird.getX(), bird.getY(),
                    bird.getWidth() / 2.0f, bird.getHeight() / 2.0f,
                    bird.getWidth(), bird.getHeight(), 1, 1, bird.getRotation());
		}else{
			batcher.draw(birdAnimation.getKeyFrame(runTime), bird.getX(),
                    bird.getY(), bird.getWidth() / 2.0f,
                    bird.getHeight() / 2.0f, bird.getWidth(), bird.getHeight(),
                    1, 1, bird.getRotation());
		}
		
        // Заканчиваем SpriteBatch
		batcher.end();

	}
	
	private void initGameObjects(){
		bird=myWorld.getBird();
	}
	
	private void initAssets(){
        bg = AssetLoader.bg;
        grass = AssetLoader.grass;
        birdAnimation = AssetLoader.birdAnimation;
        birdMid = AssetLoader.bird;
        birdDown = AssetLoader.birdDown;
        birdUp = AssetLoader.birdUp;
        skullUp = AssetLoader.skullUp;
        skullDown = AssetLoader.skullDown;
        bar = AssetLoader.bar;
	}

}
