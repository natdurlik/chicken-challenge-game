package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;

//for Composite pattern
public interface Drawable {
    void draw(Batch batch);

    void update(float delta);
}
