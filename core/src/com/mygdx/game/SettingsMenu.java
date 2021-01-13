package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;



public class SettingsMenu extends GameScreenState {
    private final Texture menuBackground= new Texture("menu_blue.png");;
    private final Texture menuNote=new Texture("press_enter.png");;
    private final MenuButton[] menuButtons;
    private final Command buttonQ;
    private int buttonsIdx;

    public SettingsMenu(ChickenChallengeGame game) {
        super(game);
        menuButtons = new MenuButton[3];
        menuButtons[0] =
            new MenuButton(
                    new SideMenuButton(
                        new SideMenuButton(new CommandAdapter( new ChangeControlsCommand(game)), new Texture("inactive_arrows.png"), new Texture("active_arrows.png"), 800, 440),
                            new Texture("active_a_d.png"),new Texture("inactive_a_d.png"),1050,440),
                    new Texture("active_controls.png"), new Texture("inactive_controls.png"), 124,440);
        menuButtons[0].changeButtonState();
        menuButtons[1] =
            new MenuButton(
                    new SideMenuButton(
                        new SideMenuButton(new CommandAdapter( new ChangeChickenSkinCommand()), new Texture("inactive_red.png"), new Texture("active_red.png"), 770, 320),
                            new Texture("active_blue.png"),new Texture("inactive_blue.png"),1050,320),
                    new Texture("active_skin.png"), new Texture("inactive_skin.png"), 124,320);
        menuButtons[2] = new MenuButton(new CommandAdapter( new QuitToMenuCommand(game)), new Texture("active_back.png"), new Texture("inactive_back.png"), 124, 200);
        buttonQ = menuButtons[2];
        buttonsIdx = 0;
    }

    @Override
    public void draw() {
        game.batch.draw(menuBackground, 0, 0);
        game.batch.draw(menuNote,(float)(ChickenChallengeGame.WORLD_WIDTH-menuNote.getWidth())/2,600);
        for (MenuButton button : menuButtons) {
            button.draw(game.batch);
        }
    }

    @Override
    public void update(float delta) {

    }

    @Override
    protected void handleInput(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            menuButtons[buttonsIdx].changeButtonState();
            buttonsIdx++;
            buttonsIdx %= menuButtons.length;
            menuButtons[buttonsIdx].changeButtonState();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            menuButtons[buttonsIdx].changeButtonState();
            buttonsIdx--;
            buttonsIdx = buttonsIdx < 0 ? menuButtons.length + buttonsIdx : buttonsIdx;
            menuButtons[buttonsIdx].changeButtonState();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            buttonQ.execute(delta);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            menuButtons[buttonsIdx].execute(delta);
        }
    }
}
