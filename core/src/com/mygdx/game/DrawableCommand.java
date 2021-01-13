package com.mygdx.game;

public interface DrawableCommand extends Drawable, Command {
    void changeButtonState();
}
