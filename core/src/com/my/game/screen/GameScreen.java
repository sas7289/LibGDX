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
    private Vector2 ox;
    private int ROW_SPEED = 10;
    private boolean shoot = false;

    @Override
    public void show() {
        super.show();
        background = new Texture("forest.jpg");
        row = new Texture("row.png");
        rowPos = new Vector2();
        rowTargetPos = new Vector2();
        rowA = new Vector2(0f, -1f);
        rowV = new Vector2();
        ox = new Vector2(1, 0);
        ox.nor();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        checkAndMoveRow();
        rowV.nor();
        batch.begin();
        batch.draw(background, 0, 0);
        double angle =(Math.acos(rowV.dot(ox)) * 180 / 3.14);
        batch.draw(row, rowPos.x, rowPos.y, row.getWidth()/2f, row.getHeight()/2f,
                150f, 50f, 1f, 1f, (float) angle, 0,0,
                256, 91, false, false);
        batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        shoot = true;
        System.out.println("touchDown");
        rowTargetPos.set(screenX, Gdx.graphics.getHeight() - screenY);
        rowV.set(rowTargetPos.sub(rowPos)).nor();
        return false;
    }



    private void checkAndMoveRow() {
        if(shoot && ((rowTargetPos.x - rowPos.x) * rowV.x > 0)) {
            rowV.scl(ROW_SPEED);
            rowPos.add(rowV);
        } else {
            shoot = false;
        }

//        if (shoot && rowPos.y >= 0) {
//            rowV.scl(ROW_SPEED);
//            rowPos.add(rowV);
//            rowV.add(rowA);
//        } else return;
//        if(rowPos.y < 0) {
//            rowPos.y = 0;
//            shoot = false;
//        }
    }
}
