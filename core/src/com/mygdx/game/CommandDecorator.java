package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

//Decorator pattern
abstract public class CommandDecorator implements DrawableCommand {
    DrawableCommand command;
    Texture currentTexture;
    Texture activeTexture;
    Texture inactiveTexture;
    float posX;
    float posY;

    public CommandDecorator(DrawableCommand command, Texture activeTexture, Texture inactiveTexture, float posX, float posY) {
        this.command = command;
        this.activeTexture = activeTexture;
        this.inactiveTexture = inactiveTexture;
        this.posX = posX;
        this.posY = posY;
        this.currentTexture = inactiveTexture;
    }

    public void update(float delta) {

    }
}
