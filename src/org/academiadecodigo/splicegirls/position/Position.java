package org.academiadecodigo.splicegirls.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private Rectangle playableArea;
    private int y;
    private int x;
    private int distance = 50;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getPlayableArea(){
        return playableArea;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void increaseX(int distance){
        this.x = x + distance;
    }

    public void decreaseX(int distance){
        this.x = x - distance;
    }

    public void increaseY(int distance){
        this.y = y + distance;
    }

    public void decreaseY(int distance){
        this.y = y - distance;
    }

    public void moveUp() {
        if (y == playableArea.getY()) {
            return;
        }
        y = y - distance;
    }

    public void moveDown() {
        if (y == playableArea.getHeight()) {
            return;
        }
        y = y + distance;
    }

    public void moveLeft() {
        if (x == playableArea.getX()) {
            return;
        }
        x = x - distance;
    }

    public void moveRight() {
        if (x == playableArea.getWidth()) {
            return;
        }
        x = x + distance;
    }
}