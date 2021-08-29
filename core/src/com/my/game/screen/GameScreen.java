package com.my.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.my.game.base.BaseScreen;

public class GameScreen extends BaseScreen {
    private Texture background;
    private Texture row;
    private Vector2 rowPos;
    private Vector2 rowTargetPos;
    private Vector2 rowV;
    private Vector2 rowA;
    private int ROW_SPEED = 20;
    private boolean shoot = false;

    @Override
    public void show() {
        super.show();
        background = new Texture("forest.jpg");
        row = new Texture("row.jpg");
        rowPos = new Vector2();
        rowA = new Vector2(0f, -1f);
        rowV = new Vector2();
        rowTargetPos = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        checkAndMoveRow();
        batch.begin();
        batch.draw(row, rowPos.x, rowPos.y);
        batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        shoot = true;
        System.out.println("touchDown");
        rowTargetPos.set(screenX, Gdx.graphics.getHeight() - screenY);
        rowV.set(rowTargetPos.sub(rowPos)).nor();
        rowV.scl(ROW_SPEED);
        return false;
    }


    private void checkAndMoveRow() {
        if (shoot && rowPos.y >= 0) {
            rowPos.add(rowV);
            rowV.add(rowA);
        } else return;
        if(rowPos.y < 0) {
            rowPos.y = 0;
            shoot = false;
        }
    }
}
