package com.udacity.gamedev.rectangularflower;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * TODO: Start Here
 *
 * In this exercise, we're going to draw a flower using only rectangles! We've already started off
 * with a green rectline for the stem. First you'll draw a couple leaves using rotated rectangles.
 *
 * Then you'll draw the head of the flower by drawing a a bunch of rotated squares!
 */

public class RectangularFlower extends ApplicationAdapter {

    ShapeRenderer shapeRenderer;

    @Override
    public void create () {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void dispose() {
        super.dispose();
        shapeRenderer.dispose();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rectLine(100, 0, 100, 300, 20);

        // TODO: Draw two leaves on the stem
//        shapeRenderer.setColor(Color.MAGENTA);
//        shapeRenderer.rect(40, 50, 0, 0, 60, 60, 1, 1, 0);

        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.rect(40, 50, 40, 0, 60, 60, 1, 1, 35);

        shapeRenderer.rect(100, 100, 30, 0, 60, 60, 1, 1, -35); // or 315 deg

        // TODO: Set the active color to yellow
        shapeRenderer.setColor(Color.GRAY);

        final int PETALS = 8;

        // TODO: Use a loop to draw 20 of these petals in a circle
//        for (int i = 0; i < PETALS; i++) {
//            shapeRenderer.rect(100, 300, 0, 0, 30, 20, 1, 1, i * 90 / PETALS);
//        }
       // shapeRenderer.rect(100, 300, 0, 0, 30, 20, 1, 1, 0);

        shapeRenderer.setColor(Color.YELLOW);

        for (int i = 0; i < PETALS; i++) {
            float petalAngle = 360.0f / PETALS; //45.0f;
            shapeRenderer.rect(100, 300, 0, 0, 40, 40, 1, 1, petalAngle * i);
        }


        shapeRenderer.end();
    }
}
