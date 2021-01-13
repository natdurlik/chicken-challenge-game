package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class QuitGameCommand implements Command {
    @Override
    public void execute(float delta) {
        Gdx.app.exit();
    }
}
