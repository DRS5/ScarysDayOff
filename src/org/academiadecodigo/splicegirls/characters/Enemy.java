package org.academiadecodigo.splicegirls.characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.splicegirls.level.Grid;

public class Enemy {

    private Picture picture;
    private int startingPointCol = 80;
    private int startingPointRow = 400;
    private final int PADDING = 10;
    private int health = 100;
    private int distance = 1;
    private int cellSize = 80;
    private boolean isAlive = true;
    private int col;
    private int row;
    private int damage = 5;
    private Grid grid;

    public Enemy(int col, int row, String picturePath) {

        picture = new Picture(startingPointCol + (col * cellSize + PADDING), startingPointRow + (row * cellSize + PADDING), picturePath);
        picture.draw();
        this.col = col;
        this.row = row;

    }

    public void move(Scary scary) {

        //left

        if (col > scary.getCol()) {
            if (col == 0){
                return;
            }
            col--;
            picture.translate(-cellSize, 0);

        }

        //right

        if (col < scary.getCol()) {
            if (col == grid.getCols()){
                return;
            }
            col++;
            picture.translate(cellSize, 0);

        }

        //up


        if (row > scary.getRow()) {
            if (row == 0){
                return;
            }
            row--;
            picture.translate(0, -cellSize);

        }

        //down


        if (row < scary.getRow()) {
            if(row == grid.getRows()){
                return;
            }
            row++;
            picture.translate(0, cellSize);
        }
    }

    public void attack(Scary scary) throws InterruptedException {

        if(scary.getHealth() > 0) {
            if (scary.getCol() +1 == col && scary.getRow() == row){
                scary.hit(damage);
                System.out.println("scary outch");
            }
            if (scary.getCol() -1 == col && scary.getRow() == row){
                scary.hit(damage);
                System.out.println("scary outch2");
            }
        } else {
            scary.killScary();
        }
    }

    public void hit(int damage) {
        this.health = health - damage;
        System.out.println("Enemy health: " + health);
    }

    public int getHealth() {
        return health;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void killEnemy() {
        isAlive = false;
        this.picture.delete();
    }

    public Grid setGrid(Grid grid){
        return this.grid = grid;
    }

    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }
}

