package org.academiadecodigo.splicegirls.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private int y;
    private int x;
    private int distance = 40;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
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
        y = y - distance;
    }

    public void moveDown() {
        y = y + distance;
    }

    public void moveLeft() {
        x = x - distance;
    }

    public void moveRight() {
        x = x + distance;
    }
}