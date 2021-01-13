package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

//Singleton pattern
public class Player implements Drawable {
    private static Player playerInstance = new Player(0, 100, 64, 64, 3,
            250f);

    private float posX, posY;
    private final float startPosX, startPosY;
    private final int width, height;
    private final int maxLives;
    private int lives;
    private final float movementSpeed;
    private float elapsedTime = 0f;
    private float timeSinceLastMove = 0f;

    private Texture currentTexture;
    private final Texture playerTexture1 = new Texture("orange_chicken.png");
    private final Texture playerTexture2 = new Texture("blue_chicken.png");
    private final Texture playerCollisionTexture = new Texture("orange_chicken.png");
    private final Texture movingTexture1 = new Texture("orange_chicken_frames.png");
    private final Texture movingTexture2 = new Texture("blue_chicken_frames.png");
    private final Texture hpTexture=new Texture("hp.png");
    Animation movingAnimation1;
    Animation movingAnimation2;
    Animation currentMovingAnimation;

    enum PlayerState {
        stationary, moving, hurt, dead
    }

    PlayerState mode;

    public Player(float startPosX, float startPosY, int width, int height, int maxLives,
                  float movementSpeed) {
        this.startPosX = startPosX;
        this.posX = startPosX;
        this.startPosY = startPosY;
        this.posY = startPosY;
        this.width = width;
        this.height = height;
        this.maxLives = maxLives;
        this.lives = maxLives;
        this.movementSpeed = movementSpeed;
        this.currentTexture = playerTexture1;
        this.mode = PlayerState.stationary;


        TextureRegion[][] tmpFrames = TextureRegion.split(movingTexture1, width, height);
        TextureRegion[] movingAnimationFrames = new TextureRegion[tmpFrames.length * tmpFrames[0].length];
        if (tmpFrames.length * tmpFrames[0].length >= 0)
            System.arraycopy(tmpFrames[0], 0, movingAnimationFrames, 0, tmpFrames.length * tmpFrames[0].length);
        movingAnimation1 = new Animation(1f / 8f, movingAnimationFrames);

        tmpFrames = TextureRegion.split(movingTexture2, width, height);
        movingAnimationFrames = new TextureRegion[tmpFrames.length * tmpFrames[0].length];
        if (tmpFrames.length * tmpFrames[0].length >= 0)
            System.arraycopy(tmpFrames[0], 0, movingAnimationFrames, 0, tmpFrames.length * tmpFrames[0].length);
        movingAnimation2 = new Animation(1f / 8f, movingAnimationFrames);

        currentMovingAnimation = movingAnimation1;
    }

    public static Player getInstance() {
        return playerInstance;
    }

    @Override
    public void draw(Batch batch) {
        if (mode == PlayerState.moving)
            batch.draw((TextureRegion) currentMovingAnimation.getKeyFrame(elapsedTime, true), posX, posY);
        else
            batch.draw(currentTexture, posX, posY);
        for(int i=0;i<lives;i++) {
            batch.draw(hpTexture,ChickenChallengeGame.WORLD_WIDTH-(i+1)*hpTexture.getWidth()-20,
                    ChickenChallengeGame.WORLD_HEIGHT-hpTexture.getHeight()-20);
        }
    }

    @Override
    public void update(float delta) {
        elapsedTime += delta;
        if (mode == PlayerState.dead) return;
        timeSinceLastMove += delta;
        if (timeSinceLastMove > 0.08f)
            mode = PlayerState.stationary;
        else
            mode = PlayerState.moving;
    }

    public void moveLeft(float delta) {
        posX = Math.max(posX - movementSpeed * delta, 0);
        timeSinceLastMove = 0;
    }

    public void moveRight(float delta) {
        posX = Math.min(posX + movementSpeed * delta, ChickenChallengeGame.WORLD_WIDTH - width);
        timeSinceLastMove = 0;
    }

    public void collision(int damage) {
        lives = Math.max(lives - damage, 0);
        if (lives == 0) mode = PlayerState.dead;
        else {
            mode = PlayerState.hurt;
            posX = startPosX;
            posY = startPosY;
        }
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void changeTexture() {
        currentTexture = currentTexture == playerTexture1 ? playerTexture2 : playerTexture1;
        currentMovingAnimation = currentMovingAnimation == movingAnimation1 ? movingAnimation2 : movingAnimation1;
    }

    public void reset() {
        mode = PlayerState.stationary;
        posY = startPosY;
        posX = startPosX;
        lives = maxLives;
    }

}
