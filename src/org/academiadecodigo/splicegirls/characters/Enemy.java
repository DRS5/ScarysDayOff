package org.academiadecodigo.splicegirls.characters;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.splicegirls.level.Grid;
import org.academiadecodigo.splicegirls.position.Position;

public class Enemy {

    private Picture picture;
    private Position pos;
    private int health = 100;
    private int distance = 1;
    private int cellSize = 80;
    private final int PADDING = 10;
    private int startingPointCol = 80;
    private boolean isAlive = true;
    private int startingPointRow = 400;
    private int col;
    private int row;
    private Grid grid;

    public Enemy(int col, int row) throws InterruptedException {

        picture = new Picture(startingPointCol + (col * cellSize + PADDING), startingPointRow + (row * cellSize + PADDING), "enemy/enemy1 idle.png");
        picture.draw();
        this.col = col;
        this.row = row;
        pos = new Position(col, row);

    }

    public void move(Scary scary) {

        //left

        if (col > scary.getPos().getCol()) {
            if (col == 1){
                return;
            }
            col--;
            picture.translate(-cellSize, 0);

        }

        //right

        if (col < scary.getPos().getCol()) {
            if (col == grid.getCols()+1){
                return;
            }
            col++;
            picture.translate(cellSize, 0);
            }

        //up


        if (row > scary.getPos().getRow()) {
            if (row == 1){
                return;
            }
            row--;
            picture.translate(0, -cellSize);
        }

        //down


        if (row < scary.getPos().getRow()) {
            if(row == grid.getRows() +1){
                return;
            }
            row++;
            picture.translate(0, cellSize);
        }

    }

    public void enemyAnimation() throws InterruptedException {
        picture.delete();
        picture = new Picture(startingPointCol + (col * cellSize + PADDING), startingPointRow + (row * cellSize + PADDING), "enemy/enemy1 walk.png");
        picture.draw();

    }


    public void attack(Scary scary) throws InterruptedException {
        if (scary.getHealth() > 0) {
            if (scary.getPos().getCol() + 1 == col && scary.getPos().getRow() == row
                    || scary.getPos().getCol() - 1 == col && scary.getPos().getRow() == row) {
                Thread.sleep(600 * 4); // para demorar mais tempo a atacar
                scary.hit(10);
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

    public Position getPos() {
        return pos;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void killEnemy() {
        isAlive = false;
        this.picture.delete();
    }

    public Picture getPicture(){
        return picture;
    }

    public Grid setGrid(Grid grid){
        return this.grid = grid;
    }
}
