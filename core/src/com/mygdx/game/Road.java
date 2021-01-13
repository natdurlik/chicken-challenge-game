package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Road extends LandPiece {
    private final ArrayList<Vehicle> vehicles;
    private VehicleRegistry vehicleRegistry;
    private boolean playerOnRoad = false;
    private float timeBetweenVehicleSpawns;
    private float timeSinceLastVehicle = 0f;
    private final float spawnPosX = posX + (width - 128) / 2f;
    private final float spawnPosY = ChickenChallengeGame.WORLD_HEIGHT;
    Random random=new Random();

    public Road(VehicleRegistry vehicleRegistry, float posX, float posY) {
        super(posX, posY, new Texture("old_road2.png"));
        vehicles = new ArrayList<>();
        this.vehicleRegistry = vehicleRegistry;
        timeBetweenVehicleSpawns = random.nextInt(4);
    }

    public Road(VehicleRegistry vehicleRegistry, float posX, float posY, float timeBetweenVehicleSpawns, Texture texture) {
        super(posX, posY, texture);
        vehicles = new ArrayList<>();
        random = new Random();
        this.timeBetweenVehicleSpawns = random.nextInt(4);
        this.vehicleRegistry = vehicleRegistry;
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(texture, posX, posY);
        for (Vehicle vehicle : vehicles) {
            vehicle.draw(batch);
        }
    }

    @Override
    public void update(float delta) {
        spawnVehicle(delta);
        if (checkPlayerOnRoad() != playerOnRoad) {
            notifyObservers();
            playerOnRoad = !playerOnRoad;
        }
        Iterator<Vehicle> it = vehicles.iterator();
        while (it.hasNext()) {
            Vehicle tmpVehicle = it.next();
            if (outOfBounds(tmpVehicle)) {
                it.remove();
            } else tmpVehicle.update(delta);
        }
    }

    @Override
    public void notifyObservers() {
        for (Vehicle vehicle : vehicles) {
            vehicle.observerUpdate();
        }
    }

    private boolean checkPlayerOnRoad() {
        return Player.getInstance().getPosX() + Player.getInstance().getWidth() >= posX && Player.getInstance().getPosX() < posX + width;
    }

    private void spawnVehicle(float delta) {
        timeSinceLastVehicle += delta;
        if (timeSinceLastVehicle >= timeBetweenVehicleSpawns) {
            Vehicle tmpVehicle = vehicleRegistry.createVehicle();
            tmpVehicle.posX = spawnPosX;
            tmpVehicle.posY = spawnPosY;
            tmpVehicle.canSeePlayer = playerOnRoad;
            if (!vehicles.isEmpty()) tmpVehicle.nextVehicle = vehicles.get(vehicles.size() - 1);
            vehicles.add(tmpVehicle);

            timeSinceLastVehicle = 0;
            float tmp = random.nextFloat();
            tmp *= 3f;
            if (tmp < 1.2) tmp += 1;
            timeBetweenVehicleSpawns = tmp;
        }
    }

    private boolean outOfBounds(Vehicle vehicle) {
        if (vehicle.posX + vehicle.height < 0) return true;
        return false;
    }

}
