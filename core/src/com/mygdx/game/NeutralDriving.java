package com.mygdx.game;

public class NeutralDriving implements DrivingStrategy {
    @Override
    public void move(float delta, Vehicle vehicle) {
        if (vehicle.nextVehicle != null)
            vehicle.posY = Math.max(vehicle.posY - vehicle.movementSpeed * delta, vehicle.nextVehicle.posY + vehicle.nextVehicle.height+15);
        else
            vehicle.posY -= vehicle.movementSpeed * delta;
    }
}
