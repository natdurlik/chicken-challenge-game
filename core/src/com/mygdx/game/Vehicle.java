package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

abstract public class Vehicle implements Drawable, Observer {
    DrivingStrategy drivingStrategy;
    Vehicle nextVehicle;
    boolean canSeePlayer;
    float posX, posY;
    int width, height;
    float movementSpeed;
    int damage;
    float elapsedTime = 0;

    Texture texture;
    TextureRegion[] animationTexture;
    Animation drivingAnimation;

    public Vehicle(DrivingStrategy drivingStrategy, Vehicle nextVehicle, float posX, float posY,
                   float movementSpeed,
                   int damage, boolean canSeePlayer, Texture texture) {
        this.drivingStrategy = drivingStrategy;
        this.nextVehicle = nextVehicle;
        this.posX = posX;
        this.posY = posY;
        this.texture = texture;
        this.width = texture.getWidth();
        this.height = texture.getHeight();
        this.movementSpeed = movementSpeed;
        this.damage = damage;
        //this.animationTexture = animationTexture;
       // this.drivingAnimation = drivingAnimation;
    }

    public Vehicle(Vehicle vehicle) {
        this.drivingStrategy = vehicle.drivingStrategy;
        this.nextVehicle = vehicle.nextVehicle;
        this.posX = vehicle.posX;
        this.posY = vehicle.posY;
        this.width = vehicle.width;
        this.height = vehicle.height;
        this.movementSpeed = vehicle.movementSpeed;
        this.damage = vehicle.damage;
        this.texture = vehicle.texture;
        this.animationTexture = vehicle.animationTexture;
        this.drivingAnimation = vehicle.drivingAnimation;
    }

    abstract public void move(float delta);


    public void checkForCollision() {
        Player player = Player.getInstance();
        if (player.getPosX() + player.getWidth() - 15 > posX && player.getPosX() + 15 < posX + width
                && player.getPosY() + player.getHeight() - 20 > posY && player.getPosY() + 20 < posY + height) {
            player.collision(damage);
        }
    }

    abstract public Vehicle cloneVehicle();

}
