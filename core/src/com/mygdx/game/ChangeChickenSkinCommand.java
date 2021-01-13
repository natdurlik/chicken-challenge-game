package com.mygdx.game;

public class ChangeChickenSkinCommand implements Command{
    @Override
    public void execute(float delta) {
        Player.getInstance().changeTexture();
    }
}
