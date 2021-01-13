package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Grass extends LandPiece {

    public Grass(float posX, float posY) {
        super(posX, posY, new Texture("grass.png"));
    }

    public Grass(float posX, float posY, Texture texture) {
        super(posX, posY, texture);
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(texture, posX, posY);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void notifyObservers() {

    }
}
