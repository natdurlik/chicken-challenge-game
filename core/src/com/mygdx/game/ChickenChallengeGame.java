package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ChickenChallengeGame extends Game {
    public Texture img;

    public static final int WORLD_WIDTH = 1344;
    public static final int WORLD_HEIGHT = 756;
    protected GameScreen gameScreen;
    protected MainMenu mainMenu;
    protected SettingsMenu settingsMenu;
    protected GameLevelUpScreen gameLevelUpScreen;
    public Camera camera;
    public Viewport viewport;
    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        gameLevelUpScreen = new GameLevelUpScreen(this);
        mainMenu = new MainMenu(this);
        settingsMenu = new SettingsMenu(this);
        gameScreen = new GameScreen(this);

        setScreen(mainMenu);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        if (gameScreen != null) gameScreen.resize(width, height);
        gameLevelUpScreen.resize(width, height);
        mainMenu.resize(width, height);
        settingsMenu.resize(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        gameScreen.dispose();
        mainMenu.dispose();
        settingsMenu.dispose();
    }
}
