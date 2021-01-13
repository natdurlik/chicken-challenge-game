package com.mygdx.game;

public class ChangeControlsCommand implements Command{
    ChickenChallengeGame game;

    ChangeControlsCommand(ChickenChallengeGame game) {
        this.game=game;
    }

    @Override
    public void execute(float delta) {
        game.gameScreen.changePlayerButtons();
    }
}
