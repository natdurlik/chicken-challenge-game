package com.mygdx.game;

public class AggressiveDriving implements DrivingStrategy { //FIXME rename
    float acceleration;

    public AggressiveDriving(float acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public void move(float delta, Vehicle vehicle) {
        float f = 0;
        if (vehicle.canSeePlayer) f += acceleration;
        if (vehicle.nextVehicle != null) {
            vehicle.posY = Math.max(vehicle.posY - (vehicle.movementSpeed + f) * delta, vehicle.nextVehicle.posY + vehicle.nextVehicle.height + 15);
        } else
            vehicle.posY -= (vehicle.movementSpeed + f) * delta;
    }
}
