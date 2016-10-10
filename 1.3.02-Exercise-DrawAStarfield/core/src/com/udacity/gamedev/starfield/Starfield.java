package com.udacity.gamedev.starfield;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

/**
 * TODO: Start here!
 *
 * In this exercise we'll draw a star field of white points on a black background. The number of
 * points will be defined by a density parameter that states what proportion of the pixels should be
 * white.
 *
 * TODO: Run what you've got before making any changes
 *
 * One thing to note is we're using two new LibGDX classes, Array, and Vector2. We're using a custom
 * Array type so LibGDX can control the memory, and avoid unfortunate garbage collection events.
 * Vector2 is a super simple class for holding a 2D position. You can find more information in the
 * LibGDX Javadocs, or just by right clicking on the class name, and selecting Go To > Declaration.
 *
 * One new utility class we'll be using in this exercise is com.badlogic.gdx.math.Vector2. You can
 * find more information in the LibGDX Javadocs.
 *
 * Remember you can set up a Desktop run configuration using the dropdown in the toolbar, or you can
 * open the terminal at the bottom of the screen and run
 *
 * $ ./gradlew desktop:run
 */


public class Starfield extends ApplicationAdapter {

    private static final float STAR_DENSITY = 0.01f;
    ShapeRenderer shapeRenderer;
    Array<Vector2> stars;

    @Override
    public void create() {
        // TODO: Initialize a shapeRenderer
        shapeRenderer = new ShapeRenderer();

        // TODO: Call initStars
        initStars(STAR_DENSITY);

    }

    public void initStars(float density) {
        // TODO: Figure out how many stars to draw. You'll need the screen dimensions, which you can get using Gdx.graphics.getWidth() and Gdx.graphics.getHeight().
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();

        // TODO: Create a new array of Vector2's to hold the star positions
        int numberOfStars = (int)(screenWidth * screenHeight * density);
        // Array here is from Gdx library (constructor can take capacity as argument)
        stars = new Array<Vector2>(numberOfStars);

        // TODO: Use java.util.Random to fill the array of star positions
        Random generator = new Random();

        for (int i = 0; i < numberOfStars; i++) {
            // Must use float, not double
            float randomPosX, randomPosY;

            randomPosX = generator.nextFloat() * screenWidth;
            randomPosY = generator.nextFloat() * screenHeight;

            // Use float for the position coordinates
            stars.add(new Vector2(randomPosX, randomPosY));
        }
    }

    @Override
    public void resize(int width, int height) {
        initStars(STAR_DENSITY);
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render() {
        // TODO: Make the night sky black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO: Begin a shapeRenderer batch using ShapeType.Point
        shapeRenderer.begin(ShapeRenderer.ShapeType.Point);

        // TODO: Loop through the star positions and use shapeRenderer to draw points
        for (Vector2 star : stars) {
            shapeRenderer.setColor(255, 255, 255, 1);
            shapeRenderer.point(star.x, star.y, 0);
        }

        // TODO: End the shapeRenderer batch
        shapeRenderer.end();

    }

    @Override
    public void dispose() {
        // TODO: Dispose of our ShapeRenderer
        shapeRenderer.dispose();

        super.dispose();
    }
}
