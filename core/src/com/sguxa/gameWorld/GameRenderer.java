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
import com.sguxa.GameObjects.Grass;
import com.sguxa.GameObjects.Pipe;
import com.sguxa.GameObjects.ScrollHandler;
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
    private ScrollHandler scroller;
    private Grass frontGrass,backGrass;
    private Pipe pipe1,pipe2,pipe3;
	
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
        scroller=myWorld.getScroller();
        frontGrass=scroller.getFrontGrass();
        backGrass=scroller.getBaskGrass();
        pipe1=scroller.getPipe1();
        pipe2=scroller.getPipe2();
        pipe3=scroller.getPipe3();
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

    private void drawSkulls(){
        // Временный код, извините за кашу :)
        // Мы это починим, как только закончим с Pipe классом.
        batcher.draw(skullUp,pipe1.getX()-1,pipe1.getY()+pipe1.getHeight()-14,24,14);
        batcher.draw(skullDown,pipe1.getX()-1,pipe1.getY()+pipe1.getHeight()-14,24,14);

        batcher.draw(skullUp,pipe2.getX()-1,pipe2.getY()+pipe2.getHeight()-14,24,14);
        batcher.draw(skullDown,pipe2.getX()-1,pipe2.getY()+pipe2.getHeight()-14,24,14);

        batcher.draw(skullUp,pipe2.getX()-1,pipe2.getY()+pipe2.getHeight()-14,24,14);
        batcher.draw(skullDown,pipe2.getX()-1,pipe2.getY()+pipe2.getHeight()-14,24,14);
    }


}
