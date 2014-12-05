package com.sguxa.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
        // ��������� batcher � ������
		batcher.setProjectionMatrix(cam.combined);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	}

	public void render(float runTime) {

		// We will move these outside of the loop for performance later.
		Bird bird = myWorld.getBird();

        // �������� ������ ��� ����� ������
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // �������� ShapeRenderer
		shapeRenderer.begin(ShapeType.Filled);

        // �������� Background ����
		shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
		shapeRenderer.rect(0, 0, 136, midPointY + 66);

        // �������� Grass
		shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
		shapeRenderer.rect(0, midPointY + 66, 136, 11);

		// �������� Dirt
		shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
		shapeRenderer.rect(0, midPointY + 77, 136, 52);
		
		// ����������� ShapeRenderer
		shapeRenderer.end();

        // �������� SpriteBatch
		batcher.begin();
        // ������� ������������
        // ��� ������ ��� ������������������, ����� ������������ �������� ��� ������������
		batcher.disableBlending();
		batcher.draw(AssetLoader.bg, 0, midPointY + 23, 136, 43);

        // ������ ����� ������������, ������� �������� ��
		batcher.enableBlending();

        // �������� ������ �� �� �����������. ������� Animation ������ �� AssetLoader
        // ��������� runTime ���������� ����� �������� ������� ����.
		batcher.draw(AssetLoader.birdAnimation.getKeyFrame(runTime),
				bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());

        // ����������� SpriteBatch
		batcher.end();

	}


}
