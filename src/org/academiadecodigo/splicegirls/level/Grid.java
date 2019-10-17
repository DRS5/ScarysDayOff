package org.academiadecodigo.splicegirls.level;

public class Grid {

    private int cols;
    private int rows;
    private Cell[][] grid;

    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;

        grid = new Cell[cols][rows];

        for (int col = 0; col < cols; col ++){
           for (int row = 0; row < rows; row++){
               grid[col][row] = new Cell(col, row);
           }
        }
    }

    public int getCols(){
        return cols;
    }

    public int getRows(){
        return rows;
    }
}
