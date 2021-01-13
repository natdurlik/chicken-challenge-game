package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

//concrete Decorator
public class SideMenuButton extends CommandDecorator {

    public SideMenuButton(DrawableCommand command, Texture activeTexture, Texture inactiveTexture, float posX, float posY) {
        super(command, activeTexture, inactiveTexture, posX, posY);
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(currentTexture, posX, posY);
        command.draw(batch);
    }

    public void changeButtonState() {
        command.changeButtonState();
    }

    @Override
    public void execute(float delta) {
        command.execute(delta);
        currentTexture = currentTexture == activeTexture ? inactiveTexture : activeTexture;
    }

}
