package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Weather implements Drawable {
    private final Snowflake[] snowflakes = {new Snowflake(new Texture("snowflake.png")), new Snowflake(new Texture("snowflake2.png"))};
    private final LinkedList<MovingSnowflake> movingSnowflakes = new LinkedList<>();
    private final float timeBetweenSpawns = 0.08f;
    private float timeSinceLastSpawn = 0f;
    Random random = new Random();

    @Override
    public void draw(Batch batch) {
        for (MovingSnowflake snow : movingSnowflakes) {
            snow.draw(batch);
        }
    }

    @Override
    public void update(float delta) {
        timeSinceLastSpawn += delta;
        Iterator<MovingSnowflake> it = movingSnowflakes.iterator();
        while (it.hasNext()) {
            MovingSnowflake tmpSnowflake = it.next();
            if (outOfBounds(tmpSnowflake)) {
                it.remove();
            } else tmpSnowflake.update(delta);
        }
        spawnSnow();
    }

    private boolean outOfBounds(MovingSnowflake snowflake) {
        return snowflake.posX + snowflake.getWidth() < 0
                || snowflake.posX > ChickenChallengeGame.WORLD_WIDTH
                || snowflake.posY + snowflake.getHeight() < 0;
    }

    public void spawnSnow() {
        if (timeSinceLastSpawn > timeBetweenSpawns) {
            timeSinceLastSpawn = 0;
            int randomPosX = random.nextInt(ChickenChallengeGame.WORLD_WIDTH);
            float randomSpeed = random.nextFloat() * 500f;
            if (randomSpeed < 200) randomSpeed += 100;
            movingSnowflakes.push(new MovingSnowflake(snowflakes[random.nextInt(snowflakes.length)],
                            randomSpeed, randomPosX, ChickenChallengeGame.WORLD_HEIGHT));
        }
    }

    public void reset() {
        movingSnowflakes.clear();
    }
}
