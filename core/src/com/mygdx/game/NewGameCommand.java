package com.mygdx.game;

public class NewGameCommand implements Command{
    ChickenChallengeGame game;
    NewGameCommand(ChickenChallengeGame game) {
        this.game=game;
    }
    @Override
    public void execute(float delta) {
        //game.gameLevelUpScreen=new GameLevelUpScreen(game);
        game.setScreen(game.gameLevelUpScreen);
    }
}
