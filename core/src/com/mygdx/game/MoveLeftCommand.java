package com.mygdx.game;

public class MoveLeftCommand implements Command{
    @Override
    public void execute(float delta) {
        Player.getInstance().moveLeft(delta);
    }
}
