package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

public class MovingSnowflake implements Drawable {
    private final Snowflake snowflake;
    private final float speed;
    int posX, posY;
    private float timeSinceLastChange = 0;
    private final float timeBetweenChanges = 20f;
    private int dir = 1;
    Random random = new Random();

    public MovingSnowflake(Snowflake snowflake, float speed, int posX, int posY) {
        this.snowflake = snowflake;
        this.speed = speed;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public void draw(Batch batch) {
        snowflake.draw(batch, posX, posY);
    }

    @Override
    public void update(float delta) {
        posY -= speed * delta;
        if(speed<300) return;
        posX += speed * delta * dir * 0.5;
        timeSinceLastChange++;
        if (timeSinceLastChange > timeBetweenChanges) {
            timeSinceLastChange = 0;
            if (random.nextBoolean()) {
                dir = -dir;
            }
        }
    }

    public int getWidth() {
        return snowflake.width;
    }

    public int getHeight() {
        return snowflake.height;
    }
}
