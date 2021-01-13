package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen extends GameScreenState {
    private Map map;
    private Command buttonArrowLeft;
    private Command buttonArrowRight;
    private Command buttonA;
    private Command buttonD;
    private final Command buttonQ;
    private final Command nullCommand;
    private final Texture gameOverTexture = new Texture("game_over.png");
    private final Texture gameOverNote = new Texture("press_q.png");
    boolean isMapGenerated = false;

    public GameScreen(ChickenChallengeGame game) {
        super(game);
        //this.map = map;
        //buttonArrowLeft=(float delta)->{Player.getInstance().moveLeft(delta);}; //FIXME lambada
        //buttonArrowLeft=Player.getInstance()::moveLeft; //FIXME
        buttonArrowLeft = new MoveLeftCommand();
        buttonArrowRight = new MoveRightCommand();
        nullCommand = new NullCommand();
        buttonA = nullCommand;
        buttonD = nullCommand;
        buttonQ = new QuitToMenuCommand(game);
    }

    @Override
    public void draw() {
        map.draw(game.batch);
        if (Player.getInstance().mode == Player.PlayerState.dead) {
            game.batch.draw(gameOverTexture, (float) (ChickenChallengeGame.WORLD_WIDTH - gameOverTexture.getWidth()) / 2, 404);
            game.batch.draw(gameOverNote, (float) (ChickenChallengeGame.WORLD_WIDTH - gameOverNote.getWidth()) / 2, 300);
        }
    }

    @Override
    public void update(float delta) {
        if (checkLevelUp()) game.setScreen(game.gameLevelUpScreen);
        if (Player.getInstance().mode != Player.PlayerState.dead) {
            map.update(delta);
            Player.getInstance().update(delta);
        }
    }

    public boolean checkLevelUp() {
        return Player.getInstance().getPosX() + Player.getInstance().getWidth() + 20 >= ChickenChallengeGame.WORLD_WIDTH;
    }


    @Override
    protected void handleInput(float delta) {
        if (Player.getInstance().mode != Player.PlayerState.dead) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                buttonArrowLeft.execute(delta);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                buttonArrowRight.execute(delta);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                buttonA.execute(delta);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                buttonD.execute(delta);
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            buttonQ.execute(delta);
        }
    }

    public void setMap(Map map) {
        this.map = map;
        isMapGenerated = true;
    }

    public void changePlayerButtons() {
        if (buttonA == nullCommand) {
            buttonA = new MoveLeftCommand();
            buttonD = new MoveRightCommand();
            buttonArrowLeft = nullCommand;
            buttonArrowRight = nullCommand;
        } else {
            buttonA = nullCommand;
            buttonD = nullCommand;
            buttonArrowLeft = new MoveLeftCommand();
            buttonArrowRight = new MoveRightCommand();
        }
    }
}
