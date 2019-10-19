package org.academiadecodigo.splicegirls.characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Paparazzi extends Enemy{

    public Paparazzi (int col, int row, String picturePath) throws InterruptedException {
        super(col, row, picturePath);

    }

    /*public void enemyAnimation() throws InterruptedException {
        picture.delete();
        picture = new Picture(startingPointCol + (col * cellSize + PADDING), startingPointRow + (row * cellSize + PADDING), "enemy/enemy1 walk.png");
        picture.draw();*/

    }
