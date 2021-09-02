package com.my.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.my.game.base.Sprite;
import com.my.game.math.Rect;

public class Row extends Sprite {
    private int HEIGHT_IMG = 10;

    private Vector2 rowPos; //позиция стрелы
    private Vector2 rowTargetPos; //цель полёта стрелы
    private Vector2 rowV; //вектор скорости стрелы
    private Vector2 ox; //ось Х
    private int ROW_SPEED = 20; //скалярная величина скорости
    private boolean shoot = false;


    public Row(Texture texture) {
        super(new TextureRegion(texture));
        rowPos = new Vector2();
        rowTargetPos = new Vector2();
        rowV = new Vector2();
        ox = new Vector2(1, 0);
        ox.nor();
    }

    @Override
    public void resize(Rect worldBounds) {
        this.pos.set(worldBounds.getLeft(), worldBounds.getBottom());
        setHeightProportion(HEIGHT_IMG);
    }

    @Override
    public void draw(SpriteBatch batch) {
        checkAndMoveRow();
        rowV.nor();
        double angle =(Math.acos(rowV.dot(ox)) * 180 / 3.14);
        batch.draw(regions[0].getTexture(), rowPos.x, rowPos.y, regions[0].getRegionWidth()/2f, regions[0].getRegionHeight()/2f,
                150f, 50f, 1f, 1f, (float) angle, 0,0,
                256, 91, false, false);
    }

    private void checkAndMoveRow() {
        if(shoot && ((rowTargetPos.x - rowPos.x) * rowV.x > 0)) {
            rowV.scl(ROW_SPEED);
            rowPos.add(rowV);
        } else {
            shoot = false;
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        shoot = true;
        rowTargetPos.set(touch);
        rowV.set(rowTargetPos.cpy().sub(rowPos)).nor();
        return false;
    }

    public void setHEIGHT_IMG(int HEIGHT_IMG) {
        this.HEIGHT_IMG = HEIGHT_IMG;
    }
}
