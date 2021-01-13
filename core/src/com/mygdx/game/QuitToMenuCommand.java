package com.mygdx.game;

public class QuitToMenuCommand implements Command{
    ChickenChallengeGame game;
    QuitToMenuCommand(ChickenChallengeGame game) {
        this.game=game;
    }
    @Override
    public void execute(float delta) {
        game.setScreen(game.mainMenu);
    }
}
