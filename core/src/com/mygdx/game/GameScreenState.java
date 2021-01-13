package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

//State pattern
abstract class GameScreenState implements Screen {
    ChickenChallengeGame game;

    public GameScreenState(ChickenChallengeGame game) {
        this.game = game;
    }

    //Template Method pattern
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        update(delta);
        draw();
        //hook(delta);
        handleInput(delta);
        game.batch.end();
    }

    protected abstract void draw();

    protected abstract void update(float delta);

    protected abstract void handleInput(float delta);

    //public void hook(float delta) {}

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height, true);
        game.batch.setProjectionMatrix(game.camera.combined);
    }

    @Override
    public void show() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


}
