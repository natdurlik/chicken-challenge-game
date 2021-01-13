package com.mygdx.game;

import java.util.Random;

public class ChaoticDriving implements DrivingStrategy {
    Random random = new Random();
    float timeSinceLastChange = 0;
    float timeBetweenChanges = 4f;
    float bonusMovementSpeed = 0f;
    int minPosX;
    int maxPosX;

    ChaoticDriving(int minPosX, int maxPosX) {
        this.maxPosX = maxPosX;
        this.minPosX = minPosX;
    }

    @Override
    public void move(float delta, Vehicle vehicle) {
        if (vehicle.nextVehicle != null) {
            vehicle.posY = Math.max(vehicle.posY - vehicle.movementSpeed * delta, vehicle.nextVehicle.posY + vehicle.nextVehicle.height + 15);
        } else
            vehicle.posY -= vehicle.movementSpeed * delta;
        timeSinceLastChange += delta;
        if (timeSinceLastChange > timeBetweenChanges) {
            timeSinceLastChange = 0;
            //float f = random.nextFloat() * 100;
            if (random.nextBoolean()) {
                vehicle.posX=Math.max(vehicle.posX - vehicle.movementSpeed * delta, minPosX-10);
            } else {
                vehicle.posX=Math.min(vehicle.posX + vehicle.movementSpeed * delta, maxPosX+vehicle.width+10);
            }
        }
    }
}
