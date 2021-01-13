package com.mygdx.game;

public class ContinueCommand implements Command{
    ChickenChallengeGame game;
    ContinueCommand(ChickenChallengeGame game) {
        this.game=game;
    }
    @Override
    public void execute(float delta) {
        if(game.gameScreen.isMapGenerated) game.setScreen(game.gameScreen);
    }
}
