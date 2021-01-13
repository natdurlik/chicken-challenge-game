package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;


//concrete Decorator
public class MenuButton extends CommandDecorator {

    public MenuButton(DrawableCommand command, Texture activeTexture, Texture inactiveTexture, float posX, float posY) {
        super(command, activeTexture, inactiveTexture, posX, posY);
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(currentTexture, posX, posY);
        command.draw(batch);
    }

    @Override
    public void changeButtonState() {
        currentTexture = currentTexture == activeTexture ? inactiveTexture : activeTexture;
        command.changeButtonState();
    }

    @Override
    public void execute(float delta) {
        command.execute(delta);
    }
}












/*public class MenuButton implements Command {
    Command command;
    Texture currentTexture;
    Texture activeTexture;
    Texture inactiveTexture;
    float posX;
    float posY;

    public MenuButton(Command command, Texture activeTexture, Texture inactiveTexture, float posX, float posY) {
        this.command=command;
        this.activeTexture = activeTexture;
        this.inactiveTexture = inactiveTexture;
        this.posX = posX;
        this.posY = posY;
        this.currentTexture = inactiveTexture;
    }


    public void draw(Batch batch) {
        batch.draw(currentTexture, posX, posY);
    }

    public void changeButtonState() {
        currentTexture = currentTexture == activeTexture ? inactiveTexture : activeTexture;
    }

    @Override
    public void execute(float delta) {
        command.execute(delta);
    }
}*/
