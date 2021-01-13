package com.mygdx.game;

public class SettingsCommand implements Command{
    ChickenChallengeGame game;
    SettingsCommand(ChickenChallengeGame game) {
        this.game=game;
    }
    @Override
    public void execute(float delta) {
        game.setScreen(game.settingsMenu);
    }
}
