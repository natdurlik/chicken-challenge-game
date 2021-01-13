package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

abstract class LandPiece implements Drawable, Observable {
    float posX, posY;
    int width, height;
    Texture texture;

    public LandPiece(float posX, float posY, Texture texture) {
        this.posX = posX;
        this.posY = posY;
        this.texture = texture;
        this.width = texture.getWidth();
        this.height = texture.getHeight();
    }

}
