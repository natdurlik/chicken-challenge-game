package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;

public class GameLevelUpScreen extends GameScreenState {
    private Map map;
    private final Texture levelUpTexture=new Texture("level_up.png");;
    public static int level = 0;
    private final float levelUpScreenTime;
    private float elapsedTime;
    int score;

    public GameLevelUpScreen(ChickenChallengeGame game) {
        super(game);
        map = new Map();
        levelUpScreenTime = 2f;
        elapsedTime=0;
        score=0;
    }

    @Override
    protected void draw() {
        map.draw(game.batch);
        //Player.getInstance().draw(game.batch);
        game.batch.draw(levelUpTexture, (float)(ChickenChallengeGame.WORLD_WIDTH-levelUpTexture.getWidth())/2, 404);
    }

    @Override
    protected void update(float delta) {
        if(elapsedTime<=0.01f) reset();
        map.update(delta);
        //Player.getInstance().update(delta);
        elapsedTime+=delta;
        if(elapsedTime>levelUpScreenTime) {
            elapsedTime=0;
            //if(game.gameScreen==null) game.gameScreen=new GameScreen(game);
            game.gameScreen.setMap(map);
            game.setScreen(game.gameScreen);
        }
    }

    public void reset() {
        map.generateMap(level);
        Player.getInstance().reset();
    }

    @Override
    protected void handleInput(float delta) {
    }
}
