package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Car extends Vehicle {

    public Car() {
        super(new NeutralDriving(), null, 50, 100, 300f, 1,
                false, new Texture("red_car.png"));
    }

    public Car(Texture texture, float movementSpeed) {
        super(new NeutralDriving(), null, 50, 100, movementSpeed, 1,
                false, texture);
    }

    public Car(DrivingStrategy strategy,Texture texture, float movementSpeed) {
        super(strategy, null, 50, 100, movementSpeed, 1,
                false, texture);
    }

    public Car(DrivingStrategy drivingStrategy, Vehicle nextVehicle, float posX, float posY,
               float movementSpeed, int damage, boolean canSeePlayer,
               Texture texture) {
        super(drivingStrategy, nextVehicle, posX, posY, movementSpeed, damage, canSeePlayer, texture);
    }

    public Car(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(texture, posX, posY);
    }

    @Override
    public void update(float delta) {
        elapsedTime += delta;
        move(delta);
        if (canSeePlayer) checkForCollision();
    }

    @Override
    public void observerUpdate() {
        canSeePlayer = !canSeePlayer;
    }

    @Override
    public void move(float delta) {
        drivingStrategy.move(delta, this);
    }

    @Override
    public Vehicle cloneVehicle() {
        return new Car(this);
    }

}
