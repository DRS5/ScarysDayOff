package org.academiadecodigo.splicegirls.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private int col;
    private int row;
    private int distance = 1;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void moveUp() {
        row = row - distance;
    }

    public void moveDown() {
        row = row + distance;
    }

    public void moveLeft() {
        col = col - distance;
    }

    public void moveRight() {
        col = col + distance;
    }

}