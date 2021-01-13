package com.mygdx.game;

public class MoveRightCommand implements Command{
    @Override
    public void execute(float delta) {
        Player.getInstance().moveRight(delta);
    }
}
