package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;


//Flyweight pattern
public class Snowflake { // intrinsic state
    Texture texture;
    protected int width, height;

    public Snowflake(Texture texture) {
        this.texture = texture;
        this.height = texture.getHeight();
        this.width = texture.getWidth();
    }

    public void draw(Batch batch, int posX, int posY) {
        batch.draw(texture, posX, posY);
    }

}