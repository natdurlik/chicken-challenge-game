package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class MainMenu extends GameScreenState {
    private final Texture menuBackground=new Texture("menu_blue.png");
    private final Texture gameName=new Texture("chicken_challenge.png");
    private final MenuButton[] menuButtons;
    private final Command buttonQ;
    private int buttonsIdx;


    public MainMenu(ChickenChallengeGame game) {
        super(game);
        menuButtons=new MenuButton[4];
        menuButtons[0] = new MenuButton(new CommandAdapter( new NewGameCommand(game)),new Texture("active_new_game.png"), new Texture("inactive_new_game.png"), 424, 440);
        menuButtons[0].changeButtonState();
        menuButtons[1] = new MenuButton(new CommandAdapter(new ContinueCommand(game)),new Texture("active_continue.png"), new Texture("inactive_continue.png"), 424, 320);
        menuButtons[2] = new MenuButton(new CommandAdapter(new SettingsCommand(game)),new Texture("active_settings.png"), new Texture("inactive_settings.png"), 424, 200);
        menuButtons[3] = new MenuButton(new CommandAdapter(new QuitGameCommand()),new Texture("active_quit.png"), new Texture("inactive_quit.png"), 424, 80);
        buttonQ = menuButtons[3];
        buttonsIdx = 0;
    }

    @Override
    public void draw() {
        game.batch.draw(menuBackground, 0, 0);
        game.batch.draw(gameName, (float)(ChickenChallengeGame.WORLD_WIDTH-gameName.getWidth())/2, 600);
        for(MenuButton button:menuButtons) {
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
