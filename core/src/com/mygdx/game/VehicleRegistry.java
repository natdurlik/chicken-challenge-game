package com.mygdx.game;


import java.util.ArrayList;
import java.util.Random;

public class VehicleRegistry {
    ArrayList<Vehicle> vehiclePrototypes;
    Random random = new Random();

    public VehicleRegistry() {
        vehiclePrototypes = new ArrayList<>();
    }

    public Vehicle createVehicle() {
        int idx=random.nextInt(vehiclePrototypes.size());
        return vehiclePrototypes.get(idx).cloneVehicle();
    }

    public Vehicle getByStrategy(String strategy) {
        return vehiclePrototypes.get(0).cloneVehicle();
    }

    public void addPrototype(Vehicle vehicle) {
        vehiclePrototypes.add(vehicle);
    }
}
