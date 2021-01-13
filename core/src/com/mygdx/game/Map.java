package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.ArrayList;
import java.util.Random;

public class Map implements Drawable {
    private final ArrayList<LandPiece> landPieces;
    private final VehicleRegistry vehicleRegistry;
    private final Weather weather = new Weather();
    private float currPosX;
    private final float currPosY = 0;
    Random random = new Random();
    private boolean weatherOn = false;

    public Map() {
        vehicleRegistry = new VehicleRegistry();
        landPieces = new ArrayList<>();
        currPosX = 0;

        //generate Map
        vehicleRegistry.addPrototype(new Car(new Texture("green_car.png"), 400f));
        vehicleRegistry.addPrototype(new Car(new AggressiveDriving(150f), new Texture("red_car.png"), 200f));
        vehicleRegistry.addPrototype(new Car(new AggressiveDriving(-100f), new Texture("green_car.png"), 400f));
        vehicleRegistry.addPrototype(new Car(new Texture("red_car.png"), 200f));
        vehicleRegistry.addPrototype(new Car(new Texture("blue_car.png"), 300f));
        vehicleRegistry.addPrototype(new Car(new AggressiveDriving(200f), new Texture("blue_car.png"), 150f));
    }

    public void generateMap(int level) {
        if ( level % 3 == 0) {
            //if (level % 2 == 0)
                vehicleRegistry.addPrototype(new Car(new AggressiveDriving(150f), new Texture("violet_car.png"), 200f));
            //else
                //vehicleRegistry.addPrototype(new Car(new AggressiveDriving(-50f), new Texture("red_car.png"), 300f));
        }
        if (random.nextBoolean())
            weatherOn = true;
        else {
            weatherOn = false;
            weather.reset();
        }

        landPieces.clear();

        currPosX = 0;
        landPieces.add(new Grass(currPosX, currPosY, new Texture("narrow_grass.png")));
        currPosX += landPieces.get(landPieces.size() - 1).width;

        while (currPosX + 230 < ChickenChallengeGame.WORLD_WIDTH) {
            int type = random.nextInt(100);
            if (type < 10)
                landPieces.add(new Grass(currPosX, currPosY, new Texture("narrow_grass.png")));
            else if (type > 55)
                landPieces.add(new Road(vehicleRegistry, currPosX, currPosY, 5, new Texture("narrow_road2.png")));
            else landPieces.add(new Road(vehicleRegistry, currPosX, currPosY));

            currPosX += landPieces.get(landPieces.size() - 1).width;
        }
        landPieces.add(new Grass(currPosX, currPosY, new Texture("wide_grass.png")));
        currPosX += landPieces.get(landPieces.size() - 1).width;

    }

    @Override
    public void draw(Batch batch) {
        for (LandPiece landPiece : landPieces) {
            landPiece.draw(batch);
        }
        Player.getInstance().draw(batch);
        weather.draw(batch);
    }

    @Override
    public void update(float delta) {
        for (LandPiece landPiece : landPieces) {
            landPiece.update(delta);
        }
        if (weatherOn) weather.update(delta);
    }
}
