package com.my.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.my.game.base.BaseScreen;
import com.my.game.base.Sprite;
import com.my.game.sprite.Background;
import com.my.game.sprite.Row;

public class GameScreen extends BaseScreen {
    private Background background;
    private Row row;

//    private Texture background;
//    private Texture row;
//    private Vector2 rowPos; //позиция стрелы
//    private Vector2 rowTargetPos; //цель полёта стрелы
//    private Vector2 rowV; //вектор скорости стрелы
//    private Vector2 ox; //ось Х
//    private int ROW_SPEED = 20; //скалярная величина скорости
    private boolean shoot = false;

    @Override
    public void show() {
        super.show();

        background = new Background(new Texture("forest.jpg"));
        row = new Row(new Texture("row.png"));

//        rowPos = new Vector2();
//        rowTargetPos = new Vector2();
//        rowV = new Vector2();
//        ox = new Vector2(1, 0);
//        ox.nor();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
//        checkAndMoveRow();
//        rowV.nor();
        draw();
    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        row.draw(batch);
//        double angle =(Math.acos(rowV.dot(ox)) * 180 / 3.14);
//        batch.draw(row, rowPos.x, rowPos.y, row.getWidth()/2f, row.getHeight()/2f,
//                150f, 50f, 1f, 1f, (float) angle, 0,0,
//                256, 91, false, false);
        batch.end();
    }

//    @Override
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        shoot = true;
//        rowTargetPos.set(screenX, Gdx.graphics.getHeight() - screenY);
//        rowV.set(rowTargetPos.cpy().sub(rowPos)).nor();
//        return false;
//    }



//    private void checkAndMoveRow() {
//        if(shoot && ((rowTargetPos.x - rowPos.x) * rowV.x > 0)) {
//            rowV.scl(ROW_SPEED);
//            rowPos.add(rowV);
//        } else {
//            shoot = false;
//        }
//    }
}
