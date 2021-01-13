package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;

public class CommandAdapter implements DrawableCommand{
    private Command command;

    public CommandAdapter(Command command) {
        this.command = command;
    }

    @Override
    public void changeButtonState() {

    }

    @Override
    public void execute(float delta) {
        command.execute(delta);
    }

    @Override
    public void draw(Batch batch) {

    }

    @Override
    public void update(float delta) {

    }
}
