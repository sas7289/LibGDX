package com.my.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.my.game.base.BaseScreen;
import com.my.game.base.Sprite;
import com.my.game.math.Rect;
import com.my.game.sprite.Background;
import com.my.game.sprite.Row;

public class GameScreen extends BaseScreen {
    private Background background;
    private Row row;

    private Texture bgTexture;
    private Texture rowTexture;

    private boolean shoot = false;

    @Override
    public void show() {
        super.show();
        bgTexture = new Texture("forest.jpg");
        rowTexture = new Texture("row.png");
        background = new Background(bgTexture);
        row = new Row(rowTexture);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        draw();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        row.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        bgTexture.dispose();
        rowTexture.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        row.touchDown(touch, pointer, button);
        return false;
    }

}
