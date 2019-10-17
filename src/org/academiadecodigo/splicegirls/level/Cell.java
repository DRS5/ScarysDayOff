package org.academiadecodigo.splicegirls.level;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private Rectangle cell;
    private int cellSize = 80;
    private final int PADDING = 10;
    private int startingPointCol = 80;
    private int startingPointRow = 400;
    private int col;
    private int row;

    public Cell(int col, int row){
        this.col = col;
        this.row = row;

        cell = new Rectangle(startingPointCol + (col * cellSize + PADDING), startingPointRow + (row * cellSize + PADDING), cellSize, cellSize);

    }

}
